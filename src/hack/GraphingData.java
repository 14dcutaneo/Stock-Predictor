//---------------------------------------\\
//2017 HACKATHON -- MANALAPAN HIGH SCHOOL\\
//DrawGraph.java						 \\
//ALAN DECOWSKI							 \\
//GARRETT CHESTNUT						 \\
//DANIEL CUTANEO						 \\
//---------------------------------------\\
package hack;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.*;
 

@SuppressWarnings("serial")
public class GraphingData extends JPanel {
    static double[] data;
    
    
    public static void importData(double[] d)
    {
    	data = d;
    }
    
    final int PAD = 20;
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        // Draw labels.
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
        // Ordinate label.
        String s = "data";
        float sy = PAD + ((h - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
        for(int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (PAD - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }
        // Abcissa label.
        s = "x axis";
        sy = h - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, sx, sy);
        // Draw lines.
        double xInc = (double)
        		(w - 2*PAD)/(
        				data.length-1);
        double scale = (double)(h - 2*PAD)/getMax();
        g2.setPaint(Color.green.darker());
        for(int i = 0; i < data.length-1; i++) {
            double x1 = PAD + i*xInc;
            double y1 = h - PAD - scale*data[i];
            double x2 = PAD + (i+1)*xInc;
            double y2 = h - PAD - scale*data[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        // Mark data points.
        g2.setPaint(Color.red);
        for(int i = 0; i < data.length; i++) {
            double x = PAD + i*xInc;
            double y = h - PAD - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private double getMax() {
        double max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }
 
    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
		System.out.println("Enter TCKR");
		System.out.print("> ");
		
		StockViewer k = new StockViewer(in.next());
		//GregorianCalendar(year, month, dayOfMonth)
		System.out.println("Enter begining Year Month Day seperated by space!");
		System.out.print("> ");
		int y = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();
		System.out.print("> ");
		int y1 = in.nextInt();
		int m2 = in.nextInt();
		int d2 = in.nextInt();
		stockValue[] sV = k.viewStock(new GregorianCalendar(y,m,d), new GregorianCalendar(y1,m2,d2));
		
		double[] dah = new double[sV.length];
		
		for (int i = 0; i<dah.length; i++)
			dah[i] = sV[i].getPrice();
		
		importData(dah);
		in.close();
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingData());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}