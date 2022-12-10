package project;

public class Location {
	private App[] applications;
	private App[] onArray;
	private int numAppliactions;
	// private boolean brownOut; // flag to indicate brown out condition

	public Location() {
		// numAppliactions=getNumApp;
		applications = new App[2000];
		
		// brownOut = false;
	}

	/**
	 * @return the applications
	 */
	public App[] getApplications() {
		return applications;
	}

	public App getApplication(int index) {
		return applications[index];
	}

	public int getTotalWattage() {
		int total = 0;
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			if (applications[i].isItOn())
				total += applications[i].getwattageOn();
		}
		return total;
	}

	public void brownOutLocation(int location) {
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null)
				break;
			if (applications[i].getlocationID() == location) {
				applications[i].setonnwattage(0);
			}
		}

	}
	public void setOnArray(App app[]) {
		App[] oneTempApp = new App[2000];
		
		int k = 0;
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			if(applications[i].isItOn()&&applications[i].getappliancetype()) {
				oneTempApp[k]=applications[i];
				k++;
			}
		}
		App[] twoTempApp = new App[k];
		twoTempApp[0]=oneTempApp[0];
		int left = 0;
		int right = k;
		for (int i = 0; i < right+1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < right; j++) {
                if (oneTempApp[j].getwattageOn() > oneTempApp[max_idx].getwattageOn())
                	max_idx = j;
            }
            // Swap the found minimum element with the first
            // element
            App temp = oneTempApp[max_idx];
            oneTempApp[max_idx] = oneTempApp[i];
            oneTempApp[i] = temp;
        }
		for(int i = 0; i < oneTempApp.length; i++) {
			if (oneTempApp[i] == null) {
				break;
			}
			System.out.println(oneTempApp[i].toString());
			
		}

			
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(App[] applications) {
		this.applications = applications;
	}

	public void addApplications(App app, int index) {
		applications[index] = app;
	}

	/**
	 * @return the brownOut
	 */
	/*
	 * public boolean isBrownOut() { return brownOut; }
	 * 
	 *//**
		 * @param brownOut the brownOut to set
		 *//*
			 * public void setBrownOut(boolean brownOut) { this.brownOut = brownOut; }
			 */

	// method to get the array of locations in the building

	// method to add a location to the building

	// method to remove a location from the building

	// method to check for brown out condition
	

}
