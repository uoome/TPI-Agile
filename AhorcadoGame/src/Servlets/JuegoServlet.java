package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Entities.*;

/**
 * Servlet implementation class JuegoServlet
 */
@WebServlet("/JuegoServlet")
public class JuegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuegoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnGuess") != null) {
			HttpSession session = request.getSession(false);
			if(session != null) {
				// Traigo al jugador
				Jugador player = (Jugador) session.getAttribute("player");
				// Traigo la partida actual
				Partida actualGame = (Partida) player.getPlayerGames().get(player.getPlayerGames().size() - 1);	
				// Adivino letra
				String letter = request.getParameter("letterInput");
				actualGame.guess(letter);
				
				if(actualGame.getGuessedLetters() == actualGame.getWordToGuess().length()) {
					// Cambiar metodos para que devuelvan strings y hacer mensajes
					actualGame.calculateScore();
					actualGame.calculateGameTime();
					
					String msj = "Felicitaciones, ha adivinado la palabra!";
					request.setAttribute("msj", msj);
					request.getRequestDispatcher("juego.jsp");
				} else {
					request.getRequestDispatcher("juego.jsp");
				}				
				
			}
			
		}
	}

}
