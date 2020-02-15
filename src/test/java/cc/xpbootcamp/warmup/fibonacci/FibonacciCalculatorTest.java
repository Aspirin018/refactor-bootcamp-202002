package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciCalculatorTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        Long result = fibonacciCalculator.calculate(1);
        assertEquals(Long.valueOf(1L), result);
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        Long result = fibonacciCalculator.calculate(2);
        assertEquals(Long.valueOf(1L), result);
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3(){
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        Long result = fibonacciCalculator.calculate(3);
        assertEquals(Long.valueOf(2L), result);
    }
}
