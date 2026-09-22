package Entidades;

import Strategy.FormaDePagamento;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    protected FormaDePagamento formaDePagamento;
    private int contador;

    public Pedido() {
        this.produtos = new ArrayList<>();
        this.formaDePagamento = null;
        this.contador = 1;
    }

    public void listarProdutos(){
        for (Produto produto : produtos){
            System.out.println("Produto " + contador + ": " + produto.getNome() + " | Descrição : " + produto.getDescricao() + " | Preço: " + produto.getPreco());
            contador++;
        }
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public float getTotal(){
        float total = 0;
        for (Produto produto : produtos){
            total += produto.getPreco();
        }
        return total;
    }

    public void realizarPagamento(FormaDePagamento formaDePagamento){
        this.formaDePagamento = formaDePagamento;
        this.formaDePagamento.realizarPagamento();
    }
}
