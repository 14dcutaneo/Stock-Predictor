//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//QuadraticFunction.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;

public class QuadraticFunction implements ModelInterface
{
 private double a;
 private double b;
 private double c;
 
 public QuadraticFunction(double float1, double float2, double float3)
 {
  a = float1;
  b = float2;
  c = float3;
 }
 
 public double compute(int x)
 {
  return ((a * Math.pow(x, 2)) + (b * x) + c);
 }
}