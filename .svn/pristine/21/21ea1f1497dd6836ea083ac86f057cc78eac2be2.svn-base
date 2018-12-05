package ccol;
import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;

/** This class can be used to store a doctor User object.
 * @author Abdullah Ali
 *
 */
public class Doctor extends User implements Serializable{
	private static final long serialVersionUID = 20L;
	// Contains all the patients who have completed their readings
	private LinkedBlockingQueue<Patient> pCompleted = new LinkedBlockingQueue<Patient>();
	
	/**
	 * @param role User role. Set to 'd' for Doctor
	 * @param userName Username of the user
	 * @param pass Password of the user
	 * @param title Title
	 * @param firstName Firstname
	 * @param surName Surname
	 */
	public Doctor(char role, String userName, String pass, String title, String firstName, String surName) {
		super(role, userName, pass, title, firstName, surName);
		this.role = 'd';
	}

	/**
	 * @return List of all the patients whom have completed their readings
	 */
	public LinkedBlockingQueue<Patient> getpCompleted() {
		return pCompleted;
	}

	public void setpCompleted(LinkedBlockingQueue<Patient> pCompleted) {
		this.pCompleted = pCompleted;
	}
	
	public String toString() {
		return "Doctor: " + super.toString();	
	}
	
}
