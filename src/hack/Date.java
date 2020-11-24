package hack;

public class Date 
{
		public int y,m,d;
		public Date(int y1, int m1, int d1)
		{
			y = y1;
			m = m1;
			d = d1;
		}

		public int daysFrom(Date d1)
		{
			int years = (int)Math.abs(d1.y-y);
			int months = (int)Math.abs(d1.m - m);
			int days = (int)Math.abs(d1.d-d);
			return (years*365 + months * 30 + days);
		}
		public String toString()
		{
			return ""+d+"/"+m+"/"+y;
		}
}
