package Decorator;

import Entidades.Pedido;

public abstract class PedidoDecorator extends Pedido {
    protected Pedido pedido;
    public PedidoDecorator(Pedido pedido) {
        super();
        this.pedido = pedido;
    }

    @Override
    public void listarProdutos(){
        pedido.listarProdutos();
    }
}
