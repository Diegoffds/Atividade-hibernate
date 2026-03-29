package Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtoEletronico")

public class ProdutoEletronico extends Produto {
    private int voltagem;

    public ProdutoEletronico () {}

    // cadastrar produto eletronico
    public ProdutoEletronico(int id, String nome, float preco, int estoque, int voltagem) {
        super(id, nome, preco, estoque);
        this.voltagem = voltagem;
    }
    public ProdutoEletronico(String nome, float preco, int estoque, int voltagem) {
        super(nome, preco, estoque);
        this.voltagem = voltagem;
    }

    // pegar a voltagem
    public int getVoltagem() {
        return voltagem;
    }
}
