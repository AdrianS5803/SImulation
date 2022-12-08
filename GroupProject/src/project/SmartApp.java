package project;

public class SmartApp extends App
{
	double percentDrop;
	
	public SmartApp(int I,String appName,int O,double prob,double drop,boolean t)
	{
		super(I,appName,O,prob,t);
		percentDrop=drop;
	}
	
	public void lowvoltage()
	{
		double lowvolt=(super.wattageOn)-(super.wattageOn*percentDrop);
		super.setonnwattage((int)lowvolt);
	}
	
	public String toString()
	{
		String localApp;
		localApp ="Location ID" + super.locationID+"\n Appliance Name: " + super.appName+"\n ApplianceID: " + super.appID;
		return localApp;
	}
}
