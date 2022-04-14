package CRUD;

import Entities.Country;
import org.hibernate.Session;

public class AddCountryToDelete {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Country co5 = new Country();
        co5.setId(5);
        co5.setName("Russia");
        co5.setCapital("Moscow");

        session.save(co5);

        session.getTransaction().commit();
        session.close();
    }
}
