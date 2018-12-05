package networking_client;

/**
 * This class specifies a runnable task that ensures the updating of the application when new information is added to the database.
 * It is made use of in the 'Communicate' class where it is submitted to an Executor.
 * It updates the class 'Updates' when changes are found.
 * @author Thomas Cunningham
 *
 */
public class UpdateHandler implements Runnable{
	
	Updates main = null;
	int currentChanges = 0, recievedChanges = 0;;
	
	public UpdateHandler(Updates main) {
		this.main = main;
		currentChanges = main.getChanges();
	}
	
	/**
	 * The run method for containing the task for checking for updates.
	 */
	@Override
	public void run() {
		while(true) {
			recievedChanges = Communicate.getChanges(currentChanges);
			if(recievedChanges != currentChanges) {
				currentChanges = main.setChanges(recievedChanges);
				System.out.println("Changes are different");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.err.println("Insomnia");
				e.printStackTrace();
			}
		}
	}

}
