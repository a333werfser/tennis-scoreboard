<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>final-score</title>
</head>
<body>
    <h2>Current match</h2>
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
      </tr>
      <tr>
        <td>${matchViewData.secondPlayerName}</td>
        <td>${matchViewData.secondPlayerSets}</td>
        <td>${matchViewData.secondPlayerGames}</td>
        <td>${matchViewData.secondPlayerPoints}</td>
      </tr>
    </table>
</body>
</html>