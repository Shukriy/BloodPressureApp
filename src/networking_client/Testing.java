package networking_client;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;
/**
 * Requires Server and database to be running.
 * Also check with out to e
 * @author Thomas Cunningham
 */
public class Testing {
	@Test
	public void Test1(){
		Communicate.setPortHost(5432, "localhost");
		boolean expected = false;
		boolean actual = Communicate.checkUserName("dummy");
		assertEquals(expected, actual);
	}
	
	@Test
	public void Test2(){
		Communicate.setPortHost(5432, "localhost");
		boolean expected = true;
		boolean actual = Communicate.checkUserName("notInDb");
		assertEquals(expected, actual);
	}
	
	@Test
	public void Test3(){
		Communicate.setPortHost(5432, "localhost");
		String expected = "Dummy";
		String actual = Communicate.getUser("dummy", "dummy").getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void Test4(){
		Communicate.setPortHost(5432, "localhost");
		boolean expected = true;
		boolean actual = Communicate.addUser(new Patient('p', "a", "a", "a", "a", "a", "a", "a", 0, new BloodPressure(120, 80), 0));
		assertEquals(expected, actual);
	}
	
	@Test
	public void Test5(){
		Communicate.setPortHost(5432, "localhost");
		boolean expected = true;
		boolean actual = Communicate.addReading(new Readings(0, new Date(0), new Time(0), new BloodPressure(120,80), new BloodPressure(120,80), new BloodPressure(120,80), new BloodPressure(120,80), "a"));
		assertEquals(expected, actual);
	}
	
	@Test
	public void Test6(){
		Communicate.setPortHost(5432, "localhost");
		boolean expected = true;
		boolean actual = Communicate.addReading(new Readings(0, new Date(0), new Time(0), new BloodPressure(120,80), new BloodPressure(120,80), new BloodPressure(120,80), new BloodPressure(120,80), "a"));
		assertEquals(expected, actual);
	}
}