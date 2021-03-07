package gt.edu.url;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{

    Calculator calculator;

    @BeforeEach
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void testSum(){
        assertEquals(25, calculator.sum(5, 20));
    }

    @Test
    public void testSubtract(){
        assertEquals(15, calculator.subtract(20, 5));
    }

    @Test
    public void testMultiply(){
        assertEquals(10, calculator.multiply(5, 2));
    }

    @Test
    public void testDivide(){
        assertEquals(4, calculator.divide(20, 5));
    }

    @Test
    @DisplayName("Test of 5 table")
    public void test5Table(){
        int[] numbers = {1, 2, 3, 4, 5};
        assertAll("5 table",
                () -> {assertEquals(5, calculator.multiply(5, 1));},
                () -> {assertEquals(10, calculator.multiply(5, 2));},
                () -> {assertEquals(15, calculator.multiply(5, 3));},
                () -> {assertEquals(20, calculator.multiply(5, 4));},
                () -> {assertEquals(25, calculator.multiply(5, 5));}
                );
    }

}
