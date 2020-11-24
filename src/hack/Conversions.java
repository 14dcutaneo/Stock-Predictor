//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//Conversions.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;
import java.util.GregorianCalendar;
public class Conversions 
{

	public static Date convertToDateClass(GregorianCalendar g)
	{

		return new Date(g.get(1),g.get(2),g.get(3));
	}
	public static GregorianCalendar convertToGC(Date d)
	{
		return new GregorianCalendar(d.y, d.m, d.d);
	}
}
