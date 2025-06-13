package edu.project.dao;

import edu.project.model.Match;
import edu.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MatchDao {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Match> getAllMatchesByPlayerName(String playerName) {
        List<Match> matchesList;

        try (Session session = sessionFactory.openSession()) {
            matchesList = session.createSelectionQuery("from Match m where m.player1.name = :player or m.player2.name = :player", Match.class)
                    .setParameter("player", playerName).getResultList();
        }

        return matchesList;
    }

    public List<Match> getAllMatches() {
        List<Match> matchesList;

        String hql = "SELECT m FROM Match m " +
                "JOIN FETCH m.player1 JOIN FETCH m.player2 JOIN FETCH m.winner";

        try (Session session = sessionFactory.openSession()) {
            matchesList = session.createQuery(hql, Match.class).getResultList();
        }

        return matchesList;
    }

    public void saveMatch(Match match) {
        sessionFactory.inTransaction(session -> {
            session.persist(match);
        });
    }
}
