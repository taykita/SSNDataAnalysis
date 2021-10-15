package ru.booknetwork.SSNDataAnalysis.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.booknetwork.SSNDataAnalysis.Data;

@Repository
public class HibernateDataRepository implements DataRepository {
    @Autowired
    public HibernateDataRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private final SessionFactory sessionFactory;

    @Override
    public Data addData(Data data) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                int id = (Integer) session.save(data);
                data.setId(id);

                transaction.commit();
                return data;
            } catch (HibernateException e) {
                transaction.rollback();
                throw e;
            }
        } catch (HibernateException e) {
            throw new Exception("Hibernate add Error.", e);
        }
    }
}
