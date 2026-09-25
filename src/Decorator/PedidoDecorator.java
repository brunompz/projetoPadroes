package Decorator;

import Entidades.Pedido;
import Entidades.Produto;
import Strategy.FormaDePagamento;
import java.util.List;

public abstract class PedidoDecorator implements Pedido {
    protected Pedido pedidoDecorado;

    public PedidoDecorator(Pedido pedido) {
        this.pedidoDecorado = pedido;
    }

    @Override
    public void addProduto(Produto produto) {
        pedidoDecorado.addProduto(produto);
    }

    @Override
    public List<Produto> getProdutos() {
        return pedidoDecorado.getProdutos();
    }

    @Override
    public double getTotal() {
        return pedidoDecorado.getTotal();
    }

    @Override
    public void listarProdutos() {
        pedidoDecorado.listarProdutos();
    }

    @Override
    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        pedidoDecorado.setFormaDePagamento(formaDePagamento);
    }

    @Override
    public FormaDePagamento getFormaDePagamento() {
        return pedidoDecorado.getFormaDePagamento();
    }

    @Override
    public void realizarPagamento(FormaDePagamento formaDePagamento) {
        setFormaDePagamento(formaDePagamento);
        formaDePagamento.pagar(this.getTotal());
    }
}
