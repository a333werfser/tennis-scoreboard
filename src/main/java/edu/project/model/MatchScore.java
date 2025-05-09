package edu.project.model;

public class MatchScore {

    private final int[] tieBreakPoints = new int[2];

    private final int[] points = new int[2];

    private final int[] games = new int[2];

    private final int[] sets = new int[2];

    private int winner;

    public MatchScore() {
        resetPoints();
        resetGames();
        resetTieBreakPoints();
    }

    public void increasePlayerScore(int playerIndex) {
        if (isTieBreak()) {
            handleTieBreak(playerIndex);
        } else {
            handleRegularScore(playerIndex);
        }

        if (isPlayerGamesAboveFive(playerIndex) && hasTwoGamesGap()) {
            sets[playerIndex] += 1;
            resetGames();
        }

        if (isPlayerWinTwoSets(playerIndex)) {
            winner = playerIndex;
        }
    }

    private void resetTieBreakPoints() {
        tieBreakPoints[0] = 0;
        tieBreakPoints[1] = 0;
    }

    private void resetPoints() {
        points[0] = 0;
        points[1] = 0;
    }

    private void resetGames() {
        games[0] = 0;
        games[1] = 0;
    }

    private void handleTieBreak(int playerIndex) {
        tieBreakPoints[playerIndex] += 1;

        if (isPlayerTieBreakPointsAboveSix(playerIndex) && hasTwoTieBreakPointGap()) {
            sets[playerIndex] += 1;
            resetGames();
            resetTieBreakPoints();
        }
    }

    private void handleRegularScore(int playerIndex) {
        points[playerIndex] += 1;

        if (isPlayerPointsAboveThirty(playerIndex) && hasTwoPointGap()) {
            games[playerIndex] += 1;
            resetPoints();
        }
    }

    private boolean isPlayerTieBreakPointsAboveSix(int playerIndex) {
        return tieBreakPoints[playerIndex] > 6;
    }

    private boolean isPlayerPointsAboveThirty(int playerIndex) {
        return points[playerIndex] > 3;
    }

    private boolean isPlayerGamesAboveFive(int playerIndex) {
        return games[playerIndex] > 5;
    }

    private boolean isPlayerWinTwoSets(int playerIndex) {
        return sets[playerIndex] == 2;
    }

    private boolean hasTwoTieBreakPointGap() {
        return Math.abs(tieBreakPoints[0] - tieBreakPoints[1]) >= 2;
    }

    private boolean hasTwoPointGap() {
        return Math.abs(points[0] - points[1]) >= 2;
    }

    private boolean hasTwoGamesGap() {
        return Math.abs(games[0] - games[1]) >= 2;
    }

    private boolean isTieBreak() {
        return games[0] == 6 && games[1] == 6;
    }
}
