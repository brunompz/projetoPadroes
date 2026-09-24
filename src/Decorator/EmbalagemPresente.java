package Decorator;

import Entidades.Pedido;

public class EmbalagemPresente extends PedidoDecorator {
    private double precoEmbalagem;

    public EmbalagemPresente(Pedido pedido, double precoEmbalagem) {
        super(pedido);
        this.precoEmbalagem = precoEmbalagem;
    }

    public double getPrecoEmbalagem() {
        return precoEmbalagem;
    }

    @Override
    public double getTotal() {
        return pedidoDecorado.getTotal() + precoEmbalagem;
    }

    @Override
    public void listarProdutos() {
        super.listarProdutos();
        System.out.println(" + Embalagem para Presente: R$ " + precoEmbalagem);
    }
}
