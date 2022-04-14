package CRUD;

import Entities.Account;
import Entities.Country;
import Entities.Curency;
import Entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class Retrieve {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Country.class);
        List<Country> list = criteria.list();


        Criteria criteria1 = session.createCriteria(Curency.class);
        List<Curency> list1 = criteria1.list();


        Criteria criteria2 = session.createCriteria(User.class);
        List<User> list2 = criteria2.list();


        Criteria criteria3 = session.createCriteria(Account.class);
        List<Account> list3 = criteria3.list();

        System.out.println("");
        System.out.println("_______________________tCountries___________________________");
        System.out.println("Id |   Name   | Capital");
        System.out.println("------------------------------------------------------------");
        for(Country test: list) {
            System.out.println(test.getId() + " | " + test.getName() + " | " + test.getCapital());
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("");
        System.out.println("_______________________tCurencies___________________________");
        System.out.println(" Id | ISO |   Name   | Code");
        System.out.println("------------------------------------------------------------");
        for(Curency test1: list1) {
            System.out.println(test1.getId() + " | " + test1.getISO() + " | " + test1.getName() + " | " + test1.getCode());
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("");
        System.out.println("_________________________tUsers_____________________________");
        System.out.println(" Id |  Type  |   Name");
        System.out.println("------------------------------------------------------------");
        for(User test2: list2) {
            System.out.println(test2.getId() + " | " + test2.getType() + " | " + test2.getName());
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("");
        System.out.println("________________________tAcounts____________________________");
        System.out.println(" Id | Product Type |   Date   | User Id");
        System.out.println("------------------------------------------------------------");
        for(Account test3: list3) {
            System.out.println(test3.getId() + " | " + test3.getProduct_Type() + " | " + test3.getDate_Created() + " | " + test3.getUser().getId());
        }
        System.out.println("------------------------------------------------------------");


        session.getTransaction().commit();
        session.close();
    }
}
