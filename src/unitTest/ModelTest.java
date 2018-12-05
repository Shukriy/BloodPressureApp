package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Model;
import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;


public class ModelTest {
    BloodPressure BP1 = new BloodPressure(180, 120);
    BloodPressure BP2 = new BloodPressure(155, 99);
    BloodPressure BP3 = new BloodPressure(120, 100);   
    BloodPressure BP4 = new BloodPressure(111, 30);
    BloodPressure BP5 = new BloodPressure(134, 80);
    BloodPressure BP6 = new BloodPressure(169, 69);
	
    Patient patient1 = new Patient('p', "dummy", "12345", "Mr", "dummy", "dduummyy", "01012011", 
			"new street", 13579, BP1, 0);
	Patient patient2 = new Patient('p', "dummy", "12345", "Mr", "dummy", "dduummyy", "01012011", 
			"new street", 13579, BP2, 12);
	
	Date date1 = new Date(12,3,2018);
	Date date2 = new Date(13,3,2018);
	Date date3 = new Date(14,3,2018);
	Date date4 = new Date(15,3,2018);
	
	Time time1 = new Time(7, 8, 9);
	Time time2 = new Time(1, 2, 3);
	Time time3 = new Time(4, 5, 6);
	Time time4 = new Time(10, 11, 12);
	
	
	Readings reading1 = new Readings(12345, date1, time1, BP1, BP2, BP3, BP1, null);
	Readings reading2 = new Readings(12345, date2, time2, BP2, BP3, BP1, BP1, null);
	Readings reading3 = new Readings(12345, date4, time3, BP1, BP1, BP1, BP1, null);
	Readings reading4 = new Readings(12345, date4, time4, BP2, BP3, BP1, BP1, null);
	
	
	ArrayList<BloodPressure> average = new ArrayList<BloodPressure>();
	ArrayList<Readings> readings = new ArrayList<Readings>();
	
	@Test
	public void test1() {	
		patient1.addReading(reading1);
		patient1.addReading(reading2);
		readings.add(reading1);
		readings.add(reading2);
		ArrayList<Readings> expected = readings;
		ArrayList<Readings> actual = patient1.getReadings();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {

		
		patient2.addReading(reading3);
		patient2.addReading(reading1);
		patient2.addReading(reading4);
		Model m = null;
		try {
			m = new Model(patient2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BloodPressure expected = new BloodPressure(180,120);
		BloodPressure actual = m.getAvgSystolic(patient2);
		assertEquals(expected, actual);
	}
	
}
