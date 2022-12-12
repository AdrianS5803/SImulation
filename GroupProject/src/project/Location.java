package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Location {
	private App[] applications;
	private  int totalTurnedBrownOut;
	private  int totalTurnedOff;
	// private boolean brownOut; // flag to indicate brown out condition

	public Location() {
		// numAppliactions=getNumApp;
		applications = new App[2000];
		totalTurnedBrownOut=0;
		 totalTurnedOff=0;
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
				
			}
		}
		this.totalTurnedBrownOut++;

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
	public int numEffectedLocation() {
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
		return numLocEffected;
		//System.out.println("Num location effected: "+numLocEffected);
	}
	public void textFile() {
		//IF OTHER USER WANTS TO USE IT CHANGE THE FILE THAT FITS FOR UR DEVICE
		File detailFile = new File("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/detailFile.txt");

		try (FileWriter fileWriter = new FileWriter(detailFile);
		     BufferedWriter writer = new BufferedWriter(fileWriter)) {
		    writer.write("Here are the appliances that were affected during the timestep");
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
			if(applications[i].isItOn()&&applications[i].getappliancetype()&&applications[i].isItSetToOn()) {
				oneTempApp[k]=applications[i];
				k++;
			}
		}
		
		int right = k;
		for (int i = 0; i < right+1; i++)
        {
            // Find the maximum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < right; j++) {
                if (oneTempApp[j].getwattageOn() > oneTempApp[max_idx].getwattageOn())
                	max_idx = j;
            }
            // Swap the found maximum element with the first
            // element
            App temp = oneTempApp[max_idx];
            oneTempApp[max_idx] = oneTempApp[i];
            oneTempApp[i] = temp;
        }
		for(int i = 0; i <10; i++) {
			if (oneTempApp[i] == null) {
				break;
			}
			System.out.println(oneTempApp[i].toString());
			
		}

			
	}
	public void setLow(int ID) {
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				break;
			}
			if(applications[i].getappID()==ID&&applications[i].isItSetToOn()) {
				//break;
				applications[i].lowvoltage();
				applications[i].setEffected(true);
				this.totalTurnedOff++;
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

	

}
