package homework.entities.client;

import homework.entities.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.h2.command.dml.Set;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
