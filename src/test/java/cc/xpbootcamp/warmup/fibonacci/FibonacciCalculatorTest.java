package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciCalculatorTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        long result = fibonacciCalculator.calculate(1);
        assertEquals(1, result);
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        long result = fibonacciCalculator.calculate(2);
        assertEquals(1, result);
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        long result = fibonacciCalculator.calculate(3);
        assertEquals(2, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_calculate_given_position_is_0(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        fibonacciCalculator.calculate(0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_calculate_given_position_is_51(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        fibonacciCalculator.calculate(51);
    }
}
