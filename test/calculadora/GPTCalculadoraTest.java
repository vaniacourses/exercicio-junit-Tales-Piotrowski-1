package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Teste soma com valores positivos")
    void testSomaValoresPositivos() {
        assertEquals(8, calculadora.soma(5, 3));
    }

    @Test
    @DisplayName("Teste soma com zero")
    void testSomaComZero() {
        assertEquals(5, calculadora.soma(5, 0));
    }

    @Test
    @DisplayName("Teste soma com valores negativos")
    void testSomaComNegativos() {
        assertEquals(-8, calculadora.soma(-5, -3));
    }

    @Test
    @DisplayName("Teste subtração com valores positivos")
    void testSubtracaoValoresPositivos() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    @DisplayName("Teste subtração com resultado negativo")
    void testSubtracaoResultadoNegativo() {
        assertEquals(-2, calculadora.subtracao(3, 5));
    }

    @Test
    @DisplayName("Teste multiplicação com valores positivos")
    void testMultiplicacaoValoresPositivos() {
        assertEquals(15, calculadora.multiplicacao(5, 3));
    }

    @Test
    @DisplayName("Teste multiplicação com zero")
    void testMultiplicacaoComZero() {
        assertEquals(0, calculadora.multiplicacao(5, 0));
    }

    @Test
    @DisplayName("Teste multiplicação com valores negativos")
    void testMultiplicacaoComNegativos() {
        assertEquals(-15, calculadora.multiplicacao(-5, 3));
    }

    @Test
    @DisplayName("Teste divisão com valores positivos")
    void testDivisaoValoresPositivos() {
        assertEquals(2, calculadora.divisao(6, 3));
    }

    @Test
    @DisplayName("Teste divisão por número negativo")
    void testDivisaoPorNegativo() {
        assertEquals(-2, calculadora.divisao(6, -3));
    }

    @Test
    @DisplayName("Teste divisão por zero deve lançar ArithmeticException")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(6, 0));
    }

    @Test
    @DisplayName("Teste somatória de número positivo")
    void testSomatoriaPositiva() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5
    }

    @Test
    @DisplayName("Teste somatória com zero")
    void testSomatoriaComZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Teste somatória com número negativo")
    void testSomatoriaNegativa() {
        assertEquals(0, calculadora.somatoria(-5)); // não entra no loop
    }

    @Test
    @DisplayName("Teste ehPositivo com número positivo")
    void testEhPositivoComNumeroPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Teste ehPositivo com zero")
    void testEhPositivoComZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Teste ehPositivo com número negativo")
    void testEhPositivoComNumeroNegativo() {
        assertFalse(calculadora.ehPositivo(-10));
    }

    @Test
    @DisplayName("Teste compara quando números são iguais")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Teste compara quando primeiro número é maior")
    void testComparaPrimeiroMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    @DisplayName("Teste compara quando segundo número é maior")
    void testComparaSegundoMaior() {
        assertEquals(-1, calculadora.compara(5, 10));
    }
}
