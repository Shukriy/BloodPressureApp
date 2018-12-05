package networking_server;

import java.io.*;
import java.net.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * The main server class that is responsible for fielding networking requests, creating threads for handling these.
 * @author Thomas Cunningham
 *
 */
public class Server {
	
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectInputStream inStream = null;
	private ObjectOutputStream outStream = null;
	private Executor pool = Executors.newCachedThreadPool();
	private int portNumber = 5432, attempts = 0;
	private String addr = "";
	
	/**
	 * Default constructor for the server with no specification
	 */
	public Server() {
	}
	
	/**
	 * Constructor that allows the port for listening on to be specified.
	 * @param portNumber
	 */
	public Server(int portNumber) {
		this.portNumber = portNumber;
		try {
			System.out.println(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Main task of the server.
	 * This listens on the constructor given port for incoming requests from clients.
	 * It prints a message telling the user what port an ip it listen on for easy configuration of the client.
	 * If the socket cannot be made on that port, it will iterate though nearby ones until it finds a suitable one. If after five attempts it is unable,
	 * it will fail and alert the user to troubleshoot.
	 * When a connection is successfully connected it will submit a thread to the executor that handles the request.
	 * This also records changes that occur in the database to be able to quickly alert clients to their occurrence.
	 */
	public void listen() {
		try {
			addr = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		}
		while(attempts < 5) {
			try {
				serverSocket = new ServerSocket(portNumber);
			} catch (IOException e1) {
				System.err.println("Some significant issue with chosen port " + portNumber + ", will attempt another");
			}
			if(serverSocket != null) {
				System.out.println("Server listening on port " + portNumber + ", IP: " + addr);
				while(true) {
					try {
						socket = serverSocket.accept();
						inStream = new ObjectInputStream(socket.getInputStream());
						outStream = new ObjectOutputStream(socket.getOutputStream());
						pool.execute(new RunnableConnection(socket, inStream, outStream));
					} catch (Exception e) {
						
					}
				}
			} else if(serverSocket == null) {
				System.err.println("Socket is null, port " + portNumber + " is likely unsuitable, will attempt another");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				portNumber++;
				attempts++;
			}
		}
		if(attempts >= 5) {
			System.err.println("Five different ports appear to be unsuitable. Attempt a port significantly further than " + portNumber + " or stop running multiple instances of this server on the same computer.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	/**
	 * Sets up the server with the constructor depending on what arguments have been give.
	 * @param args Command line arguments for specifying the port to be used.
	 */
	public static void main(String[] args){
		Server server = null;
		if (args.length == 0) {
			server = new Server();
		} else if (args[0] != null) {
			server = new Server(Integer.parseInt(args[0]));
		} else {
			server = new Server();
		}
		server.listen();
	}
}