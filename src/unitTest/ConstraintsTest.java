package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GUI.Constraints;

public class ConstraintsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int sys = 200;
		boolean expected1 = true;
		boolean actual1 = Constraints.checkSys(sys);
		assertEquals(expected1, actual1);
		
		int sys1 = 350;
		boolean expected2 = false;
		boolean actual2 = Constraints.checkSys(sys1);
		assertEquals(expected2, actual2);
		
		int sys2 = 20;
		boolean expected3 = false;
		boolean actual3 = Constraints.checkSys(sys1);
		assertEquals(expected3, actual3);
	}

	@Test
	public void test2() {
		int dias = 120;
		boolean expected1 = true;
		boolean actual1 = Constraints.checkDias(dias);
		assertEquals(expected1, actual1);
		
		int dias1 = 250;
		boolean expected2 = false;
		boolean actual2 = Constraints.checkDias(dias1);
		assertEquals(expected2, actual2);
		
		int dias2 = 10;
		boolean expected3 = false;
		boolean actual3 = Constraints.checkDias(dias2);
		assertEquals(expected3, actual3);
	}
	
	@Test
	public void test3() {
		String first1 = "dummy";
		String last1 = "dummy";
		boolean expected1 = true;
		boolean actual1 = Constraints.checkName(first1, last1);
		assertEquals(expected1, actual1);
		
		String first2 = "dummydddddddddddddddddddd";
		String last2 = "dummy";
		boolean expected2 = false;
		boolean actual2 = Constraints.checkName(first2, last2);
		assertEquals(expected1, actual1);
	}


	@Test
	public void test4() {
		String user1 = "dummy";
		boolean expected1 = true;
		boolean actual1 = Constraints.checkUserName(user1);
		assertEquals(expected1, actual1);
		
		String user2 = "dummy";
		boolean expected2 = true;
		boolean actual2 = Constraints.checkUserName(user2);
		assertEquals(expected2, actual2);
		
	}

	@Test
	public void test5() {
		int day = 32;
		boolean expected1 = true;
		boolean actual1 = Constraints.checkDay(day);
		assertEquals(expected1, actual1);
		
		int day1 = 0;
		boolean expected2 = false;
		boolean actual2 = Constraints.checkDay(day1);
		assertEquals(expected2, actual2);
		
		int day2 = 35;
		boolean expected3 = false;
		boolean actual3 = Constraints.checkDay(day2);
		assertEquals(expected3, actual3);
		
	}

	@Test
	public void test6() {
		String pass = "1234456789";
		boolean expected1 = true;
		boolean actual1 = Constraints.checkPassword(pass);
		assertEquals(expected1, actual1);
		
		String pass1 = "";
		boolean expected2 = false;
		boolean actual2 = Constraints.checkPassword(pass1);
		assertEquals(expected2, actual2);
		
		String pass2 = "1287461872478723478217489126481726479124782917492187472147218974981274";
		boolean expected3 = false;
		boolean actual3 = Constraints.checkPassword(pass2);
		assertEquals(expected3, actual3);
		
	}
	
}
