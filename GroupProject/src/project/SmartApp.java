package project;

public class SmartApp extends App
{
	double percentDrop;
	
	public SmartApp(int I,String appName,int O,float prob,double drop,boolean t)
	{
		super(I,appName,O,prob,t);
		percentDrop=drop;
	}
	
	public void lowvoltage()
	{
		double lowvolt=(super.getwattageOn())-(super.getwattageOn()*percentDrop);
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

		localApp ="Location ID" + super.getlocationID()+"\nAppliance Name: " + super.getAppName()
		+"\nApplianceID: " + super.getappID()+"\nWattageON: " + super.getwattageOn()
		+"\nIs it a Smart Appliance: " + super.getappliancetype()+"\nChance of being on: " + super.getProbStayOn()
		+"\nranNum: " + super.getRandomNum()+"\nIs it On: " + super.isItOn();
		//return localApp;
		return localApp;
	}
}