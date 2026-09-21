package Decorator;

import Entidades.Pedido;

public class Frete extends PedidoDecorator {
    private float precoFrete = 50;
    public Frete(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void listarProdutos(){
        super.listarProdutos();
        System.out.println(" + Frete: " + getPrecoFrete());
    }

    public float getPrecoFrete() {
        return precoFrete;
    }

    @Override
    public float getTotal() {
        return this.pedido.getTotal() + getPrecoFrete();
    }

}
