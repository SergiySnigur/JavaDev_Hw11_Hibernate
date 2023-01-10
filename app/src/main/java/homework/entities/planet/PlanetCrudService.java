package homework.entities.planet;

import homework.utils.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService {
    public void createPlanet(Planet planet) {
        if (planet.getId().matches("^[A-Z0-9]+$")) {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
            session.close();
        } else {
            System.out.println("Name is invalid!");
        }
    }

    public Planet getPlanetById(String id) {
        Planet planet;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public List<Planet> getAllPlanets() {
        List<Planet> allPlanets;
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        allPlanets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return allPlanets;
    }

    public void updatePlanetById(String id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Planet set name = :name where id = :id";
        Query query = session.createQuery(updateQuery);
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deletePlanetById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "delete from Planet where id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
