package CRUD;

import Entities.User;
import org.hibernate.Session;

public class Update {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User us2 = (User) session.get(User.class,202);
        us2.setName("Elvira Adams");
        session.save(us2);

        session.getTransaction().commit();
        session.close();
    }
}
