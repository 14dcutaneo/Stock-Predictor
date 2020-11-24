//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//Tween.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;
public class Tween 
{
 private int min;
 private int max;
 
 public Tween (int a, int b)
 {
  min = a;
  max = b;
 }
 
 public boolean compare(int a)
 {
  if (a >= min && a <= max)
   return true;
     
  else
   return false;
  
 }
 
 public String toString()
 {
	 return "" + min + " to "+ max;
 }
 
}