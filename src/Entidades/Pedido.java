package Entidades;

import Strategy.FormaDePagamento;
import java.util.List;

public interface Pedido {

    void addProduto(Produto produto);

    List<Produto> getProdutos();

    double getTotal();

    void listarProdutos();

    void setFormaDePagamento(FormaDePagamento formaDePagamento);

    FormaDePagamento getFormaDePagamento();

    void realizarPagamento(FormaDePagamento formaDePagamento);

    void processarPagamento();
}
