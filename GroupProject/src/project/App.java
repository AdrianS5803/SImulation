package project;

import inClass.Car;

public class App {
	private int locationID;
	private String appName;
	private int wattageOn;
	private float probStayOn;
	private boolean smart;
	private static int counter = 0;
	private int appID;
	
	public App ( int I, String AppName, int O, float prob, boolean t) {
		this.locationID = I;
		this.appName = AppName;
		this.wattageOn = O;
		this.probStayOn = prob;
		this.smart = t;
		this.appID = App.counter;
		App.counter++;
		
	}
	
	public App(int locationID2, String appName2, int onPower, float probOn, boolean parseBoolean, double lowPower) {
		// TODO Auto-generated constructor stub
	}
	public int getlocationID()
	{
		return locationID;
	}
	
	public String getAppName()
	{
		return appName;
	}
	
	public int getwattageOn()
	{
		return wattageOn;
	}
	
	public double probStayOn(App applic)
	{
		return probStayOn;
	}
	
	public int getappID()
	{
		return appID;
	}
	
	public boolean getappliancetype()
	{
		return smart;
	}
	
	public void setlocationID(int v)
	{
		locationID=v;
	}
	
	public void setappliancename(String str)
	{
		appName=str;
	}
	
	public void setonnwattage(int x)
	{
		wattageOn=x;
	}
	
	public void setonoffprob(float i)
	{
		probStayOn=i;
	}
	
	public void setapplianceID(int f)
	{
		appID=f;
	}
	
	public String toString()
	{
		String localApp;
		localApp = "Location ID"+locationID+"\nAppliance Name: "+appName+"\nApplianceID: "+appID+"\n";
		return localApp;
	}
}
