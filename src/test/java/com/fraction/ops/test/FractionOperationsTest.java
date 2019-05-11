package com.fraction.ops.test;

import com.fraction.ops.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionOperationsTest {

    @Test
    public void test_add_two_fraction_with_common_denominator(){
        assertSumOfFractionsIs(2, 3, 5);
        assertSumOfFractionsIs(0, 0, 0);
        assertSumOfFractionsIs(5, 5, 10);
    }

    @Test
    public void test_add_two_fraction(){
        assertSumOfFractionsIs(7, 3, 4, 5, 47, 15);
        assertSumOfFractionsIs(0, 0, 0, 0, 0, 0);
        assertSumOfFractionsIs(2, 3, 5, 3, 7, 3);
    }

    @Test
    public void test_minus_two_fraction(){
        assertMinusOfFractionsIs(0, 0, 0, 0, 0, 0);
        assertMinusOfFractionsIs(7, 3, 4, 5, 23, 15);
    }

    @Test
    public void test_multiply_two_fraction(){
        assertMultiplicationOfFractionsIs(0, 0, 0, 0, 0, 0);
        assertMultiplicationOfFractionsIs(7, 3, 4, 5, 28, 15);
    }

    @Test
    public void test_divide_two_fraction(){
        assertDivisionOfFractionsIs(0, 0, 0, 0, 0, 0);
        assertDivisionOfFractionsIs(7, 3, 4, 5, 35, 12);
    }

    private void assertSumOfFractionsIs(int n1, int n2, int nresult){
        assertEquals(Fraction.of(n1).add(Fraction.of(n2)), Fraction.of(nresult));
    }

    private void assertSumOfFractionsIs(int n1, int d1, int n2, int d2, int nresult, int dresult){
        assertEquals(Fraction.of(n1, d1).add(Fraction.of(n2, d2)), Fraction.of(nresult, dresult));
    }

    private void assertMinusOfFractionsIs(int n1, int d1, int n2, int d2, int nresult, int dresult){
        assertEquals(Fraction.of(n1, d1).minus(Fraction.of(n2, d2)), Fraction.of(nresult, dresult));
    }

    private void assertMultiplicationOfFractionsIs(int n1, int d1, int n2, int d2, int nresult, int dresult){
        assertEquals(Fraction.of(n1, d1).multiply(Fraction.of(n2, d2)), Fraction.of(nresult, dresult));
    }

    private void assertDivisionOfFractionsIs(int n1, int d1, int n2, int d2, int nresult, int dresult){
        assertEquals(Fraction.of(n1, d1).divide(Fraction.of(n2, d2)), Fraction.of(nresult, dresult));
    }
}
