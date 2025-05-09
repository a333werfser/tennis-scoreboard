package edu.project.service;

import edu.project.model.OngoingMatch;
import edu.project.model.Player;

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

    public OngoingMatch getMatch(String uuid) {
        return ongoingMatches.get(uuid);
    }
}
