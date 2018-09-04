import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Methods for computing some common statistics,
 * such as average, variance, and correlation.
 * @author Pichaaun Popukdee
 */
public class Statistics {

    /**
     * Compute the arithmetic average of an array of numbers.
     *
     * @param x is array to compute average of.  Must not be null.
     * @return the arithmetic average of values in x, or 0 if x is empty.
     */
    public static double average(double[] x) {
        // Some fun: sum using a Stream instead of a loop.
        double sum = Arrays.stream(x).sum();
        return sum / x.length;
    }

    /**
     * Compute the variance of values in an array.
     * Variance uses the formula sum(x[k]*x[k])/length(x) - average(x)^2.
     *
     * @param x is the array of values. Must contain at least 1 element.
     * @return the variance of x
     * @throws IllegalArgumentException if x is empty
     */
    public static double variance(double[] x) {
        double varx = 0;
        if (x == null) throw new IllegalArgumentException();
        else if (x.length == 0) return 0;
        else {
            for (int k = 0; k < x.length; k++) {
            varx += Math.pow((x[k] - average(x) ) , 2 ) / x.length;
        } }
        DecimalFormat df = new DecimalFormat("#.######");
        return Double.parseDouble(df.format(varx));
    }

    /**
     * Compute the covariance between arrays x and y.
     * The covariance is defined by
     * <p>
     * sum[ (x[k] - average(x)) * (y[k] - average(y)) ]/n
     * where n is number of elements in the arrays.
     * <p>
     * But it is more efficient to compute using the equivalent formula:
     * <p>
     * sum( x[k]*y[k] )/n - average(x)*average(y)
     * <p>
     * Note that if x == y, this is the variance.
     *
     * @param x is the first array of values.
     * @param y is the second array of values
     * @return the covariance between x and y
     * @throws IllegalArgumentException if arrays are not same length or length is 0.
     */
    public static double covariance(double[] x, double[] y) {
        double covx = 0;
        if (x == y) {
            covx = variance(x);
        }
        else if (x == null || y == null) return 0;
        else if (x.length != y.length) throw new IllegalArgumentException();
        else {
            for (int k = 0; k < x.length; k++) {
                covx += ((x[k] - average(x)) * (y[k] - average(y)) )/ x.length;
            }
        }
        DecimalFormat df = new DecimalFormat("#.#####");
        return Double.parseDouble(df.format(covx));
    }

}
