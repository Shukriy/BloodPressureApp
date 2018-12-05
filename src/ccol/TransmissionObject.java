package ccol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for specifying the single object that is sent between the server and client.
 * The object contains the information that is being sent, and also the type of request being made.
 * This enforces protocol between client and server when handled by the appropriate classes as it is easy for them to know what the purpose of
 * the information contained is. The password of the user when stored inside is encrypted with AES to keep secure, can only be decrypted
 * when at client of server with their preshared key.
 * @author Thomas Cunningham
 *
 */
public class TransmissionObject implements Serializable{
	/*
	 * Type meanings
	 * 0 = closeConnection
	 * 1 = User credentials for login
	 * 2 = Adding a user
	 * 3 = Returning a user from credentials
	 * 4 = Adding reading
	 * 5 = Operation success boolean
	 * 6 = Check username client-> server
	 * 7 = Is username present server -> client
	 * 8 = Search for patient.
	 * 9 = Patient search results.
	 * 10 = User credentials for login with encrypted password.
	 * 11 = Checking for updates
	 * 12 = Get completed
	 */
	
	private static final long serialVersionUID = -873222147733145721L;
	int type = 0, offsetOrChanges, id;
	String user, password;
	byte[] encPass;
	User userO;
	Readings reading;
	Boolean success;
	ArrayList<Patient> searchResults;
	
	/**
	 * First constructor, for creating and object that requests the user from their username and password.
	 * No longer used now that encryption is implemented, left in place in case of need to fallback.
	 * @param user Username
	 * @param password Password
	 */
	@Deprecated
	public TransmissionObject(String user,
							  String password) {
		type = 1;
		this.user = user;
		this.password = password;
	}
	
	/**
	 * Constructor for requesting the user with a username and ecnrypted password.
	 * @param user Username
	 * @param encPass AES password
	 */
	public TransmissionObject(String user,
			  byte[] encPass) {
		type = 10;
		this.user = user;
		this.encPass = encPass;
	}
	
	/**
	 * Constructor for returning the user.
	 * @param user User object
	 * @param type Type argument for specifying purpose of object
	 */
	public TransmissionObject(User user, int type) {
		this.type = type;
		userO = user;
	}
	
	/**
	 * COnstructor used for adding a reader to the database
	 * @param reading The reading to be added
	 */
	public TransmissionObject(Readings reading) {
		type = 4;
		this.reading = reading;
	}
	
	/**
	 * Constructor for reporting success of an operations, follows a database operation request most often
	 * @param success Boolean indicating success
	 */
	public TransmissionObject(Boolean success) {
		type = 5;
		this.success = success;
	}
	
	/**
	 * Constructor for just checking if a user is present
	 * @param user username of user
	 * @param type specify this is what you want to do
	 */
	public TransmissionObject(String user, int type) {
		this.user = user;
		this.type = type;
		
	}
	
	/**
	 * Constructor for reporting a different sort of success
	 * @param success Boolean indicator
	 * @param type TYpe of operation being checked
	 */
	public TransmissionObject(Boolean success, int type) {
		this.type = type;
		this.success = success;
	}
	
	/**
	 * Constructor for searching for patients matching a username
	 * @param searchResults All patients reported by database to match
	 */
	public TransmissionObject(ArrayList<Patient> searchResults) {
		this.type = 9;
		this.searchResults = searchResults;
	}
	
	/**
	 * Getter for checking the type of this object
	 * @return The type
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Simple constructor for creating the object with just the type
	 * @param type
	 */
	public TransmissionObject(int type) {
		this.type = 0;
	}
	
	/**
	 * Constructor for checking changes that have occured
	 * @param value Either the offset or number of changes depending on which way it is being sent
	 * @param type Specify the purpose of the object
	 */
	public TransmissionObject(int value,
							  int type) {
		if(type == 11) {
			this.type = type;
			this.offsetOrChanges = value;
		} else if(type == 12) {
			this.type = type;
			this.id = value;
		}
		
	}
	
	/**
	 * Getter for user credentials (when logging in). No longer used, replaced with encrypted version
	 * @deprecated
	 * @return Username and password in an array
	 */
	public String[] getUserCredentials() {
		if(type == 1) {
			return new String[] {user, password};
		} else {
			throw new IllegalArgumentException("Transission object was not used for user credentials");
		}
	}
	
	/**
	 * Getter for the user being added
	 * @return The user to be added
	 */
	public User getAdditionalUser() {
		if(type == 2 ) {
			return userO;
		} else {
			throw new IllegalArgumentException("Transission object was not used for adding a user");
		}
	}
	
	/**
	 * Getter for the user being sent back from a request
	 * @return The user requested
	 */
	public User getReturnedUser() {
		if(type == 3 ) {
			return userO;
		} else {
			throw new IllegalArgumentException("Transission object was not used for requesting a user");
		}
	}
	
	/**
	 * Getter for the reading being added
	 * @return The reader being added
	 */
	public Readings getAdditionalReading() {
		if(type == 4) {
			return reading;
		} else {
			throw new IllegalArgumentException("Transission object was not used for adding a reading");
		}
	}
	
	/**
	 * Getter for operation success boolean
	 * @return The oepration succes indicator
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * Getter for the contained username. Used instead of the previous login credentials
	 * @return The username
	 */
	public String getUsername() {
		return user;
	}
	
	/**
	 * Getter for the encrypted password field
	 * @return The encrypted password
	 */
	public byte[] getEncPassword() {
		return encPass;
	}
	
	/**
	 * Getter for the search resaults
	 * @return List of search results
	 */
	public ArrayList<Patient> getSearchResults(){
		return searchResults;
	}
	
	/**
	 * Getter for the ID as an integer rather than String
	 * @return
	 */
	public int getIntId() {
		return this.id;
	}
	
	/**
	 * Getter for the value that is either number of offset, or number of changes.
	 * @return The getter itself.
	 */
	public int getOffsetOrChanges() {
		return this.offsetOrChanges;
	}
}
