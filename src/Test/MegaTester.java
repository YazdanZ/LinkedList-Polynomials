package Test;

import SLLPolynomial.Polynomial;
import SLLPolynomial.Term;

import java.math.BigInteger;

public class MegaTester {

    private static final int TOTALTESTS = MegaTester.class.getDeclaredMethods ().length - 4;
    private static int failedTests = 0;


    private static void testAddTerm1 () {
        // adds a term which should be inserted in the middle of a polynomial
        Polynomial p1 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );

        pExpected.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        pExpected.addTermLast ( new Term ( 4, new BigInteger ( "5" ) ) );
        pExpected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );

        if (p1.size () != 3 || pExpected.size () != 3 || !p1.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd1(): add() does not add polynomials properly" );
            failedTests++;
        }
    }

    private static void testAddTerm2 () {
        // adds an empty term
        Polynomial p1 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );

        Term t = new Term ( 1, new BigInteger ( "120" ) );
        t.setCoefficient ( BigInteger.ZERO );
        p1.addTerm ( t );

        pExpected.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        pExpected.addTermLast ( new Term ( 4, new BigInteger ( "5" ) ) );
        pExpected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );

        if (p1.size () != 3 || pExpected.size () != 3 || !p1.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd2(): add() does not add polynomials properly" );
            failedTests++;
        }
    }

    private static void testAdd1 () {
        // tests general functioning of add()
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );

        p2.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p2.addTerm ( new Term ( 4, new BigInteger ( "2" ) ) );
        p2.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        pExpected.addTermLast ( new Term ( 9, new BigInteger ( "6" ) ) );
        pExpected.addTermLast ( new Term ( 4, new BigInteger ( "7" ) ) );
        pExpected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );
        pExpected.addTermLast ( new Term ( 0, new BigInteger ( "1" ) ) );


        Polynomial pStudent = Polynomial.add ( p1, p2 );

        if (pStudent.size () != 4 || pExpected.size () != 4 || !pStudent.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd1(): add() does not add polynomials properly" );
            failedTests++;
        }
    }

    private static void testAdd2 () {
        // adds two polynomials where two terms cancel out
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTerm ( new Term ( 8, new BigInteger ( "2" ) ) );
        p2.addTerm ( new Term ( 7, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 8, new BigInteger ( "-2" ) ) );

        pExpected.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        pExpected.addTermLast ( new Term ( 7, new BigInteger ( "1" ) ) );

        Polynomial pStudent = Polynomial.add ( p1, p2 );

        if (pStudent.size () != 2 || pExpected.size () != 2 || !pStudent.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd2(): add() does not add polynomials properly" );
            failedTests++;
        }


    }

    private static void testAdd3 () {
        // adds a polynomial to an empty polynomial
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );


        pExpected.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        pExpected.addTermLast ( new Term ( 4, new BigInteger ( "5" ) ) );
        pExpected.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );


        Polynomial pStudent = Polynomial.add ( p1, p2 );

        if (pStudent.size () != 3 || pExpected.size () != 3 || p2.size () != 0 || !pStudent.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd3(): add() does not add polynomials properly" );
            failedTests++;
        }
    }

    private static void testAdd4 () {
        // adds two polynomials which should result in an empty polynomial
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        p2.addTerm ( new Term ( 9, new BigInteger ( "-3" ) ) );

        Polynomial pStudent = Polynomial.add ( p1, p2 );

        if (pStudent.size () != 0 || pExpected.size () != 0 || p2.size () != 1 || !pStudent.isDeepClone ( pExpected )) {
            System.out.println ( "testAdd4(): add() does not add polynomials properly" );
            failedTests++;
        }
    }

    private static void testMultiplyTerm1 () {
        // multiplies a polynomial by a term with coefficient 0
        Polynomial p1 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        Term t = new Term ( 1, new BigInteger ( "1" ) );
        t.setCoefficient ( BigInteger.ZERO );

        p1.multiplyTerm ( t );

        if (!p1.isDeepClone ( pExpected ) || p1.size () != 0) {
            System.out.println ( "testMultiplyTerm1(): multiplyTerm() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiplyTerm2 () {
        // multiplies an empty polynomial by a term with coefficient 0
        Polynomial p1 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        Term t = new Term ( 1, new BigInteger ( "1" ) );
        t.setCoefficient ( BigInteger.ZERO );

        p1.multiplyTerm ( t );

        if (!p1.isDeepClone ( pExpected ) || p1.size () != 0) {
            System.out.println ( "testMultiplyTerm2(): multiplyTerm() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiplyTerm3 () {
        // multiplies an empty polynomial by a term
        Polynomial p1 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        Term t = new Term ( 1, new BigInteger ( "1" ) );

        p1.multiplyTerm ( t );

        if (!p1.isDeepClone ( pExpected ) || p1.size () != 0) {
            System.out.println ( "testMultiplyTerm3(): multiplyTerm() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply1 () {
        // tests basic functioning of multiply()
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 0, new BigInteger ( "-1" ) ) );

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        pExpected.addTermLast ( new Term ( 2, new BigInteger ( "1" ) ) );
        pExpected.addTermLast ( new Term ( 0, new BigInteger ( "-1" ) ) );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 2 || p2.size () != 2) {
            System.out.println ( "testMultiply1(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply2 () {
        // multiplies a polynomial by an empty polynomial
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 2 || p2.size () != 0) {
            System.out.println ( "testMultiply2(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply3 () {
        // multiplies a polynomial by an empty polynomial
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p2.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 0 || p2.size () != 2) {
            System.out.println ( "testMultiply3(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply4 () {
        // multiplies three polynomials together, where some terms disappear
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial p3 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 0, new BigInteger ( "-1" ) ) );
        p3.addTerm ( new Term ( 2, new BigInteger ( "1" ) ) );
        p3.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        pExpected.addTermLast ( new Term ( 4, new BigInteger ( "1" ) ) );
        pExpected.addTermLast ( new Term ( 0, new BigInteger ( "-1" ) ) );

        Polynomial pTemp = Polynomial.multiply ( p1, p2 );
        Polynomial pActual = Polynomial.multiply ( pTemp, p3 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 2 || p2.size () != 2 || p3.size () != 2) {
            System.out.println ( "testMultiply4(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply5 () {
        // multiplies two polynomials with a single term
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 54, new BigInteger ( "13" ) ) );
        p2.addTerm ( new Term ( 13, new BigInteger ( "54" ) ) );

        pExpected.addTermLast ( new Term ( 67, new BigInteger ( "702" ) ) );

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 1 || p2.size () != 1) {
            System.out.println ( "testMultiply5(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply6 () {
        // multiplies polynomials with terms that add up to equivalent values
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        p1.addTerm ( new Term ( 50, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 30, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 3, new BigInteger ( "1" ) ) );
        p2.addTerm ( new Term ( 2, new BigInteger ( "1" ) ) );

        pExpected.addTermLast ( new Term ( 53, new BigInteger ( "1" ) ) );
        pExpected.addTermLast ( new Term ( 52, new BigInteger ( "1" ) ) );
        pExpected.addTermLast ( new Term ( 33, new BigInteger ( "1" ) ) );
        pExpected.addTermLast ( new Term ( 32, new BigInteger ( "1" ) ) );

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 2 || p2.size () != 2) {
            System.out.println ( "testMultiply6(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testMultiply7 () {
        // multiplies two empty polynomials
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pExpected = new Polynomial ();

        Polynomial pActual = Polynomial.multiply ( p1, p2 );

        if (!pActual.isDeepClone ( pExpected ) || p1.size () != 0 || p2.size () != 0) {
            System.out.println ( "testMultiply7(): multiply() doesn't multiply properly" );
            failedTests++;
        }
    }

    private static void testDeepClone1 () {
        // tests basic functioning of deepClone()
        Polynomial pStudent = new Polynomial ();

        pStudent.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        pStudent.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        pStudent.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );
        pStudent.addTerm ( new Term ( 2, new BigInteger ( "3" ) ) );
        pStudent.addTerm ( new Term ( 1, new BigInteger ( "2" ) ) );
        pStudent.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        Polynomial pCopy = pStudent.deepClone ();

        if (!pCopy.isDeepClone ( pStudent ) || pCopy == pStudent) {
            System.out.println ( "testDeepClone1(): deepClone() does not make a deep copy" );
            failedTests++;
        }

    }

    private static void testDeepClone2 () {
        // compares a deep clone to an identical polynomial
        Polynomial pStudent = new Polynomial ();
        Polynomial pNotCopy = new Polynomial ();

        pStudent.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        pStudent.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        pStudent.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );

        pNotCopy.addTermLast ( new Term ( 9, new BigInteger ( "3" ) ) );
        pNotCopy.addTermLast ( new Term ( 4, new BigInteger ( "5" ) ) );
        pNotCopy.addTermLast ( new Term ( 3, new BigInteger ( "4" ) ) );

        Polynomial pCopy = pStudent.deepClone ();

        if (!pCopy.isDeepClone ( pStudent ) || pCopy == pStudent || pNotCopy == pCopy || pCopy.size () != 3 || !pStudent.isDeepClone ( pNotCopy )) {
            System.out.println ( "testDeepClone2(): deepClone() does not make a deep copy" );
            failedTests++;
        }
    }

    private static void testDeepClone3 () {
        // tests deepClone() on an empty polynomial
        Polynomial pStudent = new Polynomial ();

        Polynomial pCopy = pStudent.deepClone ();

        if (!pCopy.isDeepClone ( pStudent ) || pCopy.size () != 0 || pStudent.size () != 0) {
            System.out.println ( "testDeepClone3(): deepClone() does not make a deep copy" );
            failedTests++;
        }
    }

    private static void testDeepClone4 () {
        // changes term in copy, to see if terms are indeed deepclones
        Polynomial pStudent = new Polynomial ();

        pStudent.addTerm ( new Term ( 9, new BigInteger ( "3" ) ) );
        pStudent.addTerm ( new Term ( 4, new BigInteger ( "5" ) ) );
        pStudent.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );
        pStudent.addTerm ( new Term ( 2, new BigInteger ( "3" ) ) );
        pStudent.addTerm ( new Term ( 1, new BigInteger ( "2" ) ) );
        pStudent.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        Polynomial pCopy = pStudent.deepClone ();
        pCopy.getTerm ( 0 ).setExponent ( 10 );

        if (pCopy.isDeepClone ( pStudent )) {
            System.out.println ( "testDeepClone4(): deepClone() does not make a deep copy" );
            failedTests++;
        }
    }

    private static void testEval1 () {
        // tests basic functioning of eval on a polynomial where not every exponent is present
        Polynomial pStudent = new Polynomial ();

        pStudent.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        pStudent.addTerm ( new Term ( 1, new BigInteger ( "5" ) ) );
        pStudent.addTerm ( new Term ( 0, new BigInteger ( "2" ) ) );


        BigInteger result = pStudent.eval ( new BigInteger ( "5" ) );
        if (!result.equals ( new BigInteger ( "277" ) )) {
            System.out.println ( "testEval1(): eval() does not evaluate polynomial properly" );
            failedTests++;
        }
    }

    private static void testEval2 () {
        // tests eval by evaluating it with x = 0
        Polynomial pStudent = new Polynomial ();

        pStudent.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        pStudent.addTerm ( new Term ( 1, new BigInteger ( "5" ) ) );
        pStudent.addTerm ( new Term ( 0, new BigInteger ( "2" ) ) );


        BigInteger result = pStudent.eval ( new BigInteger ( "0" ) );
        if (!result.equals ( new BigInteger ( "2" ) )) {
            System.out.println ( "testEval2(): eval() does not evaluate polynomial properly" );
            failedTests++;
        }
    }

    private static void testEval3 () {
        // tests evaluating an empty polynomial
        Polynomial pStudent = new Polynomial ();

        BigInteger result = pStudent.eval ( new BigInteger ( "129" ) );
        if (!result.equals ( new BigInteger ( "0" ) )) {
            System.out.println ( "testEval3(): eval() does not evaluate polynomial properly" );
            failedTests++;
        }
    }

    private static void testEval4 () {
        // tests evaluating an empty polynomial with x = 0
        Polynomial pStudent = new Polynomial ();

        BigInteger result = pStudent.eval ( new BigInteger ( "0" ) );
        if (!result.equals ( new BigInteger ( "0" ) )) {
            System.out.println ( "testEval4(): eval() does not evaluate polynomial properly" );
            failedTests++;
        }
    }

    public static void main ( String[] args ) {
        System.out.println ( "Running MegaTester...\n" );
        testAddTerm1 ();
        testAddTerm2 ();
        testAdd1 ();
        testAdd2 ();
        testAdd3 ();
        testAdd4 ();
        testDeepClone1 ();
        testDeepClone2 ();
        testDeepClone3 ();
        testDeepClone4 ();
        testEval1 ();
        testEval2 ();
        testEval3 ();
        testEval4 ();
        testMultiplyTerm1 ();
        testMultiplyTerm2 ();
        testMultiplyTerm3 ();
        testMultiply1 ();
        testMultiply2 ();
        testMultiply3 ();
        testMultiply4 ();
        testMultiply5 ();
        testMultiply6 ();
        testMultiply7 ();

        if (failedTests == 0) System.out.println ( "Passed all MegaTester tests!" );
        else System.out.println ( "Failed " + failedTests + " out of " + TOTALTESTS + " MegaTester tests" );
    }
}
