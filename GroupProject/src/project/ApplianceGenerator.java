package project;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ApplianceGenerator {
	public static class App {
		public String name;
		public int onW, offW; 
		public double probOn; 
		public boolean smart; 
		public double probSmart;

		public App (String n, int on, int off, double pOn, boolean s, double pSmart)
		{ name=n; onW=on; offW=off; probOn=pOn; smart=s; probSmart=pSmart; }

		public String toString () {
			return name + "," + onW + "," + offW + "," + probOn + "," + smart + "," + probSmart;
		}
	}

	public static void main( String [] args ) throws IOException {
		App [] app = new App[100];  // default 100 possible appliance types
		//IF OTHER USER WANTS TO USE IT CHANGE THE FILE THAT FITS FOR UR DEVICE
		File inputFile = new File( "/Users/adriansalcedo/git/SImulation/GroupProject/src/project/ApplianceDetail.txt" );
		Scanner scan = new Scanner( inputFile );
		int count=0;
		while ( scan.hasNext( ) ) {
			StringTokenizer stringToken = new StringTokenizer(scan.nextLine());
			app[count] = new App(stringToken.nextToken(","),
						Integer.parseInt(stringToken.nextToken(",")),
						Integer.parseInt(stringToken.nextToken(",")),
						Double.parseDouble(stringToken.nextToken(",")),
						Boolean.parseBoolean(stringToken.nextToken(",")),
						Double.parseDouble(stringToken.nextToken()));
			count++;
		}
/*
output a comma delimited file
the location (represented by an 8 digit numeric account number)
type (string)
"on" wattage used (integer)
probability (floating point, i.e..01=1%) that the appliance is "on" at any time
smart (boolean) 
Smart appliances (if "on") power reduction percent when changed to "low" status(floating point, i.e..33=33%).
*/
		try
		{
			//IF OTHER USER WANTS TO USE IT CHANGE THE FILE THAT FITS FOR UR DEVICE
			FileWriter fw = new FileWriter( "/Users/adriansalcedo/git/SImulation/GroupProject/src/project/app.txt", false);
			BufferedWriter bw = new BufferedWriter( fw );
			for (long location=1;location<=100 ;location++ ) {   // default 100 locations
				int applianceCount=(int)(Math.random()*6)+15;  //15-20 appliances per location 
				for (int i=1;i<=applianceCount;i++ ){
					int index=(int)(Math.random()*count);  // pick an appliance randomly
					bw.write(String.valueOf(10000000+location));
					bw.write( "," );		
					bw.write(app[index].name);
					bw.write( "," );		
					bw.write(String.valueOf(app[index].onW));
					bw.write( "," );									
					bw.write(String.valueOf(app[index].probOn));
					bw.write( "," );		
					bw.write(String.valueOf(app[index].smart));
					bw.write( "," );
					bw.write(String.valueOf(app[index].probSmart));
					bw.newLine( );
					bw.flush();
				}
			}
		}
		catch( IOException ioe )
		{
			ioe.printStackTrace( );
		}
	}
}