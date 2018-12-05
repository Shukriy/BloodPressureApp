package networking_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ccol.*;
import db.Db;
import aesEncryption.AES;

/**
 * The threaded task that is run by the server when new connections are found. This handles all incoming requests.
 * @author Thomas Cunningham
 *
 */
public class RunnableConnection implements Runnable{
	Socket socket;
	ObjectInputStream is;
	ObjectOutputStream os;
	TransmissionObject recieved, send;
	Db db;
	
	/**
	 * The constructor for the task, used by the server to create this task with its required information for handling an incoming request.
	 * @param socket The socket the incoming connection is on.
	 * @param is The inputstream of that connection.
	 * @param os The output stream of that connection.
	 * @throws ClassNotFoundException Thrown if it receives an object that is not does not have a class that it can cast it too.
	 * @throws IOException Thrown when connection errors occur.
	 */
	public RunnableConnection(Socket socket,
							  ObjectInputStream is,
							  ObjectOutputStream os) throws ClassNotFoundException, IOException {
		this.socket = socket;
		this.is = is;
		this.os = os;
	}
	
	/**
	 * The main runnable task. Handles the receiving and sending information.
	 */
	@Override
	public void run() {
			try {
				recieved = (TransmissionObject) is.readObject();
				db = new Db();
				handleTransmission();
				db.finalize();
				os.writeObject(send);
				os.flush();
				os.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
	}
	
	/**
	 * Calls the appropriate method for the request.
	 */
	public void handleTransmission() {
		if(recieved.getType() == 2) {
			addUser();
		}
		if(recieved.getType() == 3) {
			getUser();
		}
		
		if(recieved.getType() == 4) {
			addReading();
		}
		if(recieved.getType() == 6) {
			checkUsername();
		}
		if(recieved.getType() == 8) {
			searchForPatient();
		}
		if(recieved.getType() == 10) {
			attemptEncLogin();
		}
		if(recieved.getType() == 11) {
			checkChanges();
		}
		if(recieved.getType() == 12) {
			getCompleted();
		}
	}
	
	/**
	 * Decrypt and attempt a login with receieved credentials.
	 */
	private void attemptEncLogin() {
		byte[] encPass = recieved.getEncPassword();
		String decPass = null;
		try {
			decPass = AES.decrypt(encPass);
		} catch (Exception e) {
			System.err.println("Failed to decrypt password");
			e.printStackTrace();
		}
		send = new TransmissionObject(db.getUser(recieved.getUsername(), decPass), 3);
	}
	
	/**
	 * Adds a use to the database.
	 */
	private void addUser() {
		if(recieved.getAdditionalUser().getRole() == 'p') {
			db.addUser((Patient)recieved.getAdditionalUser());
		} else if (recieved.getAdditionalUser().getRole() == 'l') {
			db.addUser((Doctor)recieved.getAdditionalUser());
		}
		send = new TransmissionObject(true);
	}
	
	/**
	 * Adds a reading to the database
	 */
	private void addReading	() {
		db.addReading(recieved.getAdditionalReading());
		Changes.addChange();
		send = new TransmissionObject(true);
	}
	
	/**
	 * Gets user from the database.
	 */
	private void getUser() {
		send = new TransmissionObject(db.getUser(recieved.getUserCredentials()[0], recieved.getUserCredentials()[1]), 3);
	}
	
	/**
	 * Check username for presence in the database.
	 */
	private void checkUsername() {
		send = new TransmissionObject(db.checkUserName(recieved.getUsername()), 7);
	}
	
	/**
	 * Search for a patient in the database by partial username.
	 */
	private void searchForPatient() {
		send = new TransmissionObject(db.searchUser(recieved.getUsername()));
	}
	
	/**
	 * Gets list of completed readings from the database;
	 */
	private void getCompleted() {
		send = new TransmissionObject(db.getCompleted(recieved.getIntId()));
	}
	
	/**
	 * Checks for changes in the database.
	 */
	private void checkChanges() {
		send = new TransmissionObject(Changes.numberOfChanges(recieved.getOffsetOrChanges()), 11);
	}
}
