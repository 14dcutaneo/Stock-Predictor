//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//stockValue.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;

public class stockValue 
{
	private Date theDateofClose;
	private double price;
	public stockValue(Date d, double p)
	{
		theDateofClose = d;
		price = p;
	}
	public Date getDate()
	{
		return theDateofClose;
	}
	public double getPrice()
	{
		return price;
	}
	public String toString()
	{
		return (theDateofClose + " " + price);
	}
}
