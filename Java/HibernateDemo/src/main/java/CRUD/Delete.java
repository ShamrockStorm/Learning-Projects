package CRUD;

import Entities.Country;
import Entities.Curency;
import org.hibernate.Session;

public class Delete {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Country co5 = session.get(Country.class, 5);
        session.delete(co5);

        session.getTransaction().commit();
        session.close();
    }
}
