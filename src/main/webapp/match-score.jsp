<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>match-score</title>
</head>
<body>
    <h2>Current match</h2>

    <nav>
        <p>
            <a href="/tennis-scoreboard/new-match">Home</a>,
            <a href="/tennis-scoreboard/matches">Matches</a>
        </p>
    </nav>

    <table>
      <tr>
        <td>Player</td>
        <td>Sets</td>
        <td>Games</td>
        <td>Points</td>
      </tr>
      <tr>
        <td>${matchViewData.firstPlayerName}</td>
        <td>${matchViewData.firstPlayerSets}</td>
        <td>${matchViewData.firstPlayerGames}</td>
        <td>${matchViewData.firstPlayerPoints}</td>
        <td>
          <form action="/tennis-scoreboard/match-score?uuid=${uuid}" method="post">
            <input type="hidden" name="player_id" value="1">
            <button>+point</button>
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
            <button>+point</button>
          </form>
        </td>
      </tr>
    </table>

</body>
</html>