package models;

import java.util.List;

public interface EstoqueDao {
    public Boolean adicionarProduto(Produto produto);
    public Boolean removerProduto(Produto produto);
    public List<Produto> buscarProdutos();
    public Produto buscarProdutoPorId(int id);
}
