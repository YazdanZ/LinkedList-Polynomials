package assignment2;

import java.math.BigInteger;
import java.util.Iterator;

public class Polynomial implements DeepClone<Polynomial> {
    private SLinkedList<Term> polynomial;

    public int size () {
        return polynomial.size ();
    }

    private Polynomial ( SLinkedList<Term> p ) {
        polynomial = p;
    }

    public Polynomial () {
        polynomial = new SLinkedList<Term> ();
    }

    // Returns a deep copy of the object.
    public Polynomial deepClone () {
        return new Polynomial ( polynomial.deepClone () );
    }

    /**
     * Add a new term to the polynomial.
     * Added terms will be inserted in the polynomial so that terms are
     * sorted by exponents. If a term with the same exponent as the one we
     * want to add exists, the method will simply add their coefficients
     *
     * @param t term to add
     */
    public void addTerm ( Term t ) {
        // Check if the term to be added to the polynomial is a valid term
        if (t.getExponent () < 0 || t.getCoefficient ().compareTo ( new BigInteger ( "0" ) ) == 0)
            return;

        // if we have an empty polynomial we can add the Term without finding its position to insert
        if(size () == 0){
            polynomial.addFirst ( t );
            return;
        }

        // to keep record of the index to be able to insert the term in the middle of the list if required
        int position = 0;
        for (Term term : polynomial) {

            // if there exists a term with the same exponent as the term
            // we want to add, we can add their coefficients instead
            if (term.getExponent () == t.getExponent ()) {

                BigInteger newCoefficient = term.getCoefficient ().add ( t.getCoefficient () );
                term.setCoefficient ( newCoefficient );

                break;
            }

            // because the polynomial terms should be in decreasing order of exponents,
            // we verify if the current term's exponent is smaller than the exponent of
            // the term we want to add. This is done to find the right index to insert the term
            if(term.getExponent () < t.getExponent ()){
                polynomial.add ( position, t );
                break;
            }

            // if we are getting to the end of our polynomial and none of the above if statements were true
            // we can simply add the term to the end of the polynomial
            if(position == size () - 1){
                polynomial.addLast ( t );
                break;
            }

            // update the index
            position++;
        }
    }


    public Term getTerm ( int index ) {
        return polynomial.get ( index );
    }

    /**
     * Add two polynomial and return the resulting polynomial
     *
     * @param p1 polynomial1
     * @param p2 polynomial2
     * @return resulting polynomial from the addition of polynomial1 and polynomial2
     */
    public static Polynomial add ( Polynomial p1, Polynomial p2 ) {

        Polynomial resultPolynomial = new Polynomial ();

        for (Term term : p1.polynomial)
            resultPolynomial.addTerm ( term );

        for (Term term : p2.polynomial)
            resultPolynomial.addTerm ( term );

        return resultPolynomial;
    }

    /**
     * Multiply the polynomial by a given term
     * @param t term by which to multiply the polynomials
     */
    public void multiplyTerm ( Term t ) {
        int argumentTermExponent = t.getExponent ();
        BigInteger argumentTermCoefficient = t.getCoefficient ();

        if(size () == 0)
            return;

        for (Term term : this.polynomial){
            // coefficients are multiplied
            term.setCoefficient ( term.getCoefficient ().multiply ( argumentTermCoefficient ) );

            // exponents are added to each other
            term.setExponent ( term.getExponent () + argumentTermExponent );
        }
    }

    //TODO: multiply two polynomials
    public static Polynomial multiply ( Polynomial p1, Polynomial p2 ) {

        Polynomial resultPolynomial = new Polynomial ();

        for ( Term term : p1.polynomial ){
            Polynomial deepClonedPolynomial = p2.deepClone ();
            deepClonedPolynomial.multiplyTerm ( term );
            resultPolynomial = Polynomial.add (resultPolynomial, deepClonedPolynomial);
        }

        return resultPolynomial;
    }

    // TODO: evaluate this polynomial.
    // Hint:  The time complexity of eval() must be order O(m),
    // where m is the largest degree of the polynomial. Notice
    // that the function SLinkedList.get(index) method is O(m),
    // so if your eval() method were to call the get(index)
    // method m times then your eval method would be O(m^2).
    // Instead, use a Java enhanced for loop to iterate through
    // the terms of an SLinkedList.

    public BigInteger eval ( BigInteger x ) {
        /**** ADD CODE HERE ****/
        return new BigInteger ( "0" );
    }

    // Checks if this polynomial is a clone of the input polynomial
    public boolean isDeepClone ( Polynomial p ) {
        if (p == null || polynomial == null || p.polynomial == null || this.size () != p.size ())
            return false;

        int index = 0;
        for (Term term0 : polynomial) {
            Term term1 = p.getTerm ( index );

            // making sure that p is a deep clone of this
            if (term0.getExponent () != term1.getExponent () ||
                    term0.getCoefficient ().compareTo ( term1.getCoefficient () ) != 0 || term1 == term0)
                return false;

            index++;
        }
        return true;
    }

    // This method blindly adds a term to the end of LinkedList polynomial.
    // Avoid using this method in your implementation as it is only used for testing.
    public void addTermLast ( Term t ) {
        polynomial.addLast ( t );
    }


    @Override
    public String toString () {
        if (polynomial.size () == 0) return "0";
        return polynomial.toString ();
    }
}
