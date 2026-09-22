package Decorator;
import Entidades.Pedido;

public class Desconto extends PedidoDecorator {
    private float percentual;

    public Desconto(Pedido pedido, float percentual) {
        super(pedido);
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 0 e 100");
        }
        this.percentual = percentual;
    }

    public float getPercentual() {
        return percentual;
    }

    // Valor em reais descontado do total do pedido envolvido
    public float getValorDesconto() {
        return this.pedido.getTotal() * (percentual / 100);
    }

    @Override
    public void listarProdutos() {
        super.listarProdutos();
        System.out.println(" - Desconto: " + getPercentual() + "% (" + getValorDesconto() + ")");
    }

    @Override
    public float getTotal() {
        return this.pedido.getTotal() - getValorDesconto();
    }
}