package Classes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtoPerecivel")

public class ProdutoPerecivel extends Produto{
    private Date validade;

    public ProdutoPerecivel () {}

    public ProdutoPerecivel (int id, String nome, float preco, int estoque, Date validade) {
        super(id, nome, preco, estoque);
        this.validade = validade;
    }
    public ProdutoPerecivel (String nome, float preco, int estoque, Date validade) {
        super(nome, preco, estoque);
        this.validade = validade;
    }

    public Date getValidade () {
        return validade;
    }
}
