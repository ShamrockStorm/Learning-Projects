package CRUD;

import Entities.Account;
import Entities.Country;
import Entities.Curency;
import Entities.User;
import org.hibernate.Session;

import java.util.Date;

public class Create {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Country co1 = new Country();
        co1.setId(1);
        co1.setName("Romania");
        co1.setCapital("Bucharest");

        Country co2 = new Country();
        co2.setId(2);
        co2.setName("Bulgaria");
        co2.setCapital("Sofia");

        Country co3 = new Country();
        co3.setId(3);
        co3.setName("France");
        co3.setCapital("Paris");

        Country co4 = new Country();
        co4.setId(4);
        co4.setName("Cuba");
        co4.setCapital("Havana");

        Curency cu1 = new Curency();
        cu1.setId(101);
        cu1.setName("Romanian leu");
        cu1.setCode("RON");
        cu1.setISO(946);

        Curency cu2 = new Curency();
        cu2.setId(102);
        cu2.setName("Bulgarian lev");
        cu2.setCode("BGN");
        cu2.setISO(975);

        Curency cu3 = new Curency();
        cu3.setId(103);
        cu3.setName("Euro");
        cu3.setCode("EUR");
        cu3.setISO(978);

        Curency cu4 = new Curency();
        cu4.setId(104);
        cu4.setName("Cuban Peso");
        cu4.setCode("CUP");
        cu4.setISO(192);

        Curency cu5 = new Curency();
        cu5.setId(105);
        cu5.setName("Convertable Peso");
        cu5.setCode("CUC");
        cu5.setISO(931);

        User us1 = new User();
        us1.setId(201);
        us1.setType("Person");
        us1.setName("Remus Pereria");

        User us2 = new User();
        us2.setId(202);
        us2.setType("Person");
        us2.setName("Elvira Bachchan");

        User us3 = new User();
        us3.setId(203);
        us3.setType("Company");
        us3.setName("Favero inc");



        Account ac1 = new Account();
        ac1.setId(301);
        ac1.setUser(us1);
        ac1.setProduct_Type("Debit");
        Date date = new Date();
        System.out.println(date.toString());
        ac1.setDate_Created(date);

        Account ac2 = new Account();
        ac2.setId(302);
        ac2.setUser(us2);
        ac2.setProduct_Type("Credit");
        Date date1 = new Date();
        ac2.setDate_Created(date1);

        Account ac3 = new Account();
        ac3.setId(303);
        ac3.setUser(us3);
        ac3.setProduct_Type("Credit");
        Date date2 = new Date();
        ac3.setDate_Created(date2);

        co4.getUsers().add(us1);
        co3.getUsers().add(us2);
        co3.getUsers().add(us3);

        co1.getCurencies().add(cu1);
        co2.getCurencies().add(cu2);
        co3.getCurencies().add(cu3);
        co4.getCurencies().add(cu4);
        co4.getCurencies().add(cu5);

        //ac1.getCurencies().add(cu4);
        //ac1.getCurencies().add(cu5);
        //ac2.getCurencies().add(cu3);
        //ac3.getCurencies().add(cu3);
        //ac3.getCurencies().add(cu5);

        cu3.getAccounts().add(ac2);
        cu3.getAccounts().add(ac3);
        cu4.getAccounts().add(ac1);
        cu5.getAccounts().add(ac1);
        cu5.getAccounts().add(ac3);

        //session.save(ac1);

        session.save(us1);

        session.save(ac1);
        session.save(ac2);
        session.save(ac3);

        session.save(co1);
        session.save(co2);
        session.save(co3);
        session.save(co4);

        session.getTransaction().commit();
        session.close();
    }
}
