package project;

public class RegApp extends App
{
	double percentDrop;
	
	public RegApp(int I,String appName,int O,double prob,boolean t)
	{
		super(I,appName,O,prob,t);
	}
	
	public void lowvoltage()
	{
		double lowvolt=(super.wattageOn)-(super.wattageOn*0);
		super.setonnwattage((int)lowvolt);
	}
	
	public String toString()
	{
		String localApp;
		localApp="Location ID" + super.locationID+"\nAppliance Name: " + super.appName+"\n ApplianceID: " + super.appID;
		return localApp;
	}
}
