/*
    Name: Aman Velani
    SUID: 982212915
*/
package edu.syr.hw5;

import java.util.HashMap;
import java.util.Map;

public class Rational {

    private int numer;
    private int denom;
    private int g;

    private static Rational UTILITY = new Rational();

    private Rational() {
        // Nothing here.
    }

    private Rational(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        this.g = gcd(n, d);
        this.numer = n/g;
        this.denom = d/g;
    }

    private static class RationalCacheImplementation {
        /*
            Cache Implementation of common fractions from -100/1 to 100/30
        */
        private static Map<String, Rational> map = new HashMap<>();

        static {
            for (int n=-100; n<=100; n++) {
                for (int d=1; d<=30; d++) {
                    Rational num = new Rational(n, d);
                    map.put(n + "/" + d, num);
                }
            }
            System.out.println("Cache initialized!");
        }
    }

    public static Rational getInstance(int n, int d) {
        int[] reduced = UTILITY.reduce(n, d);
        n = reduced[0];
        d = reduced[1];
        String stringRep = n + "/" + d;
        if (RationalCacheImplementation.map.containsKey(stringRep)) {
//            System.out.println("Cache hit!");
            return RationalCacheImplementation.map.get(stringRep);
        }
        return new Rational(n, d);
    }

    // This method is used to reduce the fraction to its lowest form
    private int[] reduce(int n, int d) {
        int[] result = new int[2];
        int g = gcd(n, d);
        result[0] = n/g;
        result[1] = d/g;
        return result;
    }

    public static Rational getInstance(int n) {
        return getInstance(n, 1);
    }

    private int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    // This method is used to print the fraction in the form of a string
    @Override
    public String toString() {
        int n = numer;
        int d = denom >= 1 ? denom : -denom;

        if ((numer < 0 && denom > 0) || (numer > 0 && denom < 0)) {
            n = -n;
        }
        return d==1 ? n +"" : n + "/" + d;
    }

    public Rational add(Rational that) {
        return getInstance(this.numer * that.denom + this.denom * that.numer,  this.denom * that.denom);
    }

    public Rational add(int that) {
        return this.add(getInstance(that));
    }

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return this.lessThan(getInstance(that));
    }

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {
        return this.max(getInstance(that));
    }

    public static void main(String[] args) {
        Rational half = Rational.getInstance(1, 2);
        Rational third = Rational.getInstance(1, 3);

        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);

        // Rational fiveSixths = new Rational(5, 6);
        Rational fiveSixths = Rational.getInstance(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false

        // Rational one = new Rational(1);
        Rational one = Rational.getInstance(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";

        // Rational fifteenOverTen = new Rational(15, 10);
        Rational fifteenOverTen = Rational.getInstance(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}