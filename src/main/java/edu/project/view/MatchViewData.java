package edu.project.view;

import edu.project.model.MatchScore;
import edu.project.model.OngoingMatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchViewData {
    private String firstPlayerName;

    private String firstPlayerSets;

    private String firstPlayerGames;

    private String firstPlayerPoints;


    private String secondPlayerName;

    private String secondPlayerSets;

    private String secondPlayerGames;

    private String secondPlayerPoints;

    public MatchViewData(OngoingMatch ongoingMatch) {
        MatchScore matchScore = ongoingMatch.getMatchScore();

        int firstPlayerIndex = matchScore.getFirstPlayerIndex();
        int secondPlayerIndex = matchScore.getSecondPlayerIndex();

        if (matchScore.isTieBreak()) {
            setFirstPlayerPoints(matchScore.getPlayerTieBreakPoints(firstPlayerIndex));
            setSecondPlayerPoints(matchScore.getPlayerTieBreakPoints(secondPlayerIndex));
        } else {
            setFirstPlayerPoints(matchScore.getPlayerPoints(firstPlayerIndex));
            setSecondPlayerPoints(matchScore.getPlayerPoints(secondPlayerIndex));
        }
        setFirstPlayerName(ongoingMatch.getPlayer1().getName());
        setSecondPlayerName(ongoingMatch.getPlayer2().getName());
        setFirstPlayerSets(matchScore.getPlayerSets(firstPlayerIndex));
        setSecondPlayerSets(matchScore.getPlayerSets(secondPlayerIndex));
        setFirstPlayerGames(matchScore.getPlayerGames(firstPlayerIndex));
        setSecondPlayerGames(matchScore.getPlayerGames(secondPlayerIndex));
    }
}
