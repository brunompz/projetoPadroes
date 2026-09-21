import Decorator.Frete;
import Entidades.Pedido;
import Entidades.Produto;
import Strategy.Pix;

public class Main{
    static void main(String[] args) {
        Pedido pedido1 = new Pedido();
        pedido1.addProduto(new Produto(1, "Iphone 13", "Telefone da Apple", 2300));
        pedido1.addProduto(new Produto(2, "Tablet", "Tablet pro", 4000));
        Frete frete1 = new Frete(pedido1, 60);
        frete1.listarProdutos();
        System.out.println(frete1.getTotal());
        pedido1.realizarPagamento(new Pix());
    }
}