package CRUD;

import Entities.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class RetrieveQueryHQL {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select u from User u where u.type = 'Person' and country.id > '3'");
        List<User> users = query.list();

        System.out.println("------------------------------------------------------------");
        for(User u : users) {
            System.out.println(u.getName());
        }
        System.out.println("------------------------------------------------------------");

        Query query2 = session.createQuery("select u from User u where u.type = 'Person' and account.product_Type = 'Credit'");
        List<User> users2 = query2.list();

        System.out.println("------------------------------------------------------------");
        for(User u : users2) {
            System.out.println(u.getName());
        }
        System.out.println("------------------------------------------------------------");

        session.getTransaction().commit();
        session.close();
    }
}
