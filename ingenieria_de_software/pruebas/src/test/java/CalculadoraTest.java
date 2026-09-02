import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void test_suma_numeros_positivos() {
        double resultado = calculadora.suma(5, 5);
        assertEquals(10.0, resultado);
    }

    @Test
    void test_resta_numeros_positivos() {
        double resultado = calculadora.resta(5, 4);
        assertEquals(1.0, resultado);
    }

    @Test
    void test_multiplicacion_numeros_positivos() {
        double resultado = calculadora.multiplicacion(5, 4);
        assertEquals(20.0, resultado);
    }

    @Test
    void test_division_numeros_positivos() {
        double resultado = calculadora.division(20, 4);
        assertEquals(5.0, resultado);
    }
}
