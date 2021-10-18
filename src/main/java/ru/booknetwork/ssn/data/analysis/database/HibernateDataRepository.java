package ru.booknetwork.ssn.data.analysis.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.booknetwork.ssn.data.analysis.Data;
import ru.booknetwork.ssn.data.analysis.controllers.StatisticDTO;

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

    @Override
    public StatisticDTO getStatisticDTO() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            StatisticDTO statisticDTO = new StatisticDTO();

            Long accountsCreated = (Long) session.createSQLQuery
                    ("SELECT COUNT(data_name) FROM Data WHERE data_name='Account' AND action='Created'")
                    .addScalar("count", LongType.INSTANCE)
                    .getSingleResult();
            statisticDTO.setAccountsCreated(accountsCreated.intValue());

            Long postsCreated = (Long) session.createSQLQuery
                    ("SELECT COUNT(data_name) FROM Data WHERE data_name='Post'")
                    .addScalar("count", LongType.INSTANCE)
                    .getSingleResult();
            statisticDTO.setPostsCreated(postsCreated.intValue());

            Long messagesSent = (Long) session.createSQLQuery
                    ("SELECT COUNT(data_name) FROM Data WHERE data_name='Message'")
                    .addScalar("count", LongType.INSTANCE)
                    .getSingleResult();
            statisticDTO.setMessagesSent(messagesSent.intValue());

            Long friendsAdded = (Long) session.createSQLQuery
                    ("SELECT COUNT(data_name) FROM Data WHERE data_name='Account' AND action='FriendAdded'")
                    .addScalar("count", LongType.INSTANCE)
                    .getSingleResult();
            statisticDTO.setFriendsAdded(friendsAdded.intValue());

            return statisticDTO;
        } catch (HibernateException e) {
            throw new Exception("Hibernate get Error.", e);
        }
    }
}
