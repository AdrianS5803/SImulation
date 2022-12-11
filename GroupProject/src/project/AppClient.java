/* This is a stub code. You can modify it as you wish. */
package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

//import project.ApplianceGenerator.Appliance;

//import project.ApplianceGenerator.Appliance;
class AppClient{
	Location loc = new Location();
	public void readAppFile(String file){ // method to read the comma seperated appliance file.
		Scanner scan;
		try {
			File myFile=new File(file);
			scan=new Scanner(myFile);//each line has the format
			//locationID,name of app,onPower,probability of staying on, smart or not,Smart appliances (if "on") power reduction percent when changed to "low" status(floating point, i.e..33=33%).
			String str;
			int locationID;
			String appName;
			int onPower;
			float probOn;
			String appType;
			double lowPower;
			App aAppl;
			
			int index=0;
			/*Complete the method*/
			//aAppl = new Appliance();
			while (scan.hasNext()){
		         // Read the next name.
				str = scan.nextLine();
				
				  String[] details = str.split(","); 
				  locationID = Integer.parseInt(details[0]);
				  appName = details[1]; 
				  onPower = Integer.parseInt(details[2]); 
				  probOn = Float.parseFloat(details[3]); 
				  appType = details[4];
				  if(appType.equalsIgnoreCase("TRUE")){ 
					  lowPower = Double.parseDouble(details[5]); 
					  aAppl = new SmartApp(locationID, appName,onPower, probOn, lowPower,Boolean.parseBoolean(appType) ); 
					} 
				  else{ 
					  aAppl = new RegApp(locationID, appName, onPower, probOn,Boolean.parseBoolean(appType)); 
				  }
				  loc.addApplications(aAppl, index);
				  index++;
				  
			}
			
			scan.close();
			//System.out.println(loc.getTotalWattage());
			//while(maxPower>loc.getTotalWattage()) {
				
			//}
		}catch(IOException ioe){ 
			System.out.println("The file can not be read");
			System.out.println("The file can not be read");
		}
	}
	
	
	public static void main(String []args){
		
		AppClient app = new AppClient();
		//User interactive part
		String option1, option2;
		Scanner scan = new Scanner(System.in);
		Scanner blank = new Scanner(System.in);
		//app.readAppFile("/Users/adriansalcedo/Desktop/Comp Sci/Eclipse Workspace/GroupProject/src/project/app.txt");
		while(true){
			// Application menu to be displayed to the user.
			System.out.println("Select an option:");
			System.out.println("Type \"A\" Add an appliance");
			System.out.println("Type \"D\" Delete an appliance");	
			System.out.println("Type \"L\" List the appliances");
			System.out.println("Type \"F\" Read Appliances from a file");
			System.out.println("Type \"S\" To Start the simulation");
			System.out.println("Type \"Q\" Quit the program");
			
			option1=scan.nextLine();
			//System.out.println(option1);
			
			//System.out.println(option1);
			/* Complete the skeleton code below */
			
			
			
			if(option1.equals("A")) {
				
				String newAppliance ="";
				System.out.println("Enter a location");
				String input= scan.nextLine();
				newAppliance+=input+",";
				System.out.println("Enter the name of the application");
				input = scan.nextLine();
				newAppliance+=input+",";
				System.out.println("Enter the power it uses when turned on");
				input = scan.nextLine();
				newAppliance+=input+",";
				System.out.println("Enter the probability of the application staying on");
				input = scan.nextLine();
				newAppliance+=input+",";
				System.out.println("Is it a smart appliance?");
				input=scan.nextLine();
				//newAppliance+=input+",";
				if(input.equals("yes")) {
					System.out.println("Enter power reduction percent when changed low status");
					input = scan.nextLine();
					newAppliance+="true,"+input;
				}
				else
					newAppliance+="false,0.0";
				
				try
				{
				    String filename= "/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    fw.write(newAppliance+"\n");//appends the string to the file
				    fw.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
				//A
				//break;
			}
			
			
			
			
			
			
			else if(option1.equals("D")) {
				System.out.println("Select what appliance you would like to delete");
				
				String tempFile = "/Users/adriansalcedo/git/SImulation/GroupProject/src/project/temp.txt";
				File oldFile = new File ("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt");
				File newFile = new File (tempFile);
				int line = 0;
				String currentLine; 
				try
				{
					int input = scan.nextInt();
				FileWriter fw = new FileWriter (tempFile, true);
				BufferedWriter bw = new BufferedWriter (fw);
				PrintWriter pw = new PrintWriter (bw);
				FileReader fr = new FileReader ("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt");
				BufferedReader br = new BufferedReader (fr);
					while ((currentLine = br.readLine()) != null){
						line++;
						if (input != line){
							pw.println (currentLine);
						}
					}
					pw.flush();
					pw.close();
					fr.close();
					br.close();
					bw.close();
					fw.close();
					oldFile.delete();
					File dump = new File ("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt");
					newFile.renameTo (dump);
				}
				
				catch (Exception e)
				{
					System.out.println("Not a proper appliance");
				}
				
			}
			
			
			else if(option1.equals("L")) {
				app.readAppFile("/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt");
				
			}else if(option1.equals("F")) {
				System.out.println("Enter file you would like to read");
				option2= scan.nextLine();
				app.readAppFile(option2);
				
			}
			
			else if(option1.equals("S")) {
				System.out.println("Enter the total allowed wattage (power)");
				int maxPower;
				maxPower= scan.nextInt();
				
				System.out.println("Enter the timesteps for this simulation");
				int timeStep;
				timeStep= scan.nextInt();
				
				System.out.println("Enter the comma separated text file containing the appliances.");
				option2= scan.nextLine();
				while(true) {
					try {
						File myFile=new File(option2);
						scan=new Scanner(myFile);
						break;
					}
					catch(IOException ioe){ 
						
					}
					System.out.println("The file can not be read");
					option2 = scan.nextLine();
				}
				String file = option2;
				
				for(int i =0;i<timeStep;i++) {
					System.out.println("This is timestep number "+(i+1)+" of the simulation");
					app.readAppFile(file);
					//option1= blank.nextLine();
					while(app.loc.getTotalWattage()>maxPower) {
						System.out.println("The Building has exceeded total allowed wattage");
						System.out.println("The total allowed wattage is: "+maxPower);
						System.out.println("The total wattage that is being used in the building: "+app.loc.getTotalWattage());
						System.out.println("Would you like to select a smart appliance to turn to low(S) or brown out a location(B)");
						
					
						option2= blank.nextLine();
						if(option2.equals("S")) {
							System.out.println("Here are the ten appliances using the most power");
							app.loc.setOnArray();
							System.out.println("Select which application you would like to set to low. Type AppID");
							option2= blank.nextLine();
							app.loc.setLow(app.loc.getApplications(),Integer.parseInt(option2));
							//System.out.println(app.loc.getApplication(Integer.parseInt(option2)));
						}
						else if(option2.equals("B")) {
							app.loc.showLocations();
							System.out.println("What location would you like to brown out. Type LocationID");
							option2= blank.nextLine();
							app.loc.brownOutLocation(Integer.parseInt(option2));
							//System.out.println(app.loc.getTotalWattage());
						}
						
					}
					System.out.println(app.loc.getTotalTurnedBrownOut());
					System.out.println(app.loc.getTotalTurnedOff());
					System.out.println("You have gotten the total wattage used in the building lower than the total allowed wattage congrats!");
					app.loc.maxEffectedLocation();
					app.loc.numEffectedLocation();
					app.loc.textFile();
					//app
					

					//app.loc.get;
				}
				
				
				// System.out.println(app.loc.);
				break;
			}else if(option1.equals("Q")) {
				break;
			}
			else{
				System.out.println("Invalid option please select again");
			}
		
				
		}
		
		
	}
}