//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//RegressionModel.java					 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO		                 \\
//THOMAS CAMILLI						 \\
//---------------------------------------\\
package hack;

public class PeicewiseStep
{
	private Tween t;
	private ModelInterface model;
	
	public PeicewiseStep(Tween l, ModelInterface mod)
	{
		t = l;
		model = mod;
	}
	
	public Tween getTween()
	{
		return t;
	}
	public boolean isValid(int x)
	{
		return t.compare(x);
	}
	public double getValue(int x)
	{
		if (isValid(x))
		{
			return model.compute(x);
		}
		return -1.1;
	}
	
}
