package Decorator;

import Entidades.Pedido;

public class EntregaRapida extends PedidoDecorator {
    private double precoEntregaRapida;

    public EntregaRapida(Pedido pedido, double precoEntregaRapida) {
        super(pedido);
        this.precoEntregaRapida = precoEntregaRapida;
    }

    public double getPrecoEntregaRapida() {
        return precoEntregaRapida;
    }

    @Override
    public double getTotal() {
        return pedidoDecorado.getTotal() + precoEntregaRapida;
    }

    @Override
    public void listarProdutos() {
        super.listarProdutos();
        System.out.println(" + Entrega Rápida: R$ " + precoEntregaRapida);
    }
}
