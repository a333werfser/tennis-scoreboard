package edu.project.servlet;

import edu.project.dao.MatchDao;
import edu.project.model.Match;
import edu.project.service.PaginationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesServlet extends HttpServlet {

    private final MatchDao matchDao = new MatchDao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String playerName = request.getParameter("filter_by_player_name");
        int page = parsePage(request);

        List<Match> matches;

        if (playerName != null) {
            matches = matchDao.getAllMatchesByPlayerName(playerName);
        } else {
            matches = matchDao.getAllMatches();
        }

        if (matches.isEmpty()) {
            response.sendRedirect("matches-not-found.html");
            return;
        }

        PaginationService paginationService = new PaginationService(matches);
        int pagesNumber = paginationService.getPagesNumber();
        List<Match> pageMatches = paginationService.getMatchesByPage(page);

        request.setAttribute("pageMatches", pageMatches);
        request.setAttribute("pagesNumber", pagesNumber);
        request.getRequestDispatcher("matches.jsp").forward(request, response);
    }

    private int parsePage(HttpServletRequest request) {
        String page = request.getParameter("page");
        return page == null ? 1 : Integer.parseInt(page);
    }

}
