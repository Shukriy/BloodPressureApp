package networking_client;

import java.io.*;
import java.net.*;

import ccol.TransmissionObject;

/**
 * The primary class used for networking. This is wrapped by the communicate class for easy use by the model.
 * @author Thomas Cunningham
 *
 */
public class Client {
	
	private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	private TransmissionObject recieved = null;
	private boolean isConnected = false, isSent = false;
	private String host;
	private int port;
	
	/**
	 * The single constructor for establishing the client. Allows for the port and hostname/IP of the server to be specified. This is taken as an argument
	 * via the main class when run. An error message is printed (elsewhere) if this information is not given.
	 * @param port
	 * @param host
	 */
	public Client(int port,
				  String host) {
		this.port = port;
		this.host = host;
	}
	
	/**
	 * The singular method used for sending and then receiving the objects with requests and information.
	 * This method also manages connection issues with the server. It will reattempt the sending of its
	 * object with decreasing frequency if the connection to the server cannot be made, if it is not after
	 * a reasonable period of time it ceases and returns a null object to signal failure.
	 * @param to The object that is to be sent
	 * @return The object that is recieved.
	 */
	public TransmissionObject send(TransmissionObject to) {
		int sleepCounter = 1;
		TransmissionObject rt = null;
		isSent = false;
		while(!isSent){
			while (!isConnected) {
				System.out.println("trying to connect");
				try {
					socket = new Socket(host, port);
					System.out.println("Connected");
					isConnected = true;
					outputStream = new ObjectOutputStream(socket.getOutputStream());
					inputStream = new ObjectInputStream(socket.getInputStream());
					outputStream.writeObject(to);
					recieved = (TransmissionObject)inputStream.readObject();
					outputStream.flush();
					outputStream.close();
					isSent = true;
					rt = recieved;
				} catch (Exception se) {
					for(int i = sleepCounter; i > 0; i--){
						System.err.println("Attempting to recontact server, retrying in " + i + " seconds");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
					}
					sleepCounter *= 4;
					if(sleepCounter > 100){
						isConnected = true;
						isSent = true;
					}
				}
			}
		}
		return rt;
	}
}
