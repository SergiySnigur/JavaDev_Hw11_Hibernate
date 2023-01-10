package homework.entities.planet;

import homework.entities.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsTo;

}
