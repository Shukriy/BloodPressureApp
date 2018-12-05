package ccol;

import java.io.Serializable;

public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	protected int userID;
	protected char role;
	private String userName;
	private String pass;
	private String title;
	private String firstName;
	private String surName;
	
	public User(char role, String userName, String pass, String title, String firstName, 
			String surName) {
		
		this.role = role;
		this.userName = userName;
		this.pass = pass;
		this.title = title;
		this.firstName = firstName;
		this.surName = surName;
	}
	
	public User(int userID, char role, String userName, String pass, String title, String firstName, 
			String surName) {		
		this.role = role;
		this.userID = userID;
		this.userName = userName;
		this.pass = pass;
		this.title = title;
		this.firstName = firstName;
		this.surName = surName;
	}

	public int getUserID() {
		return userID;
	}

	public char getRole() {
		return role;
	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}
	
	public void setUserID (int id) {
		this.userID = id;
	}

	@Override
	public String toString() {
		return title + " " + firstName + " " + surName;
		}	
	
}
