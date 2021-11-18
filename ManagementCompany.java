
public class ManagementCompany {

	//Fields
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	private int totalProp = 0;
	//Constructors
	public ManagementCompany()
	{
		
		name = "";
		taxID = "";
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0,0,10,10);
		mgmFeePer = 0;
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) 
	{
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
	}
	
	
	//Methods//////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public int addProperty(Property property)
	{

		for(int i = 0; i < totalProp; i++)
		{
			if(properties[i].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		
		
		if(totalProp == MAX_PROPERTY)
		{
			return -1;
		}
		if(property == null)
		{
			return -2;
		}
		if(!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		else
		{
			properties[totalProp] = property;
			totalProp++;
			return totalProp -1;
		}
		
	}
	
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		properties[totalProp] = property;
		
		for(int i = 0; i < totalProp; i++)
		{
			if(properties[i].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		
		
		if(totalProp == MAX_PROPERTY)
		{
			return -1;
		}
		if(property == null)
		{
			return -2;
		}
		if(!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		else
		{
			properties[totalProp] = property;
			totalProp++;
			return totalProp -1;
		}
	}
	
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		properties[totalProp] = property;
		
		for(int i = 0; i < totalProp; i++)
		{
			if(properties[i].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		
		
		if(totalProp == MAX_PROPERTY)
		{
			return -1;
		}
		if(property == null)
		{
			return -2;
		}
		if(!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		else
		{
			properties[totalProp] = property;
			totalProp++;
			return totalProp -1;
		}

	}
	
	public double totalRent() 
	{
		double totalRent = 0;
		for (int a = 0; a < totalProp; a++) 
		{
			if (properties[a] == null)
			{
				continue;
			}
			totalRent += properties[a].getRentAmount();
		}
		return totalRent;
	}
	
	public String maxRentProp() 
	{
	
		return properties[maxRentPropertyIndex()].toString();
	}
	
	public int maxRentPropertyIndex() 
	{
		int Propindex = 0;
		double maxRent = 0;
		for (int a = 0; a < totalProp; a++) 
		{
			if (maxRent<properties[a].getRentAmount())
			{
				maxRent = properties[a].getRentAmount();
				Propindex = a;
			}
		}
		return Propindex;
	}
	
	public String displayPropertyAtIndex(int a) 
	{
		return properties[a].toString();
	}
	
	public String toString() 
	{
		String info = "";
		double fee = 0;
		for (int a = 0; a < totalProp; a ++) 
		{
			if (properties[a] == null)
			{
				continue;
			}
			info += properties[a].toString() + "\n";
			fee += (mgmFeePer * properties[a].getRentAmount())/100;
			
		}
		
		return "List of properties for " + name + ", taxID: " + taxID

				+ "\n----------------------------------------------------------\n"

				+ info + "\n----------------------------------------------------------\n" +
				"Total Management Fee: " + fee;
		
	}

	
	
}
