package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;
    private Produto produtoMesmoNome;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Notebook", 2500.00);
        produto2 = new Produto("Mouse", 50.00);
        produtoMesmoNome = new Produto("Notebook", 3000.00); // mesmo nome, preço diferente
    }

    @Test
    @DisplayName("Carrinho inicia vazio")
    void testCarrinhoInicialmenteVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Adicionar item no carrinho")
    void testAdicionarItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(2500.00, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Adicionar múltiplos itens no carrinho")
    void testAdicionarMultiplosItens() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(2550.00, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Adicionar produtos com mesmo nome (equals considera nome)")
    void testAdicionarProdutosMesmoNome() {
        carrinho.addItem(produto1);
        carrinho.addItem(produtoMesmoNome);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(5500.00, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Remover item existente do carrinho")
    void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Remover item inexistente deve lançar exceção")
    void testRemoverItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto1));
    }

    @Test
    @DisplayName("Remover produto com mesmo nome (equals apenas nome)")
    void testRemoverProdutoMesmoNome() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produtoMesmoNome);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Esvaziar carrinho")
    void testEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Calcular valor total com itens repetidos")
    void testValorTotalComItensRepetidos() {
        carrinho.addItem(produto2);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(100.00, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Adicionar produto com preço negativo (comportamento atual)")
    void testAdicionarProdutoPrecoNegativo() {
        Produto produtoNegativo = new Produto("Desconto", -100.00);
        carrinho.addItem(produtoNegativo);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(-100.00, carrinho.getValorTotal(), 0.0001);
    }
}
