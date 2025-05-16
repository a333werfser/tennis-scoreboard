package edu.project.servlet;

import edu.project.dao.MatchDao;
import edu.project.dao.PlayerDao;
import edu.project.model.Match;
import edu.project.model.MatchScore;
import edu.project.model.OngoingMatch;
import edu.project.model.Player;
import edu.project.service.OngoingMatchesService;
import edu.project.view.MatchViewData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    private final MatchViewData matchViewData = new MatchViewData();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        OngoingMatch ongoingMatch = ongoingMatchesService.getMatch(uuid);

        matchViewData.setFirstPlayerName(ongoingMatch.getPlayer1().getName());
        matchViewData.setSecondPlayerName(ongoingMatch.getPlayer2().getName());

        request.setAttribute("uuid", uuid);
        request.setAttribute("matchViewData", matchViewData);

        request.getRequestDispatcher("/match-score.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        OngoingMatch ongoingMatch = ongoingMatchesService.getMatch(uuid);

        int pointWinnerIndex = Integer.parseInt(request.getParameter("player_id")) - 1;

        MatchScore matchScore = ongoingMatch.getMatchScore();
        matchScore.increasePlayerScore(pointWinnerIndex);

        matchViewData.update(matchScore);

        request.setAttribute("uuid", uuid);
        request.setAttribute("matchViewData", matchViewData);

        if (matchScore.isMatchCompleted()) {
            Player winner = ongoingMatch.getWinner(pointWinnerIndex);
            ongoingMatchesService.completeMatch(uuid, winner);

            request.getRequestDispatcher("/final-score.jsp").forward(request, response);
            matchViewData.reset();
        } else {
            request.getRequestDispatcher("/match-score.jsp").forward(request, response);
        }
    }
}
