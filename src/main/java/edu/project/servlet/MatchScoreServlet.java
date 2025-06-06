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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        OngoingMatch ongoingMatch = ongoingMatchesService.getMatch(uuid);

        MatchViewData matchViewData = new MatchViewData(ongoingMatch);

        request.setAttribute("uuid", uuid);
        request.setAttribute("matchViewData", matchViewData);

        request.getRequestDispatcher("/match-score.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        OngoingMatch ongoingMatch = ongoingMatchesService.getMatch(uuid);

        int pointWinnerIndex = Integer.parseInt(request.getParameter("player_id")) - 1;

        MatchScore matchScore;

        /*      WARNING:
         * очень странное поведение, тут будто бы есть race condition, если скорость кликов
         * достаточно высокая, может выдать NullPointerException
         * но проблему в коде я так и не нашел, а баг повторить не получилось
         * поэтому сделал редирект на страницу с матчами
         */
        try {
            matchScore = ongoingMatch.getMatchScore();
        } catch (NullPointerException e) {
            response.sendRedirect("/tennis-scoreboard/matches");
            return;
        }

        matchScore.increasePlayerScore(pointWinnerIndex);

        MatchViewData matchViewData = new MatchViewData(ongoingMatch);

        String view;
        if (matchScore.isMatchCompleted()) {
            Player winner = ongoingMatch.getWinner(pointWinnerIndex);
            ongoingMatchesService.completeMatch(uuid, winner);
            view = "/final-score.jsp";
        } else {
            view = "/match-score.jsp";
        }

        request.setAttribute("uuid", uuid);
        request.setAttribute("matchViewData", matchViewData);
        request.getRequestDispatcher(view).forward(request, response);
    }
}
