package edu.project.view;

import edu.project.model.MatchScore;
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
        reset();
    }

    public void update(MatchScore matchScore) {
        int firstPlayerIndex = matchScore.getFirstPlayerIndex();
        int secondPlayerIndex = matchScore.getSecondPlayerIndex();

        if (matchScore.isTieBreak()) {
            setFirstPlayerPoints(matchScore.getPlayerTieBreakPoints(firstPlayerIndex));
            setSecondPlayerPoints(matchScore.getPlayerTieBreakPoints(secondPlayerIndex));
        } else {
            setFirstPlayerPoints(matchScore.getPlayerPoints(firstPlayerIndex));
            setSecondPlayerPoints(matchScore.getPlayerPoints(secondPlayerIndex));
        }
        setFirstPlayerSets(matchScore.getPlayerSets(firstPlayerIndex));
        setSecondPlayerSets(matchScore.getPlayerSets(secondPlayerIndex));
        setFirstPlayerGames(matchScore.getPlayerGames(firstPlayerIndex));
        setSecondPlayerGames(matchScore.getPlayerGames(secondPlayerIndex));
    }

    public void reset() {
        firstPlayerSets = "-";
        firstPlayerGames = "-";
        firstPlayerPoints = "-";

        secondPlayerSets = "-";
        secondPlayerGames = "-";
        secondPlayerPoints = "-";
    }
}
