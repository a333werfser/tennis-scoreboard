<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>matches</title>
</head>
<body>

    <form action="/tennis-scoreboard/matches" method="GET">
        <label for="filter">Find matches</label>
        <input type="text" name="filter_by_player_name" id="filter">
        <button>Search</button>
    </form>

    <br>

    <table>
        <tr>
            <td>Player One</td>
            <td>Player Two</td>
            <td>Winner</td>
        </tr>
        <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.player1.name}</td>
                <td>${match.player2.name}</td>
                <td>${match.winner.name}</td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach var="i" begin="1" end="${pagesNumber}">
        <a href="/tennis-scoreboard/matches?page=${i}">${i}</a>
    </c:forEach>

</body>
</html>