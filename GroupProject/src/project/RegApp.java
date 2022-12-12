package project;


public class RegApp extends App
{
	double percentDrop;
	
	public RegApp(int I,String appName,int O,float prob,boolean t)
	{
		super(I,appName,O,prob,t);
	}
	


	
	public String toString()
	{
		String localApp;

		localApp ="Location ID: " + super.getlocationID()+"\nAppliance Name: " + super.getAppName()
		+"\nApplianceID: " + super.getappID()+"\nWattageON: " + super.getwattageOn()
		+"\nIs it a Smart Appliance: " + super.getappliancetype()+"\nIs it set to on: " + super.isItSetToOn()
		;
		return localApp;
	}
	
}