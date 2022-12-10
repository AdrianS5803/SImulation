package project;

//import inClass.Car;

public class App {
	private int locationID;
	private String appName;
	private int wattageOn;
	private float probStayOn;
	private boolean smart;
	private static int counter = 0;
	private int appID;
	private double randomNum;
	private boolean isItOn;
	
	public App ( int I, String AppName, int O, float prob, boolean t) {
		this.locationID = I;
		this.appName = AppName;
		this.wattageOn = O;
		this.probStayOn = prob;
		this.smart = t;
		this.appID = App.counter;
		App.counter++;
		this.randomNum=Math.random();
		if(randomNum<=this.probStayOn) {
			this.isItOn=true;
		}
		else
			this.isItOn=false;
		
	}
	
	
	/**
	 * @return the isItOn
	 */
	public boolean isItOn() {
		return isItOn;
	}


	/**
	 * @param isItOn the isItOn to set
	 */
	public void setItOn(boolean isItOn) {
		this.isItOn = isItOn;
	}


	/**
	 * @return the randomNum
	 */
	public double getRandomNum() {
		return randomNum;
	}


	/**
	 * @param randomNum the randomNum to set
	 */
	public void setRandomNum(double randomNum) {
		this.randomNum = randomNum;
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
	
	public double getProbStayOn()
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
		localApp = "Location ID: "+locationID+"\nAppliance Name: "+appName+"\nApplianceID: "+appID+"\n"+
				"Wattage Power: "+wattageOn;
		return localApp;
	}
}
