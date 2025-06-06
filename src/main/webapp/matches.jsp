<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matches</title>

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/search-form.css">
    <link rel="stylesheet" href="css/matches.css">
</head>
<body>
    <nav>
        <p>Tennis-Scoreboard</p>
        <p>
            <a href="index.html">Home</a>
            <a href="/tennis-scoreboard/matches">Matches</a>
        </p>
    </nav>

    <div class="flex-container">
        <form action="/tennis-scoreboard/matches" method="GET">
            <label for="filter">Find matches</label>
            <input type="text" placeholder="Player name" name="filter_by_player_name" id="filter">
            
            <button>Search</button>
        </form>

        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <td>Player One</td>
                        <td>Player Two</td>
                        <td>Winner</td>
                    </tr>
                </thead>
                <c:forEach var="match" items="${pageMatches}">
                    <tr>
                        <td>${match.player1.name}</td>
                        <td>${match.player2.name}</td>
                        <td>👑 ${match.winner.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    
        <div class="pagination">
            <c:forEach var="i" begin="1" end="${pagesNumber}">
                <a class="number" href="/tennis-scoreboard/matches?page=${i}">${i}</a>
            </c:forEach>
        </div>
    </div>
</body>
</html>