package edu.project.servlet;

import edu.project.dao.PlayerDao;
import edu.project.model.OngoingMatch;
import edu.project.model.Player;
import edu.project.service.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private final PlayerDao playerDao = new PlayerDao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/new-match.html").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String player1Name = request.getParameter("1-player-name");
        String player2Name = request.getParameter("2-player-name");

        player1Name = (player1Name == null) ? "" : player1Name.trim();
        player2Name = (player2Name == null) ? "" : player2Name.trim();

        String errorMessage = null;

        if (player1Name.isEmpty() || player2Name.isEmpty()) {
            errorMessage = "Error: names cannot be empty or just spaces";
        } else if (player1Name.length() > 25 || player2Name.length() > 25) {
            errorMessage = "Error: names length more than 25 symbols";
        } else if (player1Name.equals(player2Name)) {
            errorMessage = "Error: names must be different";
        }

        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/new-match.jsp").forward(request, response);
            return;
        }

        Player player1 = playerDao.getByName(player1Name);
        Player player2 = playerDao.getByName(player2Name);

        if (player1 == null) {
            player1 = new Player().setName(player1Name);
            playerDao.savePlayer(player1);
        }

        if (player2 == null) {
            player2 = new Player().setName(player2Name);
            playerDao.savePlayer(player2);
        }

        String uuid = new OngoingMatchesService().createNewMatch(player1, player2);
        response.sendRedirect("/tennis-scoreboard/match-score?uuid=" + uuid);
    }



}
