package Decorator;

import Entidades.Pedido;


public class EmbalagemPresente extends PedidoDecorator {
    private float precoEmbalagem;
    
    public EmbalagemPresente(Pedido pedido, float precoEmbalagem) {
        super(pedido);
        this.precoEmbalagem = precoEmbalagem;
    }

    @Override
    public void listarProdutos(){
        super.listarProdutos();
        System.out.println("Valor da embalagem para presente: " + getPrecoEmbalagem());
    }

    public float getPrecoEmbalagem() {
        return precoEmbalagem;
    }

    @Override
    public float getTotal() {
        return this.pedido.getTotal() + getPrecoEmbalagem();
    }
}
