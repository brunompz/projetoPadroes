package Decorator;

import Entidades.Pedido;

public class Frete extends PedidoDecorator {
    private double precoFrete;

    public Frete(Pedido pedido, double precoFrete) {
        super(pedido);
        this.precoFrete = precoFrete;
    }

    public double getPrecoFrete() {
        return precoFrete;
    }

    @Override
    public double getTotal() {
        return pedidoDecorado.getTotal() + precoFrete;
    }

    @Override
    public void listarProdutos() {
        super.listarProdutos();
        System.out.println(" + Frete: R$ " + precoFrete);
    }
}
