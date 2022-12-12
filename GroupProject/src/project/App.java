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
	private double percentDrop;
	private boolean isItOn;
	private boolean isItSetToOn;
	private boolean effected;
	
	public App ( int I, String AppName, int O, float prob, boolean t) {
		this.locationID = I;
		this.appName = AppName;
		this.wattageOn = O;
		this.probStayOn = prob;
		this.smart = t;
		this.appID = App.counter;
		App.counter++;
		this.randomNum=Math.random();
		this.isItSetToOn=true;
		this.effected=false;
		if(randomNum<=this.probStayOn) {
			this.isItOn=true;
			
		}
		else {
			this.isItOn=false;
		//this.isItSetToOn=false;
		}
		
	}
	
	
	/**
	 * @return the effected
	 */
	public boolean isEffected() {
		return effected;
	}


	/**
	 * @param effected the effected to set
	 */
	public void setEffected(boolean effected) {
		this.effected = effected;
	}


	

	/**
	 * @return the isItSetToOn
	 */
	public boolean isItSetToOn() {
		return isItSetToOn;
	}


	/**
	 * @param isItSetToOn the isItSetToOn to set
	 */
	public void setItSetToOn(boolean isItSetToOn) {
		this.isItSetToOn = isItSetToOn;
	}


	/**
	 * @return the percentDrop
	 */
	public double getPercentDrop() {
		return percentDrop;
	}


	/**
	 * @param percentDrop the percentDrop to set
	 */
	public void setPercentDrop(double percentDrop) {
		this.percentDrop = percentDrop;
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
		this.locationID=v;
	}
	
	public void setappliancename(String str)
	{
		this.appName=str;
	}
	
	public void setonnwattage(int x)
	{
		this.wattageOn=x;
	}
	
	public void setonoffprob(float i)
	{
		this.probStayOn=i;
	}
	
	public void setapplianceID(int f)
	{
		this.appID=f;
	}
	public void lowvoltage()
	{
		setItSetToOn(false);
		double lowvolt=(getwattageOn())-(getwattageOn()*percentDrop);
		setonnwattage((int)lowvolt);
		
	}
	public String toString()
	{
		String localApp;
		localApp = "Location ID: "+locationID+"\nAppliance Name: "+appName+"\nApplianceID: "+appID+"\n"+
				"Wattage Power: "+wattageOn;
		return localApp;
	}
	public String fileToString()
	{
		String localApp;
		localApp = "Location ID: "+locationID+"\nAppliance Name: "+appName+"\nApplianceID: "+appID+"\n";
		return localApp;
	}
}
