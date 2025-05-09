<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>match-score</title>
</head>
<body>
    <h2>Current match</h2>
    <table>
      <tr>
        <td>${player1Name}</td>
        <td>Score</td>
        <td>
          <form action="/tennis-scoreboard/match-score?uuid=${uuid}" method="post">
            <input type="hidden" name="player_id" value="1">
            <button>+point</button>
          </form>
        </td>
      </tr>
      <tr>
        <td>${player2Name}</td>
        <td>Score</td>
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