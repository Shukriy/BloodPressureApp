package ccol;
import java.io.Serializable;
import java.util.ArrayList;

/** This class can be used to store patient Users.
 * @author Abdullah Ali
 *
 */
public class Patient extends User implements Serializable{
	private static final long serialVersionUID = 30L;
	private String dob;			// Date of birth of. Stored in format: DDMMYYYY
	private String nhsNumber = "";		// Optional
	private String address;		// Address of patient.
	private int doctorID;		// The doctor to which the patient belongs.
	private BloodPressure target;
	private ArrayList <Readings> readings = new ArrayList <Readings>();
	private int rRemaining;		// Readings Remaining.
	private boolean completed = false;		// Changes to true if all readings have been completed.

	
	// Client-Side constructor will not have userID in constructor
	public Patient(char role, String userName, String pass, String title, String firstName, String surName,
			String dob, String address, int doctorID, BloodPressure target,	int rRemaining) {
		
		super(role, userName, pass, title, firstName, surName);
		this.dob = dob;
		this.address = address;
		this.doctorID = doctorID;
		this.target = target;
		this.rRemaining = rRemaining;
	}	

	public Patient(char role, String userName, String pass, String title, String firstName, String surName,
			String dob, String nhsNumber, String address, int doctorID, BloodPressure target, int rRemaining) {
		
		super(role, userName, pass, title, firstName, surName);
		this.dob = dob;
		this.nhsNumber = nhsNumber;
		this.address = address;
		this.doctorID = doctorID;
		this.target = target;
		this.rRemaining = rRemaining;
	}



	public ArrayList<Readings> getReadings() {
		return readings;
	}

	public void setReadings(ArrayList<Readings> readings) {
		this.readings = readings;
	}

	public void addReading(Readings reading) {
		readings.add(reading);
	}

	public String getDob() {
		return dob;
	}
	
	public String getDobString() {
		String fDob = dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" 
				+ dob.substring(4, dob.length());
		return fDob;
	}

	public String getNhsNumber() {
		return nhsNumber;
	}

	public String getAddress() {
		return address;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public BloodPressure getTarget() {
		return target;
	}

	public int getrRemaining() {
		return rRemaining;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		String fDob = dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" 
					+ dob.substring(4, dob.length());
		
		return "Patient: " + super.toString() + ", " + fDob + " \n"
				+ "Address: " + address	+ " \n"
				+ "Target: " + target + " \n";
				
	}
	
	
	
}
