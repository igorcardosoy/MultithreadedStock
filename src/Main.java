import models.EstoqueDaoImpl;
import models.Produto;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var estoque = EstoqueDaoImpl.getInstance();

        mockData(estoque);

        //mostar estoque
        estoque.buscarProdutos().forEach(System.out::println);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            var thread = new Thread(() -> {
                if (estoque.removerProduto(estoque.buscarProdutoPorId(finalI +1), 20))
                    System.out.println(20 + " Produtos removido por "+ Thread.currentThread().getName() + " : " + estoque.buscarProdutoPorId(finalI +1));
                else
                    System.out.println("Produtos não removido por "+ Thread.currentThread().getName() + " : " + estoque.buscarProdutoPorId(finalI +1));}
            );

            var thread2 = new Thread(() -> {
                if (estoque.removerProduto(estoque.buscarProdutoPorId(finalI +1), 15))
                    System.out.println(15 + " Produtos removido por "+ Thread.currentThread().getName() + " : " + estoque.buscarProdutoPorId(finalI +1));
                else
                    System.out.println("Produtos não removido por "+ Thread.currentThread().getName() + " : " + estoque.buscarProdutoPorId(finalI +1));}
            );

            thread2.start();
            thread.start();
        }




    }

    private static void mockData(EstoqueDaoImpl estoque) {
        String[] nomeProdutos = {"Mouse", "Teclado", "Cadeira", "Mousepad", "Webcam", "Microfone", "Headset", "Notebook", "Pc", "Monitor"};
        Double[] precoProdutos = {200.0, 300.0, 800.0, 100.0, 500.0, 250.0, 450.0, 3500.0, 5000.0, 780.0};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            estoque.adicionarProduto(new Produto(i + 1, nomeProdutos[i], precoProdutos[i], random.nextInt(1, 40)));
        }
    }
}