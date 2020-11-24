package hack;
//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//LinearRegressionModel.java			 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\

public class LinearRegressionModel 
{
	public double a = 0.0, b = 0.0, average = 0.0, dfa = 0.0, dfaAverage = 0.0;
	
	public LinearRegressionModel(stockValue[] Data)
	{
		average = Data[0].getPrice();
		for (int i = 1; i < Data.length; i++)
		{
			dfaAverage = (dfaAverage + (Data[i].getPrice()-average))/2;
			average = (average+Data[i].getPrice())/2;
		}
		System.out.println("Average:"+average);
		System.out.println("DFAAverage:"+dfaAverage);
		
	}
	
}
 