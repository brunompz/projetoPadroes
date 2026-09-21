package Decorator;

import Entidades.Pedido;

public class Frete extends PedidoDecorator {
    private float precoFrete;
    public Frete(Pedido pedido, float precoFrete) {
        super(pedido);
        this.precoFrete = precoFrete;
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
