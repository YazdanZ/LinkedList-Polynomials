package Test;

import SLLPolynomial.Polynomial;
import SLLPolynomial.Term;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;

public class SuperTester {


    private static void deepCloneTest1 () {
        // TODO Auto-generated method stub

        Polynomial p1 = new Polynomial ();
        Polynomial p2 = p1.deepClone ();

        if (p1.size () != 0 || p2.size () != 0 || !p2.isDeepClone ( p1 )) {
            System.out.println ( "Failed deepCloneTest1" );
        }

    }

    private static void deepCloneTest2 () {
        // TODO Auto-generated method stub

        Polynomial p1 = new Polynomial ();

        int nTerms = 100000;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTermLast ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        Polynomial p2 = p1.deepClone ();

        if (p1.size () != nTerms + 1 || p2.size () != nTerms + 1 || !p2.isDeepClone ( p1 )) {
            System.out.println ( "Failed deepCloneTest2" );
        }

    }

    private static void deepCloneTest3 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 100000;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTermLast ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        System.out.print ( "Starting stress test for deepClone(), expecting O(n)..." );

        Instant start = Instant.now ();
        Polynomial p2 = p1.deepClone ();
        Instant finish = Instant.now ();

        long executionTime = Duration.between ( start, finish ).toMillis ();

        if (executionTime > 200) {
            System.out.println ( "Failed." );
        } else {
            System.out.println ( "Passed." );
        }

