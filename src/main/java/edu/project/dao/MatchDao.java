package edu.project.dao;

import edu.project.model.Match;
import edu.project.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class MatchDao {

    public void saveMatch(Match match) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(match);
        });
    }
}
