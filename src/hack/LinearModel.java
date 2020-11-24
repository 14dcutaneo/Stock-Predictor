//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//LinearModel.java						 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;

public class LinearModel implements ModelInterface
{
 private double a;
 private double b;
 
 public LinearModel(double float1, double float2)
 {
  a = float1;
  b = float2;
 }
 
 public double compute(int x)
 {
  return((a * x) + b);
 }
}