package models;

public class Produto {
    private final int id;
    private final String name;
    private final double preco;
    private int quantidade;

    public Produto(int id, String name, double preco, int quantidade) {
        this.id = id;
        this.name = name;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade){
            this.quantidade += quantidade;
        }
    }
}
