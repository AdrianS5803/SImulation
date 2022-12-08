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
		double lowvolt=(super.getwattageOn())-(super.getwattageOn()*0);
		super.setonnwattage((int)lowvolt);
	}
	
	public void brownoutWatts(App application) 
	{
		int brownoutWatts = (super.getwattageOn())-(super.getwattageOn()*0);
		super.setonnwattage(brownoutWatts);
	}
	
	public String toString()
	{
		String localApp;
		localApp="Location ID" + super.getlocationID()+"\nAppliance Name: " + super.appName()+"\n ApplianceID: " + super.getappID();
		return localApp;
	}
}
