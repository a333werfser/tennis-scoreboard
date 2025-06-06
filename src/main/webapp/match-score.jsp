<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Match</title>

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/match-score.css">
</head>
<body>
    <nav>
        <p>Tennis-Scoreboard</p>
        <p>
            <a href="index.html">Home</a>
            <a href="/tennis-scoreboard/matches">Matches</a>
        </p>
    </nav>

    <h1>Current match</h1>
    <div class="table-wrapper">
        <table>
            <thead>
                <tr>
                    <td>Player</td>
                    <td>Sets</td>
                    <td>Games</td>
                    <td>Points</td>
                    <td></td>
                </tr>
            </thead>
            <tr>
                <td>${matchViewData.firstPlayerName}</td>
                <td>${matchViewData.firstPlayerSets}</td>
                <td>${matchViewData.firstPlayerGames}</td>
                <td>${matchViewData.firstPlayerPoints}</td>
                <td>
                    <form action="/tennis-scoreboard/match-score?uuid=${uuid}" method="post">
                        <input type="hidden" name="player_id" value="1">
                        <button>Score</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>${matchViewData.secondPlayerName}</td>
                <td>${matchViewData.secondPlayerSets}</td>
                <td>${matchViewData.secondPlayerGames}</td>
                <td>${matchViewData.secondPlayerPoints}</td>
                <td>
                    <form action="/tennis-scoreboard/match-score?uuid=${uuid}" method="post">
                        <input type="hidden" name="player_id" value="2">
                        <button>Score</button>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>