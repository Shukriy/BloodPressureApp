package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import db.Db;
import ccol.*;

public class SampleObjects {
	public static BloodPressure bp1 = new BloodPressure (120, 80);
	public static BloodPressure bp2 = new BloodPressure (150, 73);
	public static BloodPressure bp3 = new BloodPressure (182, 62);
	public static BloodPressure ave1 = new BloodPressure (151, 72);
	
	public static BloodPressure bp4 = new BloodPressure (193, 82);
	public static BloodPressure bp5 = new BloodPressure (162, 92);
	public static BloodPressure bp6 = new BloodPressure (128, 49);
	public static BloodPressure ave2 = new BloodPressure (161, 74);
	
	static SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date d1;
	public static Date d2;
	
	public static <T extends User> T getUser (String user, String pass) {
		Db db = new Db();
		T us;
		
		ccol.Patient p = null;
		ccol.Doctor d = null;
		try {			
			us = db.getUser(user, pass);
			if (us == null) return null;
			if (us.getRole() == 'p') {
				p = (Patient) us;
			} else if (us.getRole() == 'd') {
				d = (Doctor) us;
			}
		} finally {	
			db.finalize();
		}
		if (p!=null) return (T) p;
		if (d!=null) return (T) d;
		else return null;
	}
	
	public static boolean checkUserName (String userName) {
		Db db = new Db();
		
		boolean r;
		try {
			r = db.checkUserName(userName);
		} finally {
			db.finalize();
		}
		
		return r;
	}
	
	public static <T extends User> void addUser ( T user) {
		Db db = new Db();
		
		Patient p = null;
		Doctor d = null;
		try {
			if (user == null) return;
			if (user.getRole() == 'p') {
				p = (Patient) user;
				db.addUser(p);
			} else if (user.getRole() == 'd') {
				d = (Doctor) user;
				db.addUser(d);
			}
		} finally {	
			db.finalize();
		}
	}
	
	public static void addReading (Readings r) {
		Db db = new Db();
		
		try {
			db.addReading(r);
		} finally {	
			db.finalize();
		}
	}
	
	public static ArrayList<Patient> searchUser (String id) {
		Db db = new Db();
		ArrayList<Patient> result;
		try {			
			result = db.searchUser(id);
		} finally {	
			db.finalize();
			
		}
		return result;
	}
	
	
}
