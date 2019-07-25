
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
            <h1 class="display-4 text-center">AhorcadoGame</h1>
            <hr class="my-4">
            <p class="lead">Usted esta jugando como <b><%= actualPlayer.getNamePlayer() %></b></p>
            <div class="row justify-content-center">
                <form action="JuegoServlet" method="POST">
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col">
                                <label class="mr-3">Vidas</label>
                                <% if(actualGame == null){ %>
                               	<label>*</label>
                                <% } else {  %>
                                <label><%= actualGame.getLifes() %></label>
                                <% } %>
                            </div>
                            <div class="col">
                                <label class="mr-3">Palabra</label>
                                <% if(actualGame == null){ %>
                               	<label>*</label>
                                <% } else {  %>
                                <label><i><%= actualGame.getWordToGuess() %></i></label>
                                <% } %>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col">
                                <label for="letterInput">Ingrese letra</label>
                            </div>
                            <div class="col">
                                <input type="text" class="form-control form-control-sm" id="letterInput" name="letterInput">
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-sm btn-success" name="btnGuess">
                                    OK
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
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