import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe de testes do Jokenpo")
public class MainTest {

    private Main jogo;

    @BeforeEach
    public void inicializa() {
        jogo = new Main();
    }

    @Test
    @DisplayName("Deve retornar empate quando escolhas são iguais")
    public void testEmpate() {
        assertEquals(0, jogo.jogar(1, 1));
        assertEquals(0, jogo.jogar(2, 2));
        assertEquals(0, jogo.jogar(3, 3));
    }

    @Test
    @DisplayName("Deve retornar vitória do jogador 1")
    public void testVitoriaJogador1() {
        assertEquals(1, jogo.jogar(1, 2));
        assertEquals(1, jogo.jogar(2, 3));
        assertEquals(1, jogo.jogar(3, 1));
    }

    @Test
    @DisplayName("Deve retornar vitória do jogador 2")
    public void testVitoriaJogador2() {
        assertEquals(2, jogo.jogar(2, 1));
        assertEquals(2, jogo.jogar(3, 2));
        assertEquals(2, jogo.jogar(1, 3));
    }

    @Test
    @DisplayName("Deve retornar -1 quando opção é inválida")
    public void testOpcaoInvalida() {
        assertEquals(-1, jogo.jogar(0, 1));
        assertEquals(-1, jogo.jogar(4, 2));
        assertEquals(-1, jogo.jogar(1, 5));
        assertEquals(-1, jogo.jogar(-3, -2));
    }
}

