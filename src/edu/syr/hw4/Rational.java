// SUID: 982212915
package edu.syr.hw4;

/* Adapted from Programming in Scala, Odersky */

public class Rational {
    private int numer;
    private int denom;
    private int g;
    public Rational(int n, int d) {
        if(d == 0){
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.g = gcd(n,d);
        this.numer = n / g;
        this.denom = d / g;
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public Rational(int n) {
        this.numer = n;
        this.denom = 1;
        this.g = n;
    }
    @Override
    public String toString() {
        return this.numer + "/" + this.denom;
    }

    public Rational add(Rational that) {
        int newNumer = (this.numer * that.denom) + (that.numer * this.denom);
        int newDenom = (this.denom * that.denom);
        return new Rational(newNumer, newDenom);
    }

    public Rational add(int that) {
        return add(new Rational(that));
    }

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return this.numer < that * this.denom;
    }

    public Rational max(Rational that) {
        if(this.lessThan(that)){
            return that;
        }else{
            return this;
        }
    }

    public Rational max(int that) {
        if(this.lessThan(that)){
            return new Rational(that);
        }else{
            return this;
        }
    }

    public static void main(String[] args) {
        Rational half = new Rational(1, 2);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}
