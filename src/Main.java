import Decorator.Desconto;
import Decorator.EmbalagemPresente;
import Decorator.Frete;
import Entidades.Pedido;
import Entidades.Produto;
import Strategy.CartaoCredito;
import Strategy.Dinheiro;
import Strategy.Pix;

public class Main{
    public static void main(String[] args) {
        
        // ==========================
        // Pedido 01
        // ==========================

        System.out.println(" ");
        System.out.println("==========================");
        System.out.println("Pedido 01: ");
        System.out.println("==========================");
        System.out.println(" ");

        Pedido pedido1 = new Pedido();
        
        pedido1.addProduto(new Produto(1, "Iphone 13", "Telefone da Apple", 2300));
        pedido1.addProduto(new Produto(2, "Tablet", "Tablet pro", 4000));
        Frete frete1 = new Frete(pedido1, 60);
       
        frete1.listarProdutos();
        System.out.println(frete1.getTotal());
        pedido1.realizarPagamento(new Pix());


        // ==========================
        // Pedido 02
        // ==========================

        System.out.println(" ");
        System.out.println("==========================");
        System.out.println("Pedido 02: ");
        System.out.println("==========================");
        System.out.println(" ");

        Pedido pedido2 = new Pedido();

        pedido2.addProduto(new Produto(3, "Nintendo Switch 2", "Video-game da Nintendo", 4200));
        pedido2.addProduto(new Produto(4, "Assinatura Netflix", "Assinatura do serviço de Streaming: Netflix", 23.10f));

        EmbalagemPresente pedidoEmbalagem1 = new EmbalagemPresente(pedido2, 30);
        pedidoEmbalagem1.listarProdutos();
        
        System.out.println(" ");

        System.out.println("Total do pedido: " + pedidoEmbalagem1.getTotal());

        System.out.println(" ");

        pedidoEmbalagem1.realizarPagamento(new Dinheiro());

        // ==========================
        // Pedido 03: frete + 10% de desconto, pago no cartão de crédito em 3x
        // ==========================

        System.out.println(" ");
        System.out.println("==========================");
        System.out.println("Pedido 03: ");
        System.out.println("==========================");
        System.out.println(" ");

        Pedido pedido3 = new Pedido();
        pedido3.addProduto(new Produto(3, "Notebook", "Notebook 16GB", 5000));
        Pedido pedidoComFrete = new Frete(pedido3, 100);
        Pedido pedidoFinal = new Desconto(pedidoComFrete, 10);
        pedidoFinal.listarProdutos();
        System.out.println(" ");
        System.out.println("Total: " + pedidoFinal.getTotal());
        System.out.println(" ");
        pedidoFinal.realizarPagamento(new CartaoCredito(3));



        // ==========================
        // Pedido 04
        // ==========================

        System.out.println(" ");
        System.out.println("==========================");
        System.out.println("Pedido 04: ");
        System.out.println("==========================");
        System.out.println(" ");

    }    
}
