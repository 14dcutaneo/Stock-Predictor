package hack;

public class Regress
{

 public RegressionModel createRegression(stockValue[] v) {
  //Catch obvious not parrellel
  
  if (v == null)
  {
   System.err.println("Error occured in regression sequencing: Error LN22 No Data recieved");
   return null;
  }
  
  @SuppressWarnings("unused")
  int numYears = v.length/253;
  
  //Create array that makes average rate of change for that day
  double data[] = new double [v.length];
  
  //Base average, to be calculated as it goes
  double Average = v[0].getPrice();
  double AverageRoC = 0.0; //Average Rate of Change
  
  System.out.println("");
  System.out.println("---STATS---");
  //Calculating averages and rate of change for that day
  for (int i = 1; i<data.length; i++)
  {
   try
   {
    data[i] = (v[i].getPrice()/v[i-1].getPrice());
    Average = (Average + v[i].getPrice())/2;
   }
   catch (Exception e)
   {
    System.err.println("Error occured in regression sequencing: Error LN.. " +e.toString()); 
    return null;
   }
  }
   for (int i4 = 1; i4 < data.length; i4++)
   {
    AverageRoC += data[i4];
    
   }
  
   AverageRoC /= Math.pow(data.length,2);   
   
   System.out.println("AVERAGE: " + Average);
   System.out.println("AVERAGE RATE OF CHANGE: " + AverageRoC);
   System.out.println("");
   System.out.print("Creating Graph for Future Days.....");
   wait(1000);
   System.out.println("Done!");
   
   double [] future = new double[5];
   
   for (int i = 0; i < future.length; i++)
   {
	   future[i] = (Average + AverageRoC * i);
   }
   
   //Graphpannel futureGraph = new Graphpannel(future,"New Graph");
   
  
  return null;
 }

 public void wait(int delay)
 {
	 long l = System.currentTimeMillis();
	 while (System.currentTimeMillis() - l <= delay);
	 return;
 }

}