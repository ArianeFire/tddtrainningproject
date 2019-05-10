package com.calculator.test;

import com.calculator.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void before(){
        calculator = new Calculator();
    }

    @Test
    public void test_addition(){
        assertThat(calculator.add(1, 1), is(2));
    }
}
