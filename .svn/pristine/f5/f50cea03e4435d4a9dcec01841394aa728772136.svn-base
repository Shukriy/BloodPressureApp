package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JList;

import ccol.BloodPressure;
import ccol.Doctor;
import ccol.Patient;
import ccol.Readings;
import ccol.User;
import networking_client.Communicate;

public class Model extends Observable {
	
	private Patient patient;
	private Doctor doctor;
	private User user;
	private ArrayList<Patient> compatients;
	private static ArrayList<BloodPressure> average;
	private static ArrayList<Readings> readings;

	public Model(User user) throws java.io.IOException{		
		this.user = user;		
	}
	
	public Model() {
		
	}
	
	//method to check whether the username and password exists(for login page)
	public boolean authentication(String userName, String password) {
		
		user = Communicate.getUser(userName, password);
		
		if (user==null)
			return false;
		
		else return true;
		//setChanged();
		//notifyObservers();
	}

	//method to check user type to open the correct homepage (Login page)
	public char typeUser(User user) {
		return user.getRole();
	} 
	
	//Returns Arraylist of all users that match the user UserDetails
	//This method is used in the DoctorHome Page for searching patient (Doctor home page)
	public static ArrayList<Patient> searchUser(String name){
		return Communicate.searchUser(name);
	}
	
	
	//this method is used when we want to getUser details and for this we need the username and password (Doctor home page)
	public static String getNameNPassword(JList list1, User user) {
		
		String id =String.valueOf(user.getUserID());
		ArrayList<Patient> patientP = Communicate.searchUser(id);
		int i =list1.getSelectedIndex();
		String name = patientP.get(i).getUserName();
		String password = patientP.get(i).getPass();
		
		return name + " " + password;
	}
	
	//this method call for the getUser method and returns user object(Doctor home page)
	public static User getUserObject(String username, String password) {
		
		return Communicate.getUser(username, password);
	}
	
	//This method is to add new patient
	public void addNewPatient(String username, String password, String title, String firstname, String surname, String dob, 
								String address, BloodPressure target, String NHS, int readingleft) {
		
//		User newUser = new User(username, password, title, firstname, surname, 
//				dob, address, target, NHS, readingleft);
//		
//		patient = Communicate.addUser(newUser);
	}
	
	//The method returns a list of the patients that have completed their Reading
	//we have to consider what happens to the this list after the doctor has dealt with (Doctor home page)
	public User[] getComplReading(int DoctorId) {
		return null;
		
//		return Communicate.getComplet(DoctorId).toArray();
	}
	
	// This method is used to dispay the graph (Patient home page)
	public ArrayList<Readings> getReadings() {
		
		return patient.getReadings();
	}
	
	//This method is used to add readings to database (Patient home page)
	public boolean addReading(Readings reading) {
		
		return Communicate.addReading(reading);
	}
	
	//gets the Target Diastolic of patient
	public int getTargetDiastolic() {
		return patient.getTarget().getDias();
	}
	
	// gets the Target Systolic of patient
	public int getTargetSystolic() {
		return patient.getTarget().getSys();
	}
	
	//ArrayList of all average of readings the patient uploaded
		public static ArrayList<BloodPressure> AVG(){
			
		average = new ArrayList<BloodPressure>();
			for(int i=0; i< readings.size(); i++) {
				average.add(readings.get(i).getAve());
			}
			return average;
		}
		
	//gets the average Diastolic of patient
	public int getAvgDiastolic() {
		int sum = 0;
		for(int i=0; i< average.size(); i++) {
			sum = sum + average.get(i).getDias();
			
		}
		return sum/average.size();
	}
	
	//gets the average Systolic of patient
	public BloodPressure getAvgSystolic(Patient patient) {
		int sumS = 0;
		int sumD = 0;
		ArrayList<Readings> avarage = patient.getReadings();
		for (int i = 0; i < avarage.size(); i++) {
			sumS+= avarage.get(i).getAve().getSys();
			sumD+= avarage.get(i).getAve().getDias();
		}
		int avgS =sumS/avarage.size();
		int avgD =sumD/avarage.size();
		BloodPressure avgBP = new BloodPressure(avgS,avgD);
		return avgBP;
	}
	
	public static BloodPressure MAX() {
		int max = 0;
		int i;
		for (i = 0; i < average.size(); i++) {   
			if (max < average.get(i).getSys()); 
				max = average.get(i).getSys(); 
		}
		return average.get(i);
		
	}
	
	public static BloodPressure MIN() {
		int min = 0;
		int i;
		for (i = 0; i < average.size(); i++) {   
			if (min > average.get(i).getDias()); 
				min = average.get(i).getDias(); 
		}
		return average.get(i);
	}
		
	
	//gets the number of readings left for the patient
		public int getNoReadingLeft() {
			return patient.getrRemaining();
		}
		
		public Date lastDate() {
			if (!readings.isEmpty()) {
				int i = readings.size();
				i = (i > 1) ? i-1 : i;
//				lastDate.setText(readings.get(i-1).getDate().toString());
		}
			return null;
		}
		
		

}
