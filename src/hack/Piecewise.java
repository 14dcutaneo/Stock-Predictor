//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//Piecewise.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;

public class Piecewise 
{
	PeicewiseStep[] steps = null;
	
	public Piecewise(PeicewiseStep p)
	{
		steps = new PeicewiseStep[1];
		steps[0] = p;
	}
	
	public double getValue(int x)
	{
		for (int i = 0; i < steps.length; i++)
			if (steps[i].isValid(x))
				return(steps[i].getValue(x));
		return -1.1;
	}
	
	
	public void addStep(PeicewiseStep p)
	{
		PeicewiseStep[] newSteps = new PeicewiseStep[steps.length+1];
		for (int i = 0; i < steps.length; i++)
			newSteps[i] = steps[i];
		newSteps[steps.length] = p;
		steps = newSteps;
	}
}
