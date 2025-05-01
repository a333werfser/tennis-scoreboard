package edu.project.dao;

import edu.project.model.Player;
import edu.project.util.HibernateUtil;
import org.hibernate.Session;

public class PlayerDao {

    public Player getByName(String playerName) {
        Player player;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            player = session.createSelectionQuery("from Player where name = ?1", Player.class).setParameter(1, playerName).getSingleResultOrNull();
        }
        return player;
    }

}
