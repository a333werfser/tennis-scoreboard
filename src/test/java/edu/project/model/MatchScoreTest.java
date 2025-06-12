package edu.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchScoreTest {

    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;

    @Test
    void gameShouldNotIncrementWhenNoAdvantage() {
        MatchScore matchScore = new MatchScore();
        int[] scoreState = { 3, 3 };

        matchScore.setPoints(scoreState);
        matchScore.increasePlayerScore(PLAYER_1);

        assertEquals("0", matchScore.getPlayerGames(PLAYER_1));
    }

    @Test
    void gamesShouldIncrementWhenPlayerHasAdvantage() {
        MatchScore matchScore = new MatchScore();
        int[] scoreState = { 3, 0 };

        matchScore.setPoints(scoreState);
        matchScore.increasePlayerScore(PLAYER_1);

        assertEquals("1", matchScore.getPlayerGames(PLAYER_1));
    }

    @Test
    void tieBreakStartsWhenBothPlayersReach6Games() {
        MatchScore matchScore = new MatchScore();
        int[] scoreState = { 6, 6 };

        matchScore.setGames(scoreState);
        matchScore.increasePlayerScore(PLAYER_1);
        matchScore.increasePlayerScore(PLAYER_2);

        assertAll(
                () -> assertTrue(matchScore.isTieBreak()),
                () -> assertEquals("1", matchScore.getPlayerTieBreakPoints(PLAYER_1)),
                () -> assertEquals("1", matchScore.getPlayerTieBreakPoints(PLAYER_2))
        );
    }

    @Test
    void playerShouldGainAdvantage_ifWinsPointAfterDeuce() {
        MatchScore matchScore = new MatchScore();
                //deliberately put something unusual
        int[] scoreState = { 105, 105 };
        matchScore.setPoints(scoreState);

        matchScore.increasePlayerScore(PLAYER_1);
        assertEquals("AD", matchScore.getPlayerPoints(PLAYER_1));
    }

}
