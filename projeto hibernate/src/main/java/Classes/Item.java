package Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")

public class Item {

    @Id
    private int codigo;

    private int quantidade;

    @Column(name = "valor")
    private float valorItem;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    public Item() {
    }

    public Item(int codigo, int quantidade, float valorItem) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorItem() {
        return valorItem;
    }
}
