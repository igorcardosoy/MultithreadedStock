package models;

import java.util.List;

public interface EstoqueDao {
    Boolean adicionarProduto(Produto produto);
    Boolean removerProduto(Produto produto);
    List<Produto> buscarProdutos();
    Produto buscarProdutoPorId(int id);
}
