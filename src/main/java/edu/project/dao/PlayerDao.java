package edu.project.dao;

import edu.project.model.Player;
import edu.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PlayerDao {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Player getByName(String playerName) {
        Player player;
        try (Session session = sessionFactory.openSession()) {
            player = session.createSelectionQuery("from Player where name = ?1", Player.class)
                    .setParameter(1, playerName).getSingleResultOrNull();
        }
        return player;
    }

    public void savePlayer(Player player) {
        sessionFactory.inTransaction(session -> {
            session.persist(player);
        });
    }

}
