package edu.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OngoingMatch {

    private Player player1;

    private Player player2;

    private MatchScore matchScore;

    public OngoingMatch(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        matchScore = new MatchScore();
    }

}
