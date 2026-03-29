package Classes;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtoPerecivel")

public class ProdutoPerecivel extends Produto{
    private LocalDate validade;

    public ProdutoPerecivel (int id, String nome, float preco, int estoque, LocalDate validade) {
        super(id, nome, preco, estoque);
        this.validade = validade;
    }
    public ProdutoPerecivel (String nome, float preco, int estoque, LocalDate validade) {
        super(nome, preco, estoque);
        this.validade = validade;
    }

    public LocalDate getValidade () {
        return validade;
    }
}
