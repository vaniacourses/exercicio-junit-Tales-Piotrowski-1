package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto bola;
    private Produto chuteira;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        bola = new Produto("Bola de Futebol", 120.0);
        chuteira = new Produto("Chuteira Nike", 350.0);
    }

    @Test
    @DisplayName("Deve adicionar itens no carrinho")
    public void testAddItem() {
        carrinho.addItem(bola);
        carrinho.addItem(chuteira);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve calcular o valor total corretamente")
    public void testGetValorTotal() {
        carrinho.addItem(bola);
        carrinho.addItem(chuteira);

        double total = carrinho.getValorTotal();

        assertEquals(470.0, total);
    }

    @Test
    @DisplayName("Deve remover item existente")
    public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(bola);
        carrinho.removeItem(bola);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve lançar exceção ao remover item inexistente")
    public void testRemoveItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(bola));
    }

    @Test
    @DisplayName("Deve esvaziar o carrinho")
    public void testEsvazia() {
        carrinho.addItem(bola);
        carrinho.addItem(chuteira);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertTrue(carrinho.getValorTotal() == 0.0);
    }
}
