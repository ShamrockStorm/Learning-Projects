package CRUD;

import Entities.Account;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class Streams {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        session.beginTransaction();

        CriteriaQuery<Account> AccountCriteria = builder.createQuery(Account.class);
        Root<Account> AccountRoot = AccountCriteria.from(Account.class);
        AccountCriteria.select(AccountRoot);
        Query<Account> AccountQuery = session.createQuery(AccountCriteria);
        List<Account> AcountsList = AccountQuery.getResultList();

        Optional<Integer> numberOfCreditCards = AcountsList.stream().map(element -> {
            if(element.getProduct_Type().equals("Credit")) return 1;
            else return 0;
        }).reduce((a,b) -> a+b);

        Optional<Integer> numberOfDebitCards = AcountsList.stream().map(element -> {
            if(element.getProduct_Type().equals("Debit")) return 1;
            else return 0;
        }).reduce((a,b) -> a+b);

        System.out.println("Number of Credit cards: "+numberOfCreditCards.get());
        System.out.println("Number of Debit cards: "+numberOfDebitCards.get());

        session.getTransaction().commit();
        session.close();
    }
}
