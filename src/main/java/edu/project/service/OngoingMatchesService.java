package edu.project.service;

import edu.project.dao.MatchDao;
import edu.project.model.Match;
import edu.project.model.MatchScore;
import edu.project.model.OngoingMatch;
import edu.project.model.Player;
import edu.project.view.MatchViewData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OngoingMatchesService {

    private static final Map<String, OngoingMatch> ongoingMatches = new HashMap<>();

    public String createNewMatch(Player player1, Player player2) {
        String uuid = UUID.randomUUID().toString();
        OngoingMatch newMatch = new OngoingMatch(player1, player2);
        ongoingMatches.put(uuid, newMatch);

        return uuid;
    }

    public void completeMatch(String uuid, Player winner) {
        OngoingMatch ongoingMatch = getMatch(uuid);

        Match match = new Match().setPlayer1(ongoingMatch.getPlayer1())
                .setPlayer2(ongoingMatch.getPlayer2()).setWinner(winner);
        new MatchDao().saveMatch(match);
        removeMatch(uuid);
    }

    public OngoingMatch getMatch(String uuid) {
        return ongoingMatches.get(uuid);
    }

    public void removeMatch(String uuid) {
        ongoingMatches.remove(uuid);
    }
}
