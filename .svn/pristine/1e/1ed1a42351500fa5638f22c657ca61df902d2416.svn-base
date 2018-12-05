package networking_client;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import ccol.*;
import aesEncryption.*;

/**
 * Wrapper for networking functionality. The model can simply use these methods for requesting or sending required information. This also handles automatic updating
 * and configures networking specification given by command line arguments to the main class.
 * @author Thomas Cunningham
 *
 */
public class Communicate {
	private static Executor pool = Executors.newCachedThreadPool();
	private static UpdateHandler updater = null;
	private static int staticPort;
	private static String staticHost;
	
	/**
	 * Networking wrapper for retrieving a user from the database by their username and password.
	 * User for users logging in.
	 * @param user The username of user.
	 * @param password The password of the user.
	 * @return Either Patient or Doctor subclasses of the abstract class User dependent on the defined role.
	 */
	public static User getUser(String user, String password) {
		byte[] encPass = null;
		Client main = new Client(staticPort, staticHost);
		System.out.println("created new client");
		TransmissionObject recieved;
		try {
			encPass = AES.encrypt(password);
		} catch (Exception e) {
		}
		recieved = main.send(new TransmissionObject(user, encPass));
		System.out.println("sent details");
		if(recieved.getType() == 3) {
			return recieved.getReturnedUser();
		} else {
			throw new IllegalArgumentException("Transission object was not used for requesting a user");
		}
	}
	
	/**
	 * Networking wrapper for adding a user to the database.
	 * @param user The user to be added to the database.
	 * @return Boolean representing whether the operation was successful.
	 */
	public static boolean addUser(User user) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(user, 2));
		if(recieved.getType() == 5) {
			return recieved.isSuccess();
		} else {
			throw new IllegalArgumentException("Transission object was not used for reporting operation success");
		}
	}
	
	/**
	 * Networking wrapper for adding a reading to the database.
	 * @param reading The reading to be added to the database.
	 * @return Boolean representing whether the operation was successful.
	 */
	public static boolean addReading(Readings reading) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(reading));
		if(recieved.getType() == 5) {
			return recieved.isSuccess();
		} else {
			throw new IllegalArgumentException("Transission object was not used for reporting operation success");
		}
	}
	
	/**
	 * Networking wrapper for checking whether a user is in the database via their username.
	 * @param userName The username to be checked.
	 * @return Boolean representing whether the user is present or not.
	 */
	public static boolean checkUserName (String userName) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(userName, 6));
		if(recieved.getType() == 7) {
			return recieved.isSuccess();
		} else {
			throw new IllegalArgumentException("Transission object was not used for reporting operation success, its type was: " + recieved.getType());
		}
	}
	
	/**
	 * Networking wrapper for sending search requests as doctor types username into search bar
	 * @param id id of the user being searched
	 * @return ArrayList<Patient> of results from search
	 */
	public static ArrayList<Patient> searchUser (String id) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(id, 8));
		if(recieved.getType() == 9) {
			return recieved.getSearchResults();
		} else {
			throw new IllegalArgumentException("Transission object was not used for reporting operation success");
		}
	}
	
	/**
	 * Gets a a list of patients that have completed their readings.
	 * @param id The ID of the patients to be checked.
	 * @return The list of patients with completed readings.
	 */
	public static ArrayList<Patient> getCompleted (int id) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(id, 12));
		if(recieved.getType() == 9) {
			return recieved.getSearchResults();
		} else {
			throw new IllegalArgumentException("Transission object was not used for reporting operation success");
		}
	}
	
	/**
	 * Network wrapper for checking for updates to the database.
	 * @param The offset of the number of updates
	 * @return The number of updates that have occurred since offset.
	 */
	public synchronized static int getChanges(int offset) {
		Client main = new Client(staticPort, staticHost);
		TransmissionObject recieved;
		recieved = main.send(new TransmissionObject(offset, 11));
		if(recieved.getType() == 11) {
			return recieved.getOffsetOrChanges();
		} else {
			throw new IllegalArgumentException("Transission object was not used for checking changes");
		}
	}
	
	/**
	 * Create an Updates object, submit it to this to start. Observe updates from it.
	 * @param updatek
	 */
	public static void startUpdater(Updates update) {
		updater = new UpdateHandler(update);
		pool.execute(updater);
	}
	
	/**
	 * Used on close to keep the updater from causing issues.
	 */
	public static void stopUpdater() {
		try {
			pool.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Used for specifying the connection details to find the server.
	 * @param port The port the server listens on
	 * @param host The hostname of the server.
	 */
	public static void setPortHost(int port, String host) {
		staticPort = port;
		staticHost = host;
	}
}