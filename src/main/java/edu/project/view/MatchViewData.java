package edu.project.view;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class MatchViewData {
    private String firstPlayerName;

    private String firstPlayerSets;

    private String firstPlayerGames;

    private String firstPlayerPoints;


    private String secondPlayerName;

    private String secondPlayerSets;

    private String secondPlayerGames;

    private String secondPlayerPoints;

    public MatchViewData() {
        firstPlayerSets = "-";
        firstPlayerGames = "-";
        firstPlayerPoints = "-";

        secondPlayerSets = "-";
        secondPlayerGames = "-";
        secondPlayerPoints = "-";
    }

}
