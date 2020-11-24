//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//GetDates.java							 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;


import java.util.*;
import java.net.URL;
import java.net.URLConnection;


public class StockViewer 
{
	private ArrayList<String> dates;
	private ArrayList<String> opens;
	private ArrayList<String> highs;
	private ArrayList<String> lows;
	private ArrayList<String> closes;
	private ArrayList<String> volumes;
	private ArrayList<String> adjCloses;
    @SuppressWarnings("unused")
	private ArrayList<Date> datesDate;
    private ArrayList<Integer> years;
    private ArrayList<Integer> months;
    private ArrayList<Integer> days;
    private ArrayList<stockValue> sV;
	private String sym;
	private boolean success = false;
	private int dOM = 0;
	private int val = 0;
        private int[] yearsArray;
        private int[] monthsArray;
        private int[] daysArray;
        /*
        int[] years = new int[253];
        int[] months = new int[253];
        int[] days = new int[253];
        */
	
	public StockViewer(String symbol)
	{	
        dates = new ArrayList<String>();
        opens = new ArrayList<String>(); 
        highs = new ArrayList<String>(); 
        lows = new ArrayList<String>(); 
        closes = new ArrayList<String>(); 
        volumes = new ArrayList<String>(); 
        adjCloses = new ArrayList<String>();
        years = new ArrayList<Integer>();
        months = new ArrayList<Integer>();
        days = new ArrayList<Integer>();
		sV = new ArrayList<stockValue>();
        sym = symbol;
        }
	
	public stockValue[] viewStock(GregorianCalendar begin, GregorianCalendar fin)
	{
		while(!success)
		{
			String url = "";
			try
			{
			url = "http://chart.finance.yahoo.com/table.csv?s=" + sym + 
					"&a=" + begin.get(Calendar.MONTH) + 
					"&b=" + begin.get(Calendar.DAY_OF_MONTH - dOM) + 
					"&c=" + begin.get(Calendar.YEAR) + 
					"&d=" + fin.get(Calendar.MONTH) + 
					"&e=" + fin.get(Calendar.DAY_OF_MONTH) +
					"&f=" + fin.get(Calendar.YEAR) + 
					"&g=d&ignore=.csv";
			}
			catch(Exception e)
			{
				System.err.println("Error occured in data parsing: Error LN77 Invalid Ticker");
				return null;
			}

			try
			{
				URL yhooFin = new URL(url);
				URLConnection data = yhooFin.openConnection();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(data.getInputStream());
				if(input.hasNext()) // skip a line (that's the header)
					input.nextLine();
				// start reading data
				while(input.hasNextLine())
				{
					String line = input.nextLine();
					String[] elements = line.split(",");

					success = true;
					val++;
					dates.add(elements[0]);
					opens.add(elements[1]);
					highs.add(elements[2]);
					lows.add(elements[3]);
					closes.add(elements[4]);
					volumes.add(elements[5]);
					adjCloses.add(elements[6]);
                                        
					String[] dateParse = elements[0].split("-");  
					
					int year = Integer.parseInt(dateParse[0]);
					int month = Integer.parseInt(dateParse[1]);
					int day = Integer.parseInt(dateParse[2]);
					
					double price = Double.parseDouble(elements[6]);
					
					years.add(year);
					months.add(month);
					days.add(day);
					sV.add(
							new stockValue(new Date(year,month,day),
									price));
				}
                                
                                yearsArray = new int[years.size()];
                                monthsArray = new int[months.size()];
                                daysArray = new int[days.size()];
                                
                                for(int count = 0; count < years.size(); count++)
                                {
                                    yearsArray[count] = years.get(count);
                                }
                                
                                for(int count = 0; count < monthsArray.length; count++)
                                {
                                    monthsArray[count] = months.get(count);
                                }
                                
                                for(int count = 0; count < daysArray.length; count++)
                                {
                                    daysArray[count] = days.get(count);
                                }
                                
                                
			}

			catch(Exception e)
			{
				dOM++;
				System.err.println("Error occured in data sequencing: Error LN147 Unknown");
				return null;
			}
		}
		stockValue[] v = new stockValue[sV.size()];
		for (int i = 0; i < sV.size(); i++)
			v[i] = sV.get(i);
		return v;
	} 
	
	public void viewStockCurrent(GregorianCalendar c1, GregorianCalendar c2)
	{
		viewStock(c1, c2);
	}
	
	public int getTotalStockQuotes()
	{
		return val;
	}
}
