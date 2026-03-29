package Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Produto {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(name = "preço")
    private float preco;

    private int estoque;

    public Produto() {
    }

    // cadastrar produto
    public Produto(int id, String nome, float preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    public Produto(String nome, float preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // consultar dados de um determinado produto
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public int getEstoque() {
        return this.estoque;
    }

    // alterar os dados de um determinado produto
    public void alterarId(int id) {
        this.id = id;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public void alterarPreco(float preco) {
        this.preco = preco;
    }

    public void alterarEstoque(int estoque) {
        this.estoque = estoque;
    }

}
