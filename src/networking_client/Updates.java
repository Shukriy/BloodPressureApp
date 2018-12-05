package networking_client;

import java.util.Observable;

/**
 * Small class for managing changes that occur in the server and driving changes in the model when occurred.
 * This class should be observed for changes and can cause an update when they occur. Will not notify its
 * observers if no changes are found on last check.
 * @author Thomas Cunningham
 *
 */
public class Updates extends Observable{
	
	private static int chchchchanges = 0;
	
	/**
	 * Get the number of changes so far, also used as offset.
	 * @return
	 */
	public int getChanges() {
		return chchchchanges;
	}
	
	/**
	 * Set more changes,that are found. Notifies observers as a result. 
	 * @param changes The number of changes that were found.
	 * @return The number that have presently occurred.
	 */
	public int setChanges(int changes){
		chchchchanges += changes;
		setChanged();
		notifyObservers();
		clearChanged();
		return chchchchanges;
	}
	
}
