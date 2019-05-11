package com.fraction.ops;

import java.util.function.Function;

import static java.util.Objects.isNull;

public class Fraction {
    private int nominateur;
    private int denominateur;

    public static Fraction of(int numerator) {
        return Fraction.of(numerator, 1);
    }

    public static Fraction of(int nominateur, int denominateur){
        return new Fraction(nominateur, denominateur);
    }

    private Fraction(int nominateur, int denominateur){
        this.nominateur = nominateur;
        this.denominateur = denominateur;
    }

    /**
     *
     * Sum given fraction to actual
     *
     * @param fraction
     * @return
     */
    public Fraction add(Fraction fraction){
        if(this.denominateur != fraction.denominateur){
            int nominateur = this.nominateur * fraction.denominateur + this.denominateur * fraction.nominateur;
            return Fraction.of(nominateur, getCommonDenominator(this, fraction));
        }
        return Fraction.of(nominateur + fraction.nominateur, this.denominateur);
    }

    /**
     *
     * Minus given fraction to the actual
     *
     * @param f2
     * @return
     */
    public Fraction minus(Fraction f2) {
        int nominateur = this.nominateur * f2.denominateur - this.denominateur * f2.nominateur;
        return Fraction.of(nominateur, getCommonDenominator(this, f2));
    }

    /**
     *
     * Multiply given fraction by the actual
     *
     * @param fraction
     * @return
     */
    public Fraction multiply(Fraction fraction) {
        return Fraction.of(getCommonNominator(this, fraction), getCommonDenominator(this, fraction));
    }

    /**
     *
     * Divide given fraction by the actual
     *
     * @param fraction
     * @return
     */
    public Fraction divide(Fraction fraction){
        return Fraction.of(nominateur * fraction.denominateur, denominateur * fraction.nominateur);
    }

    private int getCommonDenominator(Fraction f1, Fraction f2){
        return getCommonMinator(f1, f2, f -> f.denominateur);
    }

    private int getCommonNominator(Fraction f1, Fraction f2){
        return getCommonMinator(f1, f2, f -> f.nominateur);
    }

    private int getCommonMinator(Fraction f1, Fraction f2, Function<Fraction, Integer> minator){
        return minator.apply(f1) * minator.apply(f2);
    }

    @Override
    public boolean equals(Object obj) {
        if(isNull(obj)){
            return false;
        }
        if(!(obj instanceof Fraction)){
            return false;
        }

        Fraction aFraction = (Fraction)obj;

        return nominateur == aFraction.nominateur && denominateur == aFraction.denominateur;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", nominateur, denominateur);
    }
}
