import models.EstoqueDaoImpl;
import models.Produto;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var estoque = EstoqueDaoImpl.getInstance();

        mockData(estoque);
    }

    private static void mockData(EstoqueDaoImpl estoque) {
        String[] nomeProdutos = {"Mouse", "Teclado", "Cadeira", "Mousepad", "Webcam", "Microfone", "Headset", "Notebook", "Pc", "Monitor"};
        Double[] precoProdutos = {200.0, 300.0, 800.0, 100.0, 500.0, 250.0, 450.0, 3500.0, 5000.0, 780.0};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            estoque.adicionarProduto(new Produto(i + 1, nomeProdutos[i], precoProdutos[i], random.nextInt(1, 100)));
        }
    }
}