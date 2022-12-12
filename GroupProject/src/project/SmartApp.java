package project;

public class SmartApp extends App
{
	double percentDrop;
	
	public SmartApp(int I,String appName,int O,float prob,double drop,boolean t)
	{
		super(I,appName,O,prob,t);
		percentDrop=drop;
		super.setPercentDrop(percentDrop);
		
	}
	
	
	
	
	
	public String toString()
	{
		String localApp;

		localApp ="Location ID: " + super.getlocationID()+"\nAppliance Name: " + super.getAppName()
		+"\nApplianceID: " + super.getappID()+"\nWattageON: " + super.getwattageOn()+"\n"
		;//return localApp;
		return localApp;
	}
	
}