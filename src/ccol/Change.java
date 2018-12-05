package ccol;

/**
 * This class specifies the nature of a change that's made to the server. Currently only used to measure a change of any sort, but can be expanded to
 * be specific about the nature of changes.
 * @author Thomas Cunningham
 *
 */
public class Change {

	boolean addUser, addReading, generic = false, readingCompleted;
	int userID, offset;
	
	/**
	 * One of the constructors, allows the specific type of change to be recorded, currently not used.
	 * @param type Type of change
	 * @param userID The ID of the user who caused the change.
	 * @param offset If needed, an offset can be recorded
	 */
	public Change(int type,
				  int userID,
				  int offset) {
		if(type == 0) {
			addUser = true;
			addReading = false;
			readingCompleted = false;
		} else if (type == 1) {
			addUser = false;
			addReading = true;
			readingCompleted = false;
		} else if (type == 2) {
			readingCompleted = true;
			addUser = false;
			addReading = false;
		}
		this.userID = userID;
		this.offset = offset;
	}
	
	/**
	 * A constructor for adding generic changes where the ontology does not need to be recorded
	 */
	public Change() {
		this.generic = true;
	}
	
	/**
	 * Getter for the type of change, not used
	 * @return if it was used for adding a user
	 */
	public boolean isAddUser() {
		return addUser;
	}
	
	/**
	 * Getter for if its adding a reading
	 * @return Whether it adds a reading
	 */
	public boolean isAddReading() {
		return addReading;
	}
	
	/**
	 * Getter for generic changes
	 * @return Whether the change was of no specific type
	 */
	public boolean isGeneric() {
		return generic;
	}
	
	/**
	 * Get the ID of the user responsible
	 * @return
	 */
	public int getUserID() {
		return userID;
	}
	
	/**
	 * Get the offset
	 * @return The offset
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * Print the contents in a user readable way
	 */
	public String toString() {
		String type = "";
		if(addReading) {
			type = "added a reading";
		} else if (addUser) {
			type = "added a user";
		}
		return "This change " + type + ". This relates to" + getUserID() + ". This was change/offset " + offset;
	}
	
}
