package hack;

import org.jfree.util.ParamChecks;
import org.jfree.data.xy.XYDataset;

public class Regression {
	/**
	232     * Returns the parameters 'a0', 'a1', 'a2', ..., 'an' for a polynomial 
	233     * function of order n, y = a0 + a1 * x + a2 * x^2 + ... + an * x^n,
	234     * fitted to the data using a polynomial regression equation.
	235     * The result is returned as an array with a length of n + 2,
	236     * where double[0] --&gt; a0, double[1] --&gt; a1, .., double[n] --&gt; an.
	237     * and double[n + 1] is the correlation coefficient R2
	238     * Reference: J. D. Faires, R. L. Burden, Numerische Methoden (german
	239     * edition), pp. 243ff and 327ff.
	240     *
	241     * @param dataset  the dataset (<code>null</code> not permitted).
	242     * @param series  the series to fit the regression line against (the series
	243     *         must have at least order + 1 non-NaN items).
	244     * @param order  the order of the function (&gt; 0).
	245     *
	246     * @return The parameters.
	247     *
	248     * @since 1.0.14
	249     */
	    public static double[] getPolynomialRegression(XYDataset dataset, 
	            int series, int order) {
	        ParamChecks.nullNotPermitted(dataset, "dataset");
	        int itemCount = dataset.getItemCount(series);
	        if (itemCount < order + 1) {
	            throw new IllegalArgumentException("Not enough data.");
	       }
        int validItems = 0;
	        double[][] data = new double[2][itemCount];
	        for(int item = 0; item < itemCount; item++){
	            double x = dataset.getXValue(series, item);
	            double y = dataset.getYValue(series, item);
	            if (!Double.isNaN(x) && !Double.isNaN(y)){
	                data[0][validItems] = x;
	                data[1][validItems] = y;
	                validItems++;
	            }
	        }
	        if (validItems < order + 1) {
	            throw new IllegalArgumentException("Not enough data.");
	        }
	        int equations = order + 1;
	        int coefficients = order + 2;
	        double[] result = new double[equations + 1];
	        double[][] matrix = new double[equations][coefficients];
	        double sumX = 0.0;
	        double sumY = 0.0;
	
	        for(int item = 0; item < validItems; item++){
	            sumX += data[0][item];
	            sumY += data[1][item];
                for(int eq = 0; eq < equations; eq++){
	                for(int coe = 0; coe < coefficients - 1; coe++){
	                    matrix[eq][coe] += Math.pow(data[0][item],eq + coe);
	                }
	                matrix[eq][coefficients - 1] += data[1][item]
	                        * Math.pow(data[0][item],eq);
	            }
	        }
	        double[][] subMatrix = calculateSubMatrix(matrix);
	        for (int eq = 1; eq < equations; eq++) {
                matrix[eq][0] = 0;
	            for (int coe = 1; coe < coefficients; coe++) {
	                matrix[eq][coe] = subMatrix[eq - 1][coe - 1];
	            }
	        }
	        for (int eq = equations - 1; eq > -1; eq--) {
	            double value = matrix[eq][coefficients - 1];
	            for (int coe = eq; coe < coefficients -1; coe++) {
	                value -= matrix[eq][coe] * result[coe];
	            }
	            result[eq] = value / matrix[eq][eq];
	        }
	        double meanY = sumY / validItems;
	        double yObsSquare = 0.0;
	        double yRegSquare = 0.0;
	        for (int item = 0; item < validItems; item++) {
	            double yCalc = 0;
	            for (int eq = 0; eq < equations; eq++) {
	                yCalc += result[eq] * Math.pow(data[0][item],eq);
	            }
	            yRegSquare += Math.pow(yCalc - meanY, 2);
	            yObsSquare += Math.pow(data[1][item] - meanY, 2);
	        }
	        double rSquare = yRegSquare / yObsSquare;
	        result[equations] = rSquare;
	        return result;
	    }
	
}
