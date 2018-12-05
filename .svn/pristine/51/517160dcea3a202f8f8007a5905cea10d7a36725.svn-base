package ccol;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Readings implements Serializable, Comparable<Readings> {
	private static final long serialVersionUID = 2L;
	private int userID;
	private Date date;
	private Time time;
	private BloodPressure rOne;
	private BloodPressure rTwo;
	private BloodPressure rThree;
	private BloodPressure ave;
	private String comments;		// Patient comments on readings
	

	public Readings(int userID, Date date, Time time, BloodPressure rOne, BloodPressure rTwo, BloodPressure rThree, 
			BloodPressure ave, String comments) {

		this.userID = userID;
		this.date = date;
		this.time = time;
		this.rOne = rOne;
		this.rTwo = rTwo;
		this.rThree = rThree;
		this.ave = ave;
		this.date = date;
		this.comments = comments;
	}
	
	public int getUserID() {
		return userID;
	}

	public BloodPressure getrOne() {
		return rOne;
	}

	public BloodPressure getrTwo() {
		return rTwo;
	}

	public BloodPressure getrThree() {
		return rThree;
	}

	public BloodPressure getAve() {
		return ave;
	}

	public Date getDate() {
		return date;
	}
	
	public Time getTime() {
		return time;
	}
	
	public String getComments() {
		return this.comments;
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yy", Locale.ENGLISH);
		String fDate = f.format(date);
		
		SimpleDateFormat tf = new SimpleDateFormat("hh a");
		String fTime = tf.format(time);
		String c = (comments == null) ? "" : " Notes: " + comments;
		
		return fDate + " - " + fTime + ", Ave: " 
				+ ave + c + "\n";
	}
	
	@Override
	public boolean equals (Object r) {
		if (this.rOne != ((Readings) r).getrOne()) return false;
		else if (this.rTwo != ((Readings) r).getrTwo()) return false;
		else if (this.rThree != ((Readings) r).getrThree()) return false;
		else if (this.time != ((Readings) r).getTime()) return false;
		else if (this.date != ((Readings) r).getDate()) return false;
		
		else return true;
	}

	@Override
	public int compareTo(Readings r) {
		int rOne = this.getrOne().compareTo(r.getrOne());
		int rTwo = this.getrTwo().compareTo(r.getrTwo());
		int rThree = this.rThree.compareTo(r.getrThree());
		int time = this.time.compareTo(r.getTime());
		int date = this.date.compareTo(r.getDate());
				
		
		if (date != 0) return date;
		else if (time != 0) return time;
		else if (rOne != 0) return rOne;
		else if (rTwo != 0) return rOne;
		else if (rThree != 0) return rOne;
		else return 0;
		
	}
	
}
