package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueDaoImpl implements EstoqueDao {
    private static EstoqueDaoImpl instance;
    private final Map<Integer, Produto> produtos;

    private EstoqueDaoImpl() {
        produtos = new HashMap<>();
    }

    public static synchronized EstoqueDaoImpl getInstance() {
        if (instance == null) {
            instance = new EstoqueDaoImpl();
        }
        return instance;
    }

    @Override
    public synchronized Boolean adicionarProduto(Produto produto) {
        return produtos.put(produto.getId(), produto) == null;
    }

    @Override
    public synchronized Boolean removerProduto(Produto produto) {
        return produtos.remove(produto.getId()) != null;
    }

    @Override
    public synchronized List<Produto> buscarProdutos() {
        return produtos.values().stream().toList();
    }

    @Override
    public synchronized Produto buscarProdutoPorId(int id) {
        return produtos.get(id);
    }
}
