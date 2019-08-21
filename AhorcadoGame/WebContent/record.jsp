<%@ page import="Entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>AhorcadoGame</title>
</head>

<body>

    <% Jugador actualPlayer = (Jugador) session.getAttribute("player"); %>
    <% Partida actualGame = (Partida) actualPlayer.getPlayerGames().get(actualPlayer.getPlayerGames().size() - 1); %>

    <!-- Content -->
    <div class="container">
        <div class="jumbotron">
            <h3><%= request.getAttribute("msj") %></h3>
            <% if(actualGame.getGameDuration() != 0){ %>
            	<p id="prgfPunctuation">Puntuacion: <%= actualGame.getScore() %></p>
            <% } %>            
            <p class="lead">Gracias <% if(!actualPlayer.getNamePlayer().equals("-")){ %><%= actualPlayer.getNamePlayer() %><% } %> por jugar!</p>
            <form action="JuegoServlet" class="form-inline" method="POST">
                <div class="form-group align-center">
                    <div class="form-row">
                        <div class="col">
                            <button type="submit" class="btn btn-warning" name="btnNewGame">New</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Content -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>