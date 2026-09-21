package Entidades;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private float preco;

    public Produto(Integer id, String nome, String descricao, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

}
