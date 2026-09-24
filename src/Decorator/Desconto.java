package Decorator;

import Entidades.Pedido;

public class Desconto extends PedidoDecorator {
    private double percentual;

    public Desconto(Pedido pedido, double percentual) {
        super(pedido);
        this.percentual = percentual;
    }

    public double getPercentual() {
        return percentual;
    }

    public double getValorDesconto() {
        return pedidoDecorado.getTotal() * (percentual / 100);
    }

    @Override
    public double getTotal() {
        return pedidoDecorado.getTotal() - getValorDesconto();
    }

    @Override
    public void listarProdutos() {
        super.listarProdutos();
        System.out.println(" - Desconto: " + percentual + "% (-R$ " + getValorDesconto() + ")");
    }
}