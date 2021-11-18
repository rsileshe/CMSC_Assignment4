
public class Property {

	
	//fields
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	//Constructors
	public Property()
	{
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		//plot = setPlot(0,0,1,1);
		this.plot = new Plot();
		
	}
	
	public Property(Property P)
	{
		city = P.city;
		owner = P.owner;
		propertyName = P.propertyName;
		rentAmount = P.rentAmount;
		this.plot = new Plot(P.plot);
		
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.city =city;
		this.owner =owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
		
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.city =city;
		this.owner =owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
		
		
	}

	
	//Methods
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}

	public Plot setPlot(int x, int y, int width, int depth)
	{
		return new Plot(x,y,width,depth);
		
	}
	
	public Plot getPlot() 
	{
		return plot;
	}
	
	
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public String toString()
	{
		return String.format("Property Name: " + propertyName + "/n Located in " + city + "/n Belonging to: " + owner + "/n Rent Amount: " + rentAmount + " " );
	}
	
	
	
	
}
