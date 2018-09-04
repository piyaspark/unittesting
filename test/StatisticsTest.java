import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    /**
     * A small tolerance for floating point round-off (precision) error.
     */
    static final double TOL = 1.0E-6;

    @Test
    public void testAverageTinyArray() {
        double[] x = {123.01};
        assertEquals(x[0], Statistics.average(x), TOL);
        double[] y = {123.01, 123.02};
        assertEquals(123.015, Statistics.average(y), TOL);
    }

    @Test
    public void testAverageMixedValues() {
        double[] x = new double[99];
        java.util.Arrays.fill(x, 12.5);
        assertEquals(12.5, Statistics.average(x), TOL);
        // many values spaced around a known mean
        double avg = 1.125;
        int n = x.length;
        java.util.Arrays.fill(x, avg);
        for (int k = 0; k <= n / 2; k++) {
            x[k] -= 0.5 * k;
            x[n - k - 1] += 0.5 * k;
        }
        assertEquals(avg, Statistics.average(x), TOL);
    }

    @Test
    public void testVarianceNull() {
        double[] x = new double[99];
        double[] y = null;
        boolean thrown = false;
        try {
            Statistics.variance(y);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        assertEquals(0.0, Statistics.variance(x), TOL);
    }

    @Test
    public void testLargeArrayVariance() {
        double[] y = new double[100];
        for (int i = 0 ; i < y.length ; i ++ ) {
            y[i] = i+1 ;
        }
        assertEquals(833.25000,Statistics.variance(y),TOL);
        double[] x = {123.02, 140.52, 350.90, 543.86, 58.56, 19.41, 19.02, 28.27, 1, 1923.56};
        double answer = Statistics.variance(x);
        assertEquals(312964.195556, answer, TOL);

    }

    @Test
    public void testCovariance() {
        double[] x = {123.02, 140.52, 350.90, 543.86};
        double[] y = {58.56, 19.41, 19.02, 28.27};
        assertEquals(-1072.89498, Statistics.covariance(x, y), TOL);

    }

    @Test
    public void testCovarianceThrowsException() {
        double[] x = {123.02, 140.52, 350.90, 543.86};
        double[] y = {58.56, 19.41, 19.02};
        boolean thrown = false;
        try {
            Statistics.covariance(x, y);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        x = null ;
        y= null;
        thrown = false;
        try {
            Statistics.covariance(x, y);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

    @Test
    public void testCovarianceEquals () {
        double[] x = new double[100];
        double[] y = new double[100];
        for (int i = 0 ; i < y.length ; i ++ ) {
            y[i] = i+1 ;
            x[i] = i+1 ;
        }
    assertEquals(833.25000 , Statistics.covariance(x,y) , TOL);
    }
}
