package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Location {
	private App[] applications;
	private  int totalTurnedBrownOut = 0;
	private  int totalTurnedOff = 0;
	// private boolean brownOut; // flag to indicate brown out condition

	public Location() {
		// numAppliactions=getNumApp;
		applications = new App[2000];
		
		// brownOut = false;
	}

	/**
	 * @return the totalTurnedOff
	 */
	public  int getTotalTurnedOff() {
		return totalTurnedOff;
	}

	/**
	 * @param totalTurnedOff the totalTurnedOff to set
	 */
	public  void setTotalTurnedOff(int totalTurnedOff) {
		this.totalTurnedOff = totalTurnedOff;
	}

	/**
	 * @return the totalTurnedBrownOut
	 */
	public  int getTotalTurnedBrownOut() {
		return totalTurnedBrownOut;
	}

	/**
	 * @param totalTurnedBrownOut the totalTurnedBrownOut to set
	 */
	public  void setTotalTurnedBrownOut(int totalTurnedBrownOut) {
		this.totalTurnedBrownOut = totalTurnedBrownOut;
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
				applications[i].setEffected(true);
				totalTurnedBrownOut++;
			}
		}

	}
	public void showLocations() {
		if(applications[0].getwattageOn()!=0) {
			System.out.println(applications[0].getlocationID());
		}
		for (int i = 1; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			
			 if(applications[i].getlocationID()!=applications[i-1].getlocationID()&&applications[i].getwattageOn()!=0) {
			System.out.println(applications[i].getlocationID());
			}
		}
	}
	public void numEffectedLocation() {
		int numLocEffected=0;
		int currentID=applications[0].getlocationID();
		
		boolean diffLoc=true;
		for (int i = 0; i < applications.length+1; i++) {
			if (applications[i] == null) {
				break;
			}
			if(currentID!=applications[i].getlocationID()) {
				diffLoc=true;
				currentID=applications[i].getlocationID();
			}
			if(applications[i].isEffected()&&diffLoc) {
				numLocEffected++;
				
				diffLoc=false;
				
			}
			
			
		}
		System.out.println("Num location effected: "+numLocEffected);
	}
	public void textFile() {
		File detailFile = new File("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/detailFile.txt");

		try (FileWriter fileWriter = new FileWriter(detailFile);
		     BufferedWriter writer = new BufferedWriter(fileWriter)) {
		    writer.write("Here are the appliances that were affected uring the timestep");
		    writer.newLine();
		    for (int i = 0; i < applications.length+1; i++) {
				if (applications[i] == null) {
					break;
				}
				if(applications[i].isEffected()) {
					writer.write(applications[i].fileToString());
				    writer.newLine();
				}
		    }
		    
		} catch (IOException e) {
		    // Handle the exception
		}
	}
	public void maxEffectedLocation() {
		int max=0;
		int tempMax=0;
		int currentID=applications[0].getlocationID();
		int idWithMaxEffect=applications[0].getlocationID();
		for (int i = 0; i < applications.length+1; i++) {
			if (applications[i] == null) {
				break;
			}
			if(currentID!=applications[i].getlocationID()) {
				currentID=applications[i].getlocationID();
				tempMax=0;
			}
			if(applications[i].isEffected()) {
				tempMax++;
			}
			if(tempMax>max) {
				max=tempMax;
				idWithMaxEffect=applications[i].getlocationID();
				//idWithMaxEffect=
			}
			
		}
		
		for (int j = 0; j < applications.length+1; j++) {
			if (applications[j] == null) {
				break;
			}
			if(applications[j].getlocationID()==idWithMaxEffect) {
				System.out.println(applications[j].getlocationID());
				break;
			}
		}
		//System.out.println(applications[].lo());
	}
	public void setOnArray() {
		App[] oneTempApp = new App[2000];
		
		int k = 0;
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			if(applications[i].isItOn()&&applications[i].getappliancetype()&&applications[i].getIsItSetToLow()) {
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
		for(int i = 0; i <5; i++) {
			if (oneTempApp[i] == null) {
				break;
			}
			System.out.println(oneTempApp[i].toString());
			
		}

			
	}
	public void setLow(App[] app,int ID) {
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			if(applications[i].getappID()==ID&&applications[i].getIsItSetToLow()) {
				//break;
				applications[i].lowvoltage();
				applications[i].setEffected(true);
				totalTurnedOff++;
			}
			
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
