package edu.project.service;

import edu.project.model.Match;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PaginationService {

    private final List<List<Match>> matchesForPages = new ArrayList<>();

    @Getter
    private final int pagesNumber;

    public PaginationService(List<Match> matches) {
        splitMatches(matches);
        pagesNumber = calculatePages(matches.size());
    }

    public List<Match> getMatchesByPage(int page) {
        return matchesForPages.get(page - 1);
    }

    public int calculatePages(int matchesNumber) {
        return matchesNumber == 0 ? 1 : (matchesNumber + 4) / 5;
    }

    public void splitMatches(List<Match> matches) {
        List<Match> temp = new ArrayList<>();
        int i = 0;

        for (Match match : matches) {
            if (i == 5) {
                matchesForPages.add(temp);
                temp = new ArrayList<>();
                i = 0;
            }
            temp.add(match);
            i++;
        }

        if (!temp.isEmpty()) {
            matchesForPages.add(temp);
        }
    }

}
