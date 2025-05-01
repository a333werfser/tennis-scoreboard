package edu.project.servlet;

import edu.project.dao.PlayerDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String player1Name = request.getParameter("1-player-name");
        String player2Name = request.getParameter("2-player-name");

        System.out.println(new PlayerDao().getByName(player1Name));
    }
}
