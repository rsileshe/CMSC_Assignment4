
public class Plot 
{

	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	//Constructors
	public Plot()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	
	}
	
	public Plot(Plot p)
	{
		x = p.getX();
		y = p.getY();
		width = p.getWidth();
		depth = p.getDepth();
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width =width;
		this.depth = depth;
		
	}
	
	
	//Methods
	public boolean overlaps(Plot plot)
	{	
		
		boolean result = true;
		
		if(this.x +this.width <= plot.getX())
		{
			return false;
		}
		else if(this.x >= plot.getX() + plot.getWidth())
		{
			return false;
		}
		else if(this.y >= plot.getY() + plot.getDepth())
		{
			return false;
		}
		else if(this.y + this.depth <= plot.getY())
		{
			return false;
		}
		else
		{
			return true;
		}
		
	
	}
	
	public boolean encompasses(Plot plot)
	{
		
		if (plot.getY() >= this.y && plot.getY() + plot.getDepth() <= this.y + this.depth && plot.getX() >= this.x && plot.getX() + plot.getWidth() <= this.x + this.width) 
		{
			return true;
		}
		return false;
	}

	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	
	public int getDepth()
	{
		return depth;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public String toString()
	{	 
		return String.format("Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth);
	}
	
	
}