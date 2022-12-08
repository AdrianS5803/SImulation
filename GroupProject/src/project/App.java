package project;

public class App {
  int locationID;
	String appName;
	int wattageOn;
	double probStayOn;
	boolean smart;
	static int id = 0;
	int appID;
	
	public App ( int I, String AppName, int O, double prob, boolean t) {
		locationID = I;
		appName = AppName;
		wattageOn = O;
		probStayOn = prob;
		smart = t;
		id++;
		appID = id;
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
	
	public void setlocationID(int l)
	{
		locationID=l;
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
	
	public void setapplianceID(int d)
	{
		appID=d;
	}
	
	public String toString()
	{
		String localApp;
		localApp = "Location ID"+locationID+"\nAppliance Name: "+appName+"\nApplianceID: "+appID+"\n";
		return localApp;
	}
}
