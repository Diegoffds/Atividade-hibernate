package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")

public class Pedido {
    @OneToMany(mappedBy = "pedido")
    private List<Item> itens = new ArrayList<>();

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;

    @Column(name = "valortotal")
    private float valorTotal;

    public Pedido(int id, LocalDate data, float valorTotal) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public float getValorTotal() {
        return valorTotal;
    }
}
