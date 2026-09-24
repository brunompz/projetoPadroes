package Entidades;

import Strategy.FormaDePagamento;
import java.util.ArrayList;
import java.util.List;

public class PedidoBase implements Pedido {
    private List<Produto> produtos;
    private FormaDePagamento formaDePagamento;

    public PedidoBase() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    @Override
    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println("Produto " + (i + 1) + ": " + p.getNome() + " | Descrição: " + p.getDescricao() + " | Preço: R$ " + p.getPreco());
        }
    }

    @Override
    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    @Override
    public FormaDePagamento getFormaDePagamento() {
        return this.formaDePagamento;
    }

    @Override
    public void processarPagamento() {
        if (this.formaDePagamento != null) {
            this.formaDePagamento.pagar(this.getTotal());
        }
    }

    @Override
    public void realizarPagamento(FormaDePagamento formaDePagamento) {
        setFormaDePagamento(formaDePagamento);
        processarPagamento();
    }
}
