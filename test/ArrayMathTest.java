import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
    /**
     * A small tolerance for floating point round-off (precision) error.
     */
    static final double TOL = 1.0E-6;

    @Test
    public void testDotProductTinyVectors() {
        // vector of length one
        double[] x = {5.2};
        double[] y = {-7.5};
        double expected = x[0] * y[0];
        assertEquals(expected, ArrayMath.dotProduct(x, y), TOL);
        assertEquals(expected, ArrayMath.dotProduct(y, x), TOL);

        // vector of size 0?
        x = new double[]{};
        y = new double[]{};
        assertEquals(0.0, ArrayMath.dotProduct(x, y), TOL);
    }

    @Test
    public void testDotProductMoreThanOneVectors() {
        // 2 vectors
        double[] x = {12.4, 30.2};
        double[] y = {3.4, -0.8};

        assertEquals(18, ArrayMath.dotProduct(x, y), TOL);
        assertEquals(18, ArrayMath.dotProduct(y, x), TOL);

        // 3 vectors
        double[] a = {5.6, -2.3, 3.2};
        double[] b = {0, 8.3, 4.5};

        assertEquals(-4.69, ArrayMath.dotProduct(a, b), TOL);
        assertEquals(-4.69, ArrayMath.dotProduct(b, a), TOL);

        // 6 vectors
        double[] s = {2,5.4,6,0,-2,4};
        double[] t = {0,3.7,8.6,9.3,1,7};

        assertEquals(97.58, ArrayMath.dotProduct(s,t), TOL);
        assertEquals(97.58, ArrayMath.dotProduct(t,s), TOL);
    }

    @Test
    public void testDotProductHugeVectors() {
        int len = 1_000_000;
        double[] x = new double[len];
        double[] y = new double[len];
        Random rand = new Random();
        double product = 0.0;
        for (int k = 0; k < len; k++) {
            // to avoid overflowing the product using floats for elements
            double xk = (double) rand.nextFloat();
            double yk = (double) rand.nextFloat();
            x[k] = xk;
            y[k] = yk;
            product += xk * yk;
        }
        assertEquals(product, ArrayMath.dotProduct(x, y), TOL);
        assertEquals(product, ArrayMath.dotProduct(y, x), TOL);
    }

    /**
     * This test should throw an exception,
     * but not after you change the spec for dotProduct!
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testDotProductLengthsNotSame() {
        double[] x = new double[]{1, 3, 5, 7, 9};
        double[] y = new double[]{-2, 0.5, 4};
        assertEquals(19.5, ArrayMath.dotProduct(x, y), TOL);
        assertEquals(19.5, ArrayMath.dotProduct(y, x), TOL);

        //one of vectors has size 0.
        double[] a = {4.3, 8, 9};
        double[] b = {};
        assertEquals(0.0, ArrayMath.dotProduct(a, b), TOL);
        assertEquals(0.0, ArrayMath.dotProduct(b, a), TOL);
    }

}
