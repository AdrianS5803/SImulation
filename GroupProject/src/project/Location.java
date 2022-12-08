package project;

public class Location{
	private App[] applications;
	private int numAppliactions;
	private boolean brownOut; // flag to indicate brown out condition

	public Location(App[] getApp, int getNumApp){
		//numAppliactions=getNumApp;
		applications = new App[20];
		brownOut = false;
	}

	/**
	 * @return the applications
	 */
	public App[] getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(App[] applications) {
		this.applications = applications;
	}

	/**
	 * @return the brownOut
	 */
	public boolean isBrownOut() {
		return brownOut;
	}

	/**
	 * @param brownOut the brownOut to set
	 */
	public void setBrownOut(boolean brownOut) {
		this.brownOut = brownOut;
	}

	// method to get the array of locations in the building
	

	// method to add a location to the building
	

	// method to remove a location from the building
	

	// method to check for brown out condition
	public void checkBrownOut(int maxPower){
		int totalPower = 0;
		
		if(totalPower > maxPower){
			brownOut = true;
			// take appropriate action for brown out condition
		}
	}

}
