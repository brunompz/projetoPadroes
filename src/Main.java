import Decorator.Desconto;
import Decorator.Frete;
import Entidades.Pedido;
import Entidades.Produto;
import Strategy.CartaoCredito;
import Strategy.Pix;

public class Main{
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido();
        pedido1.addProduto(new Produto(1, "Iphone 13", "Telefone da Apple", 2300));
        pedido1.addProduto(new Produto(2, "Tablet", "Tablet pro", 4000));
        Frete frete1 = new Frete(pedido1, 60);
        frete1.listarProdutos();
        System.out.println(frete1.getTotal());
        pedido1.realizarPagamento(new Pix());
    }
}
System.out.println();

// Pedido 2: frete + 10% de desconto, pago no cartão de crédito em 3x
Pedido pedido2 = new Pedido();
pedido2.addProduto(new Produto(3, "Notebook", "Notebook 16GB", 5000));
Pedido pedidoComFrete = new Frete(pedido2, 100);
Pedido pedidoFinal = new Desconto(pedidoComFrete, 10);
pedidoFinal.listarProdutos();
System.out.println("Total: " + pedidoFinal.getTotal());
pedidoFinal.realizarPagamento(new CartaoCredito(3));