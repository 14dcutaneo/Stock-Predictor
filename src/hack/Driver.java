package hack;

import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.SwingUtilities;

//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//Test.java							 	 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\

//Open - High - Low - Close
public class Driver {

	public static void main(String[] args)
	{
		
	      int x = 0;
	      
	      System.out.println("Welcome to Market Master! We can somewhat accurately predict a stocks worth for up to 50 days in advance.");
	    System.out.println(">Finalized<");
	     while (x == 0)
	     { 

			Scanner in = new Scanner(System.in);
			System.out.println("Enter Ticker");
			System.out.print("> ");
			String ticker = in.next();
			StockViewer k = new StockViewer(ticker);
			
			int y = 2017;
			int m = 4;
			int d = 1;
			
			int y1 = 2017;
			int m2 = 5;
			int d2 = 10;
			
			stockValue[] sV = k.viewStock(new GregorianCalendar(y,m,d), new GregorianCalendar(y1,m2,d2));
			Regress r = new Regress();
			r.createRegression(sV);
			if (sV != null)
			{
			double [] Stock = new double[sV.length];
			
			
			for (int i = 0; i < sV.length; i++)
				Stock[i] = sV[i].getPrice();
			
			
			
			SwingUtilities.invokeLater(new Runnable() 
		      {
		         public void run() 
		         {

		            long d = System.currentTimeMillis();
		            while (System.currentTimeMillis()-d <1000);
		            Graphpannel g = new Graphpannel(Stock, ticker);
		            g.createAndShowGui(Stock,ticker);
		         }
		         
		      });
			
	     	}
	     }
	      }
	}
	
	


