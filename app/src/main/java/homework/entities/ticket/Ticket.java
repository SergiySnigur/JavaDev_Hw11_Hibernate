package homework.entities.ticket;

import homework.entities.client.Client;
import homework.entities.planet.Planet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet from;

//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet to;
}
