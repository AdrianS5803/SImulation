package project;

public class App {
	private int locationID;
	private String appName;
	private int wattageOn;
	private double probStayOn;
	private boolean smart;
	private static int counter = 0;
	private int appID;
	
	public App ( int I, String AppName, int O, double prob, boolean t) {
		this.locationID = I;
		this.appName = AppName;
		this.wattageOn = O;
		this.probStayOn = prob;
		this.smart = t;
		this.appID = App.counter;
		
	}
	public int getlocationID()
	{
		return locationID;
	}
	
	public String appName()
	{
		return appName;
	}
	
	public int getwattageOn()
	{
		return wattageOn;
	}
	
	public double probStayOn()
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
	
	public void setonoffprob(double i)
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
