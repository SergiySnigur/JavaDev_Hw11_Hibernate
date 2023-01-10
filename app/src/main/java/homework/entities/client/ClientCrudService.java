package homework.entities.client;

import homework.utils.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientCrudService {

    public void createClient(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client getClientById(long id) {
        Client client;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public List<Client> getAllClients() {
        List<Client> allClients;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        allClients = session.createQuery("from Client", Client.class).list();
        session.close();
        return allClients;
    }

    public void updateClientById(long id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Client set name = :name where id = :id";
        Query query = session.createQuery(updateQuery);
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteClientById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "delete from Client where id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
