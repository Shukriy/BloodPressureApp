package unitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ccol.BloodPressure;
import ccol.Readings;
import ccol.TransmissionObject;
import networking_client.Client;

public class TransmissionTest {
	
	  BloodPressure BP1 = new BloodPressure(180, 120);
	  BloodPressure BP2 = new BloodPressure(155, 99);
	  BloodPressure BP3 = new BloodPressure(120, 100);   
	  BloodPressure BP4 = new BloodPressure(111, 30);
      BloodPressure BP5 = new BloodPressure(134, 80);
      BloodPressure BP6 = new BloodPressure(169, 69);
      
    Date date1 = new Date(12,3,2018);
  	Date date2 = new Date(13,3,2018);
  	Date date3 = new Date(14,3,2018);
  	Date date4 = new Date(15,3,2018);
  	
  	Time time1 = new Time(7, 8, 9);
  	Time time2 = new Time(1, 2, 3);
  	Time time3 = new Time(4, 5, 6);
  	Time time4 = new Time(10, 11, 12);
  	
  	Readings reading = new Readings(12345, date1, time1, BP1, BP2, BP3, BP1, null);
  	
  	TransmissionObject a = new TransmissionObject("dummy", "dummy");
	TransmissionObject b = new TransmissionObject(reading);
	TransmissionObject c = new TransmissionObject("dummy", 6);
	TransmissionObject d = new TransmissionObject("12345", 8);
	TransmissionObject e = new TransmissionObject(12345, 12);
  	
  	
    int type = a.getType();
    Client main = new Client(8080, "127.0.0.1");
	
    @Test
	public void test1() {
		int expected = 3;
		int actual = main.send(a).getType();
		assertEquals(expected, actual);
	}

    @Test
   	public void test2() {
   		int expected = 5;
   		int actual = main.send(b).getType();
   		assertEquals(expected, actual);
   	}

    @Test
   	public void test3() {
   		int expected = 7;
   		int actual = main.send(c).getType();
   		assertEquals(expected, actual);
   	}

    @Test
   	public void test4() {
   		int expected = 9;
   		int actual1 = main.send(d).getType();
   		assertEquals(expected, actual1);
   		int actual2 = main.send(e).getType();
   		assertEquals(expected, actual2);
   	}
  
}
