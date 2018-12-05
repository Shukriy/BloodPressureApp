package ccol;

import java.io.Serializable;
import java.util.Comparator;

/** This class stores the Blood Pressure objects.
 * @author Abdullah Ali
 *
 */
public class BloodPressure implements Serializable, Comparable<BloodPressure> {
	private static final long serialVersionUID = -4125444044241656051L;
	private int sys;
	private int dias;
	
	/**
	 * @param sys Systolic (The bigger number)
	 * @param dias Diastolic (The smaller number)
	 */
	public BloodPressure(int sys, int dias) {
		this.sys = sys;
		this.dias = dias;
	}
	public int getSys() {
		return sys;
	}
	public int getDias() {
		return dias;
	}
	@Override
	public String toString() {
		return sys + "/" + dias;
	}
	@Override
	public int compareTo(BloodPressure b) {
		int sys = ((Integer) this.getSys()).compareTo((Integer) b.getSys());
		int dias = ((Integer) this.getDias()).compareTo((Integer) b.getDias());
		
		if (sys != 0) return sys;
		else return dias;
	}
	
	@Override
	public boolean equals (Object b) {
		boolean sys = (this.getSys() == ((BloodPressure) b).getSys()) ? true : false;
		boolean dias = (this.getDias() == ((BloodPressure) b).getDias()) ? true : false;
		
		if (sys == false) return sys;
		else return dias;
	}
	
}
