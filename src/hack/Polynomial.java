//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//Polynomial.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;

public class Polynomial 
{
	private int degree;
	private double[] values;
	
	public Polynomial (int d)
	{
		degree = d;
		values = new double[d+1];
	}
	
	public void setVal (int degree,double d)
	{
		values[degree - 1] = d;
	}
	
	public double calculate(int x)
	{
		double runner= 0;
		for (int i = 0; i < values.length / 2 - 1; i++)
		{
			runner += Math.pow(x, i) * values[x];
		}
		return runner;
	}
	
	
}
