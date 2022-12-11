package project;


public class RegApp extends App
{
	double percentDrop;
	
	public RegApp(int I,String appName,int O,float prob,boolean t)
	{
		super(I,appName,O,prob,t);
	}
	
	public void lowvoltage()
	{
		double lowvolt=(super.getwattageOn())-(super.getwattageOn()*0);
		super.setonnwattage((int)lowvolt);
		super.setItSetToLow(false);
	}
	
	public void brownoutWatts(App application) 
	{
		int brownoutWatts = (super.getwattageOn())-(super.getwattageOn()*0);
		super.setonnwattage(brownoutWatts);
	}
	
	public String toString()
	{
		String localApp;

		localApp ="Location ID: " + super.getlocationID()+"\nAppliance Name: " + super.getAppName()
		+"\nApplianceID: " + super.getappID()+"\nWattageON: " + super.getwattageOn()
		+"\nIs it a Smart Appliance: " + super.getappliancetype()+"\nIs it set to on: " + super.getIsItSetToLow()
		;
		return localApp;
	}
	
}