package edu.project.servlet;

import edu.project.model.OngoingMatch;
import edu.project.service.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        OngoingMatch ongoingMatch = ongoingMatchesService.getMatch(uuid);

        request.setAttribute("uuid", uuid);
        request.setAttribute("player1Name", ongoingMatch.getPlayer1().getName());
        request.setAttribute("player2Name", ongoingMatch.getPlayer2().getName());

        request.getRequestDispatcher("/match-score.jsp").forward(request, response);
    }

}
