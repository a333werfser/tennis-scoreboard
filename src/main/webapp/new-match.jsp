<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html lang="en-US">
<head>
    <meta charset="utf-8">
    <title>New match</title>

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/new-match.css">
</head>
<body>
    <nav>
        <p>Tennis-Scoreboard</p>
        <p>
            <a href="index.html">Home</a>
            <a href="/tennis-scoreboard/matches">Matches</a>
        </p>
    </nav>
    <form action="/tennis-scoreboard/new-match" method="post">
        <h1>Start new match</h1>
        <label for="name1">Player 1 name</label>
        <input type="text" placeholder="Name" name="1-player-name" id="name1" required>
        <label for="name2" >Player 2 name</label>
        <input type="text" placeholder="Name" name="2-player-name" id="name2" required>
        <p>${error}</p>
        <button>Start</button>
    </form>
</body>
</html>