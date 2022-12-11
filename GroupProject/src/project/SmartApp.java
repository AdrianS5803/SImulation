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
	
	public void lowvoltage()
	{
		double lowvolt=(super.getwattageOn())-(super.getwattageOn()*percentDrop);
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
		+"\nApplianceID: " + super.getappID()+"\nWattageON: " + super.getwattageOn()+"\n"
		;//return localApp;
		return localApp;
	}
	
}