package models;

import java.util.List;

public interface EstoqueDao {
    Boolean adicionarProduto(Produto produto);
    Boolean removerProduto(Produto produto,int quantidade);
    List<Produto> buscarProdutos();
    Produto buscarProdutoPorId(int id);
}
