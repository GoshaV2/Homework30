package config;

import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class HibernateManager {
    private SessionFactory sessionFactory;

    public HibernateManager() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(City.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void withEntityManager(Consumer<EntityManager> consumer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            consumer.accept(session);
            session.getTransaction().commit();
        }
    }
}
