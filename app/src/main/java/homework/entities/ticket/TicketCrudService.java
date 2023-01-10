package homework.entities.ticket;

import homework.entities.client.Client;
import homework.entities.client.ClientCrudService;
import homework.entities.planet.Planet;
import homework.entities.planet.PlanetCrudService;
import homework.utils.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TicketCrudService {

    public void createTicket(Client client, Planet toPlanet, Planet fromPlanet) {
        if (client != null && toPlanet != null && fromPlanet != null) {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setFrom(fromPlanet);
            ticket.setTo(toPlanet);
            session.persist(ticket);
            transaction.commit();
            session.close();
        }
    }

    public void updateTicketById(long id, Client client, Planet toPlanet, Planet fromPlanet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setClient(client);
        ticket.setTo(toPlanet);
        ticket.setFrom(fromPlanet);
        session.persist(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket getById(long id) {
        Ticket ticket;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> allTickets;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        allTickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return allTickets;
    }

    public void deleteTicketById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "delete from Ticket where id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
