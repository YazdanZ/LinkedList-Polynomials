package SLLPolynomial;

import java.math.BigInteger;

/*
 * This class Term represents a single term in the polynomial
 *
 * The terms with zero coefficients should be removed from the
 * representation.
 *
 * Under no circumstances the exponent should be negative.
 */

public class Term implements DeepClone<Term> {

    private int exponent;
    private BigInteger coefficient;

    public Term ( int e, BigInteger c ) {
        if (e < 0 || c.compareTo ( new BigInteger ( "0" ) ) == 0)
            throw new IllegalArgumentException ( "Invalid term" );

        exponent = e;
        coefficient = c;
    }

    @Override
    public Term deepClone () {
        return new Term ( exponent, coefficient );
    }

    public BigInteger getCoefficient () {
        return coefficient;
    }

    public void setCoefficient ( BigInteger d ) {
        coefficient = d;
    }

    public int getExponent () {
        return exponent;
    }

    public void setExponent ( int a ) {
        exponent = a;
    }

    /**
     * This method is only for validating the implementation of Horner's method.
     * @param x x
     * @return evaluation of the polynomial
     */
    public BigInteger eval ( BigInteger x ) {
        BigInteger result = BigInteger.valueOf ( 1 );
        int n = exponent;
        while (n != 0) {
            result = result.multiply ( x );
            n--;
        }
        return (result.multiply ( coefficient ));
    }

    @Override
    public String toString () {
        String s = "";
        if (coefficient.compareTo ( new BigInteger ( "0" ) ) < 0)
            s += "-";
        else if (coefficient.compareTo ( new BigInteger ( "0" ) ) > 0)
            s += "+";

        if (coefficient.abs ().compareTo ( new BigInteger ( "1" ) ) != 0)
            s += coefficient.abs ();

        if (exponent > 0) {
            s += "x";
            if (exponent > 1) {
                s += "^" + exponent;
            }
        } else if (coefficient.abs ().compareTo ( new BigInteger ( "1" ) ) == 0)
            s += "1";

        return s;
    }


}
