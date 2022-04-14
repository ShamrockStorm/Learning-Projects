package CRUD;

import Entities.Country;
import Entities.Curency;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RetrieveCriteria {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        session.beginTransaction();

        CriteriaQuery<Object[]> cr = cb.createQuery(Object[].class);
        Root<Country> root = cr.from(Country.class);
        Root<Curency> root1 = cr.from(Curency.class);

        cr.multiselect(root.get("name"),root1.get("name"),root.get("id"),root1.get("country").get("id"));
        Query<Object[]> query = session.createQuery(cr);
        List<Object[]> results = query.getResultList();

        System.out.println("------------------------------------------------------------");
        for(Object[] r : results) {
            if(r[2] == r[3])
                System.out.println(r[0]+" "+r[1]);
        }
        System.out.println("------------------------------------------------------------");

        session.getTransaction().commit();
        session.close();

    }
}
