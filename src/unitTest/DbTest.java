package unitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;
import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;
import db.Db;


public class DbTest {
	
	Db db = new Db();
	
	/**
	 * Tests the getUser Method
	 */
	@Test
	public void test1() {	
		Patient p = (Patient) db.getUser("dummy", "dummy");
		String actual = p.getSurName();
		String expected = "McDummyFace";
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {
		Patient p = (Patient) db.getUser("lord", "voldemort");
		Patient actual = p;
		Patient expected = null;
		
		assertEquals(expected, actual);
	}
	
	/** Tests getUser, addReadings and updateRemaining methods
	 * 
	 */
	@Test
	public void test3() {
		BloodPressure BP1 = new BloodPressure(180, 120);
		BloodPressure BP2 = new BloodPressure(155, 99);
		BloodPressure BP3 = new BloodPressure(120, 100);   
		BloodPressure BP4 = new BloodPressure(111, 30);
		BloodPressure BP5 = new BloodPressure(134, 80);
		BloodPressure BP6 = new BloodPressure(169, 69);
		
		Date date1 = new Date(12,3,2018);
		Time time1 = new Time(7, 8, 9);
		Readings reading1 = new Readings(2, date1, time1, BP1, BP2, BP3, BP1, null);
		
		Patient p = db.getUser("dummy", "dummy");
		int remBefore = p.getrRemaining();
		
		db.addReading(reading1);
		p = db.getUser("dummy", "dummy");
		int remAfter = p.getrRemaining();
		int dif = remBefore - remAfter;		
		
		assertEquals(1, dif);
		

	}

	/**
	 * Tests the checkUsername method
	 */
	@Test
	public void test4() {
		boolean actual1 = db.checkUserName("dummy");
		boolean actual2 = db.checkUserName("voldemort");
		
		boolean expected1 = false;
		boolean expected2 = true;
		
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
	}
}
