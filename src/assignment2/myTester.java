package assignment2;

import java.math.BigInteger;

public class myTester {

    public static void addTermTest5 () {

        Polynomial p1 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTerm ( new Term ( 2, new BigInteger ( "7" ) ) );
        p1.addTerm ( new Term ( 5, new BigInteger ( "2" ) ) );
        p1.addTerm ( new Term ( 2, new BigInteger ( "-4" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "3" ) ) );

        expected.addTermLast ( new Term ( 5, new BigInteger ( "2" ) ) );
        expected.addTermLast ( new Term ( 3, new BigInteger ( "3" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "3" ) ) );

        System.out.print ( "addTerm() test #5: adding terms out of order..." );
        if (p1.size () != 3 || !p1.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + p1.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void deepCloneTest1 () {

        Polynomial p1 = new Polynomial ();

        p1.addTermLast ( new Term ( 2, new BigInteger ( "3" ) ) );

        Polynomial expected = p1.deepClone ();

        System.out.print ( "deepClone() test #1: copying a polynomial with one term..." );
        if (p1.size () != 1 || !p1.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + p1.toString () );
                System.out.println ( "Actual " + expected.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void deepCloneTest2 () {

        Polynomial p1 = new Polynomial ();

        p1.addTermLast ( new Term ( 4, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 3, new BigInteger ( "1" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "5" ) ) );

        Polynomial expected = p1.deepClone ();

        System.out.print ( "deepClone() test #3: copying a polynomial with three terms..." );
        if (p1.size () != 3 || !p1.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + p1.toString () );
                System.out.println ( "Actual " + expected.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void deepCloneTest3 () {

        Polynomial p1 = new Polynomial ();

        p1.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTermLast ( new Term ( 8, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 6, new BigInteger ( "9" ) ) );
        p1.addTermLast ( new Term ( 5, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 4, new BigInteger ( "6" ) ) );
        p1.addTermLast ( new Term ( 3, new BigInteger ( "7" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "5" ) ) );
        p1.addTermLast ( new Term ( 0, new BigInteger ( "8" ) ) );

        Polynomial expected = p1.deepClone ();

        System.out.print ( "deepClone() test #3: copying a polynomial with eight terms..." );
        if (p1.size () != 8 || !p1.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + p1.toString () );
                System.out.println ( "Actual " + expected.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void addTest1 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );

        p2.addTermLast ( new Term ( 2, new BigInteger ( "5" ) ) );

        expected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "5" ) ) );

        Polynomial result = Polynomial.add ( p1, p2 );

        System.out.print ( "add() test #1: adding two polynomials with one term..." );
        if (p1.size () != 1 || p2.size () != 1 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void addTest2 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 4, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "1" ) ) );

        p2.addTermLast ( new Term ( 5, new BigInteger ( "3" ) ) );
        p2.addTermLast ( new Term ( 2, new BigInteger ( "7" ) ) );
        p2.addTermLast ( new Term ( 0, new BigInteger ( "5" ) ) );

        expected.addTermLast ( new Term ( 5, new BigInteger ( "3" ) ) );
        expected.addTermLast ( new Term ( 4, new BigInteger ( "2" ) ) );
        expected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "7" ) ) );
        expected.addTermLast ( new Term ( 1, new BigInteger ( "1" ) ) );
        expected.addTermLast ( new Term ( 0, new BigInteger ( "5" ) ) );

        Polynomial result = Polynomial.add ( p1, p2 );

        System.out.print ( "add() test #2: adding two polynomials with three unique terms..." );
        if (p1.size () != 3 || p2.size () != 3 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void addTest3 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 8, new BigInteger ( "3" ) ) );
        p1.addTermLast ( new Term ( 7, new BigInteger ( "6" ) ) );
        p1.addTermLast ( new Term ( 6, new BigInteger ( "3" ) ) );
        p1.addTermLast ( new Term ( 5, new BigInteger ( "-9" ) ) );
        p1.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );
        p1.addTermLast ( new Term ( 2, new BigInteger ( "-10" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 0, new BigInteger ( "12" ) ) );

        p2.addTermLast ( new Term ( 9, new BigInteger ( "4" ) ) );
        p2.addTermLast ( new Term ( 7, new BigInteger ( "2" ) ) );
        p2.addTermLast ( new Term ( 6, new BigInteger ( "-5" ) ) );
        p2.addTermLast ( new Term ( 4, new BigInteger ( "3" ) ) );
        p2.addTermLast ( new Term ( 3, new BigInteger ( "3" ) ) );
        p2.addTermLast ( new Term ( 2, new BigInteger ( "-1" ) ) );
        p2.addTermLast ( new Term ( 1, new BigInteger ( "-8" ) ) );
        p2.addTermLast ( new Term ( 0, new BigInteger ( "3" ) ) );

        expected.addTermLast ( new Term ( 9, new BigInteger ( "4" ) ) );
        expected.addTermLast ( new Term ( 8, new BigInteger ( "3" ) ) );
        expected.addTermLast ( new Term ( 7, new BigInteger ( "8" ) ) );
        expected.addTermLast ( new Term ( 6, new BigInteger ( "-2" ) ) );
        expected.addTermLast ( new Term ( 5, new BigInteger ( "-9" ) ) );
        expected.addTermLast ( new Term ( 4, new BigInteger ( "3" ) ) );
        expected.addTermLast ( new Term ( 3, new BigInteger ( "7" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "-11" ) ) );
        expected.addTermLast ( new Term ( 1, new BigInteger ( "-6" ) ) );
        expected.addTermLast ( new Term ( 0, new BigInteger ( "15" ) ) );

        Polynomial result = Polynomial.add ( p1, p2 );

        System.out.print ( "add() test #2: adding two polynomials with eight terms..." );
        if (p1.size () != 8 || p2.size () != 8 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void multiplyTest1 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 4, new BigInteger ( "3" ) ) );

        p2.addTermLast ( new Term ( 2, new BigInteger ( "5" ) ) );

        expected.addTermLast ( new Term ( 6, new BigInteger ( "15" ) ) );

        Polynomial result = Polynomial.multiply ( p1, p2 );

        System.out.print ( "multiply() test #1: multiplying two polynomials with one term..." );
        if (p1.size () != 1 || p2.size () != 1 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void multiplyTest2 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 2, new BigInteger ( "3" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 0, new BigInteger ( "-8" ) ) );

        p2.addTermLast ( new Term ( 3, new BigInteger ( "2" ) ) );
        p2.addTermLast ( new Term ( 2, new BigInteger ( "-5" ) ) );
        p2.addTermLast ( new Term ( 1, new BigInteger ( "4" ) ) );

        expected.addTermLast ( new Term ( 5, new BigInteger ( "6" ) ) );
        expected.addTermLast ( new Term ( 4, new BigInteger ( "-11" ) ) );
        expected.addTermLast ( new Term ( 3, new BigInteger ( "-14" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "48" ) ) );
        expected.addTermLast ( new Term ( 1, new BigInteger ( "-32" ) ) );

        Polynomial result = Polynomial.multiply ( p1, p2 );

        System.out.print ( "multiply() test #2: multiplying two polynomials with three terms..." );
        if (p1.size () != 3 || p2.size () != 3 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void multiplyTest3 () {

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial expected = new Polynomial ();

        p1.addTermLast ( new Term ( 8, new BigInteger ( "1" ) ) );
        p1.addTermLast ( new Term ( 6, new BigInteger ( "4" ) ) );
        p1.addTermLast ( new Term ( 5, new BigInteger ( "-3" ) ) );
        p1.addTermLast ( new Term ( 4, new BigInteger ( "-1" ) ) );
        p1.addTermLast ( new Term ( 3, new BigInteger ( "6" ) ) );
        p1.addTermLast ( new Term ( 2, new BigInteger ( "2" ) ) );
        p1.addTermLast ( new Term ( 1, new BigInteger ( "1" ) ) );
        p1.addTermLast ( new Term ( 0, new BigInteger ( "-1" ) ) );

        p2.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        p2.addTermLast ( new Term ( 8, new BigInteger ( "2" ) ) );
        p2.addTermLast ( new Term ( 7, new BigInteger ( "5" ) ) );
        p2.addTermLast ( new Term ( 6, new BigInteger ( "-8" ) ) );
        p2.addTermLast ( new Term ( 4, new BigInteger ( "1" ) ) );
        p2.addTermLast ( new Term ( 2, new BigInteger ( "-5" ) ) );
        p2.addTermLast ( new Term ( 1, new BigInteger ( "-6" ) ) );
        p2.addTermLast ( new Term ( 0, new BigInteger ( "4" ) ) );

        expected.addTermLast ( new Term ( 17, new BigInteger ( "3" ) ) );
        expected.addTermLast ( new Term ( 16, new BigInteger ( "2" ) ) );
        expected.addTermLast ( new Term ( 15, new BigInteger ( "17" ) ) );
        expected.addTermLast ( new Term ( 14, new BigInteger ( "-9" ) ) );
        expected.addTermLast ( new Term ( 13, new BigInteger ( "11" ) ) );
        expected.addTermLast ( new Term ( 12, new BigInteger ( "-30" ) ) );
        expected.addTermLast ( new Term ( 11, new BigInteger ( "37" ) ) );
        expected.addTermLast ( new Term ( 10, new BigInteger ( "44" ) ) );
        expected.addTermLast ( new Term ( 9, new BigInteger ( "-48" ) ) );
        expected.addTermLast ( new Term ( 8, new BigInteger ( "-30" ) ) );
        expected.addTermLast ( new Term ( 7, new BigInteger ( "-16" ) ) );
        expected.addTermLast ( new Term ( 6, new BigInteger ( "49" ) ) );
        expected.addTermLast ( new Term ( 5, new BigInteger ( "-35" ) ) );
        expected.addTermLast ( new Term ( 4, new BigInteger ( "-51" ) ) );
        expected.addTermLast ( new Term ( 3, new BigInteger ( "7" ) ) );
        expected.addTermLast ( new Term ( 2, new BigInteger ( "7" ) ) );
        expected.addTermLast ( new Term ( 1, new BigInteger ( "10" ) ) );
        expected.addTermLast ( new Term ( 0, new BigInteger ( "-4" ) ) );

        Polynomial result = Polynomial.multiply ( p1, p2 );

        System.out.print ( "multiply() test #3: multiplying two polynomials with six term..." );
        if (p1.size () != 8 || p2.size () != 8 || !result.isDeepClone ( expected )) {
            System.out.println ( "Failed." );
            try {
                System.out.println ( "Expected " + expected.toString () );
                System.out.println ( "Actual " + result.toString () );
            } catch (Exception e) {
                System.out.println ( e.getMessage () );
            }
        } else {
            System.out.println ( "Passed." );
        }

    }

    public static void main ( String[] args ) {

        addTermTest5 ();

        System.out.println ( "" );

        deepCloneTest1 ();
        deepCloneTest2 ();
        deepCloneTest3 ();

        System.out.println ( "" );

        addTest1 ();
        addTest2 ();
        addTest3 ();

        System.out.println ( "" );

        multiplyTest1 ();
        multiplyTest2 ();
        multiplyTest3 ();

        System.out.println ( "\nDone." );
    }

}