        if (p1.size () != nTerms + 1 || p2.size () != nTerms + 1 || !p2.isDeepClone ( p1 )) {
            System.out.println ( "Failed deepCloneTest2" );
        }
    }

    // Checks adding empty term, regular term, and negative coefficient term to empty polynomial
    private static void addTermTest1 () {
        Polynomial p1 = new Polynomial ();
        Polynomial pExp1 = new Polynomial ();

        Term t1 = new Term ( 0, new BigInteger ( "1" ) );
        Term te = new Term ( 0, new BigInteger ( "1" ) );

        t1.setCoefficient ( BigInteger.ZERO );
        p1.addTerm ( t1 );

        if (p1.size () != 0 || pExp1.size () != 0 || !pExp1.isDeepClone ( p1 )) {
            System.out.println ( "Failed addTermTest1" );
        }

        p1 = new Polynomial ();
        t1.setCoefficient ( BigInteger.ONE );
        p1.addTerm ( t1 );
        pExp1.addTermLast ( te );

        if (p1.size () != 1 || pExp1.size () != 1 || !pExp1.isDeepClone ( p1 )) {
            System.out.println ( "Failed addTermTest1" );
        }

        p1 = new Polynomial ();
        pExp1 = new Polynomial ();
        t1.setExponent ( -1 );
        p1.addTerm ( t1 );

        if (p1.size () != 0 || pExp1.size () != 0 || !pExp1.isDeepClone ( p1 )) {
            System.out.println ( "Failed addTermTest1" );
        }


    }

    private static void addTermTest2 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 100000;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTermLast ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        System.out.print ( "Starting stress test for addTerm(), expecting O(n)..." );

        Term t1 = new Term ( 50, new BigInteger ( "384" ) );

        Instant start = Instant.now ();
        p1.addTerm ( t1 );
        Instant finish = Instant.now ();

        long executionTime = Duration.between ( start, finish ).toMillis ();

        if (executionTime > 200) {
            System.out.println ( "Failed." );
        } else {
            System.out.println ( "Passed." );
        }
    }

    private static void addTermTest3 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 100;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTerm ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        p1.addTerm ( new Term ( 21478, new BigInteger ( "298359635183" ) ) );

        if (!p1.getTerm ( 0 ).getCoefficient ().equals ( new BigInteger ( "298359635183" ) ) || p1.getTerm ( 0 ).getExponent () != 21478) {
            System.out.println ( "Failed addTermTest3()" );
        }

    }

    private static void addTermTest4 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 10;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTerm ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        p1.addTerm ( new Term ( 0, new BigInteger ( "1" ) ) );

        if (!p1.getTerm ( nTerms ).getCoefficient ().equals ( new BigInteger ( "5" ) ) || p1.getTerm ( nTerms ).getExponent () != 0) {
            System.out.println ( "Failed addTermTest4()" );
        }

    }

    private static void addTermTest5 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 10;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTerm ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        p1.addTerm ( new Term ( 1, new BigInteger ( "1" ) ) );

        if (!p1.getTerm ( nTerms - 1 ).getCoefficient ().equals ( new BigInteger ( "6" ) ) || p1.getTerm ( nTerms - 1 ).getExponent () != 1) {
            System.out.println ( "Failed addTermTest5()" );
        }

    }

    private static void addTermTest6 () {
        Polynomial p1 = new Polynomial ();

        int nTerms = 10;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTerm ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
        }

        p1.addTerm ( new Term ( 9, new BigInteger ( "1" ) ) );

        if (!p1.getTerm ( 1 ).getCoefficient ().equals ( new BigInteger ( "14" ) ) || p1.getTerm ( 1 ).getExponent () != 9) {
            System.out.println ( "Failed addTermTest6()" );
        }

    }

    private static void addTest1 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pE = new Polynomial ();

        p1.addTerm ( new Term ( 5, new BigInteger ( "9" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "7" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "1" ) ) );
        p1.addTerm ( new Term ( 9, new BigInteger ( "-34" ) ) );

        pE.addTerm ( new Term ( 5, new BigInteger ( "9" ) ) );
        pE.addTerm ( new Term ( 3, new BigInteger ( "7" ) ) );
        pE.addTerm ( new Term ( 4, new BigInteger ( "1" ) ) );
        pE.addTerm ( new Term ( 9, new BigInteger ( "-34" ) ) );

        if (!Polynomial.add ( p1, p2 ).isDeepClone ( pE )) {
            System.out.println ( "Failed addTest1" );
        }

    }

    private static void addTest2 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pE = new Polynomial ();

        if (!Polynomial.add ( p1, p2 ).isDeepClone ( pE )) {
            System.out.println ( "Failed addTest2" );
        }
    }

    private static void addTest3 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();

        int nTerms = 100000;

        for (int i = nTerms; i >= 0; i--) {
            p1.addTermLast ( new Term ( i, new BigInteger ( Integer.toString ( i + 4 ) ) ) );
            p2.addTermLast ( new Term ( i + 1, new BigInteger ( Integer.toString ( i + 2 ) ) ) );
        }

        System.out.print ( "Starting stress test for add(), expecting O(n)..." );


        Instant start = Instant.now ();
        Polynomial.add ( p1, p2 );
        Instant finish = Instant.now ();

        long executionTime = Duration.between ( start, finish ).toMillis ();

        if (executionTime > 200) {
            System.out.println ( "Failed." );
        } else {
            System.out.println ( "Passed." );
        }
    }

    private static void multiplyTest1 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pE = new Polynomial ();

        p1.addTerm ( new Term ( 0, new BigInteger ( "384" ) ) );
        p1.addTerm ( new Term ( 1, new BigInteger ( "34" ) ) );
        p1.addTerm ( new Term ( 2, new BigInteger ( "324" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "94" ) ) );


        if (Polynomial.multiply ( p1, p2 ).size () != 0 || !(Polynomial.multiply ( p1, p2 ).isDeepClone ( pE ))) {
            System.out.println ( "Failed multiplyTest1" );
        }
    }

    private static void multiplyTest2 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pE = new Polynomial ();

        if (Polynomial.multiply ( p1, p2 ).size () != 0 || !(Polynomial.multiply ( p1, p2 ).isDeepClone ( pE ))) {
            System.out.println ( "Failed multiplyTest2" );
        }
    }

    private static void multiplyTest3 () {
        Polynomial p1 = new Polynomial ();
        Polynomial p2 = new Polynomial ();
        Polynomial pE = new Polynomial ();

        p1.addTerm ( new Term ( 0, new BigInteger ( "-384" ) ) );
        p1.addTerm ( new Term ( 1, new BigInteger ( "34" ) ) );
        p1.addTerm ( new Term ( 2, new BigInteger ( "-324" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "94" ) ) );

        p2.addTerm ( new Term ( 9, new BigInteger ( "-3847" ) ) );

        Polynomial pM = Polynomial.multiply ( p1, p2 );
        p1.multiplyTerm ( p2.getTerm ( 0 ) );

        if (!p1.isDeepClone ( pM )) {
            System.out.println ( "Failed multiplyTest3" );
        }
    }

    private static void multiplyTest4 () {
        Polynomial p1 = new Polynomial ();

        p1.addTerm ( new Term ( 0, new BigInteger ( "384" ) ) );
        p1.addTerm ( new Term ( 1, new BigInteger ( "34" ) ) );
        p1.addTerm ( new Term ( 2, new BigInteger ( "324" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        p1.addTerm ( new Term ( 4, new BigInteger ( "94" ) ) );
        p1.addTerm ( new Term ( 6, new BigInteger ( "3857" ) ) );
        p1.addTerm ( new Term ( 78, new BigInteger ( "233587" ) ) );
        p1.addTerm ( new Term ( 34, new BigInteger ( "235" ) ) );
        p1.addTerm ( new Term ( 35, new BigInteger ( "35" ) ) );

        Polynomial p2 = new Polynomial ();

        p2.addTerm ( new Term ( 0, new BigInteger ( "384" ) ) );
        p2.addTerm ( new Term ( 1, new BigInteger ( "34" ) ) );
        p2.addTerm ( new Term ( 2, new BigInteger ( "324" ) ) );
        p2.addTerm ( new Term ( 3, new BigInteger ( "2" ) ) );
        p2.addTerm ( new Term ( 4, new BigInteger ( "94" ) ) );
        p2.addTerm ( new Term ( 6, new BigInteger ( "3857" ) ) );
        p2.addTerm ( new Term ( 78, new BigInteger ( "233587" ) ) );
        p2.addTerm ( new Term ( 34, new BigInteger ( "235" ) ) );
        p2.addTerm ( new Term ( 35, new BigInteger ( "35" ) ) );

        Polynomial pExp = new Polynomial ();

        pExp.addTerm ( new Term ( 0, new BigInteger ( "147456" ) ) );
        pExp.addTerm ( new Term ( 1, new BigInteger ( "26112" ) ) );
        pExp.addTerm ( new Term ( 2, new BigInteger ( "249988" ) ) );
        pExp.addTerm ( new Term ( 3, new BigInteger ( "23568" ) ) );
        pExp.addTerm ( new Term ( 4, new BigInteger ( "177304" ) ) );
        pExp.addTerm ( new Term ( 5, new BigInteger ( "7688" ) ) );
        pExp.addTerm ( new Term ( 6, new BigInteger ( "3023092" ) ) );
        pExp.addTerm ( new Term ( 7, new BigInteger ( "262652" ) ) );
        pExp.addTerm ( new Term ( 8, new BigInteger ( "2508172" ) ) );
        pExp.addTerm ( new Term ( 9, new BigInteger ( "15428" ) ) );
        pExp.addTerm ( new Term ( 10, new BigInteger ( "725116" ) ) );
        pExp.addTerm ( new Term ( 12, new BigInteger ( "14876449" ) ) );
        pExp.addTerm ( new Term ( 34, new BigInteger ( "180480" ) ) );
        pExp.addTerm ( new Term ( 35, new BigInteger ( "42860" ) ) );
        pExp.addTerm ( new Term ( 36, new BigInteger ( "154660" ) ) );
        pExp.addTerm ( new Term ( 37, new BigInteger ( "23620" ) ) );
        pExp.addTerm ( new Term ( 38, new BigInteger ( "44320" ) ) );
        pExp.addTerm ( new Term ( 39, new BigInteger ( "6580" ) ) );
        pExp.addTerm ( new Term ( 40, new BigInteger ( "1812790" ) ) );
        pExp.addTerm ( new Term ( 41, new BigInteger ( "269990" ) ) );
        pExp.addTerm ( new Term ( 68, new BigInteger ( "55225" ) ) );
        pExp.addTerm ( new Term ( 69, new BigInteger ( "16450" ) ) );
        pExp.addTerm ( new Term ( 70, new BigInteger ( "1225" ) ) );
        pExp.addTerm ( new Term ( 78, new BigInteger ( "179394816" ) ) );
        pExp.addTerm ( new Term ( 79, new BigInteger ( "15883916" ) ) );
        pExp.addTerm ( new Term ( 80, new BigInteger ( "151364376" ) ) );
        pExp.addTerm ( new Term ( 81, new BigInteger ( "934348" ) ) );
        pExp.addTerm ( new Term ( 82, new BigInteger ( "43914356" ) ) );
        pExp.addTerm ( new Term ( 84, new BigInteger ( "1801890118" ) ) );
        pExp.addTerm ( new Term ( 112, new BigInteger ( "109785890" ) ) );
        pExp.addTerm ( new Term ( 113, new BigInteger ( "16351090" ) ) );
        pExp.addTerm ( new Term ( 156, new BigInteger ( "54562886569" ) ) );


        Polynomial pM = Polynomial.multiply ( p1, p2 );

        if (!pM.isDeepClone ( pExp )) {
            System.out.println ( "Failed multiplyTest4" );
        }

    }

    private static void evalTest1 () {
        Polynomial p1 = new Polynomial ();
        p1.addTerm ( new Term ( 5, new BigInteger ( "6" ) ) );
        p1.addTerm ( new Term ( 3, new BigInteger ( "4" ) ) );
        BigInteger result = p1.eval ( new BigInteger ( "2" ) );

        if (!result.equals ( new BigInteger ( "224" ) )) {
            System.out.println ( "Failed evalTest1" );
        }
    }

    private static void evalTest2 () {
        Polynomial p1 = new Polynomial ();

        if (!p1.eval ( new BigInteger ( "5" ) ).equals ( new BigInteger ( "0" ) )) {
            System.out.println ( "Failed evalTest2" );
        }
    }

    private static void evalTest3 () {
        Polynomial p1 = new Polynomial ();
        p1.addTerm ( new Term ( 6, new BigInteger ( "17" ) ) );
        p1.addTerm ( new Term ( 1, new BigInteger ( "32" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "32" ) ) );

        if (!p1.eval ( new BigInteger ( "-1" ) ).equals ( new BigInteger ( "17" ) )) {
            System.out.println ( "Failed evalTest3" );
        }

    }

    private static void evalTest4 () {
        Polynomial p1 = new Polynomial ();
        p1.addTerm ( new Term ( 6, new BigInteger ( "17" ) ) );
        p1.addTerm ( new Term ( 1, new BigInteger ( "-32" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "32" ) ) );

        if (!p1.eval ( new BigInteger ( "1" ) ).equals ( new BigInteger ( "17" ) )) {
            System.out.println ( "Failed evalTest3" );
        }

    }

    private static void evalTest5 () {
        Polynomial p1 = new Polynomial ();
        p1.addTerm ( new Term ( 6, new BigInteger ( "17" ) ) );
        p1.addTerm ( new Term ( 2, new BigInteger ( "-64" ) ) );
        p1.addTerm ( new Term ( 0, new BigInteger ( "32" ) ) );

        if (!p1.eval ( new BigInteger ( "0" ) ).equals ( new BigInteger ( "32" ) )) {
            System.out.println ( "Failed evalTest3" );
        }

    }

    public static void main ( String[] args ) {

        deepCloneTest1 ();
        deepCloneTest2 ();
        deepCloneTest3 (); // stress tester from minitester

        addTermTest1 ();
        addTermTest2 (); // stress tester from minitester
        addTermTest3 ();
        addTermTest4 ();
        addTermTest5 ();
        addTermTest6 ();

        addTest1 ();
        addTest2 ();
        addTest3 (); // stress tester from minitester


        multiplyTest1 ();
        multiplyTest2 ();
        multiplyTest3 ();
        multiplyTest4 ();

        evalTest1 ();
        evalTest2 ();
        evalTest3 ();
        evalTest4 ();
        evalTest5 ();


        System.out.println ( "Done!" );

    }
}
