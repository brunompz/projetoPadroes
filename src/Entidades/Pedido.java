package Entidades;

import Strategy.FormaDePagamento;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    protected FormaDePagamento p;

    public Pedido() {
    }

    public void listarProdutos(){
        for(Produto p : produtos){
            System.out.println("Produto: " + p.getNome() + " | Descrição : " +p.getDescricao() + " | Preço: " + p.getPreco());
        }
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public float getTotal(){
        float total = 0;
        for (Produto p : produtos){
            total += p.getPreco();
        }
        return total;
    }

    public void realizarPagamento(FormaDePagamento formaDePagamento){
        this.p = formaDePagamento;
        this.p.realizarPagamento();
    }
}
