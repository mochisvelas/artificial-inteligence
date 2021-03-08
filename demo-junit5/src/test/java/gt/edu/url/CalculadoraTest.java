package gt.edu.url;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest{

    Calculadora calculadora;

    @BeforeEach
    public void init(){
        calculadora = new Calculadora();
    }

    @Test
    public void testSum(){
        assertEquals(25, calculadora.sum(5, 20));
    }

    @Test
    public void testSubtract(){
        assertEquals(15, calculadora.subtract(20, 5));
    }

    @Test
    public void testMultiply(){
        assertEquals(10, calculadora.multiply(5, 2));
    }

    @Test
    public void testDivide(){
        assertEquals(4, calculadora.divide(20, 5));
    }

    @Test
    @DisplayName("Test de la tabla del 5")
    public void test5Table(){
        int[] numbers = {1, 2, 3, 4, 5};
        assertAll("table del 5",
                () -> {assertEquals(5, calculadora.multiply(5, 1));},
                () -> {assertEquals(10, calculadora.multiply(5, 2));},
                () -> {assertEquals(15, calculadora.multiply(5, 3));},
                () -> {assertEquals(20, calculadora.multiply(5, 4));},
                () -> {assertEquals(25, calculadora.multiply(5, 5));}
                );
    }

}
