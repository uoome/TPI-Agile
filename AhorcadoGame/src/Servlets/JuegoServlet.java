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
				// Preguntar si adivino todas las letras
				if(actualGame.getGuessedLetters() == actualGame.getWordToGuess().length()) {					
					// Calcular score y tiempo
					actualGame.calculateScore();
					actualGame.calculateGameTime();
					// Preparar mensaje
					String msj = "Felicitaciones, ha adivinado la palabra " + actualGame.getWordToGuess() + "!";
					// Redireccionar
					request.setAttribute("msj", msj);
					request.getRequestDispatcher("record.jsp").forward(request, response);

				} else if(actualGame.getLifes() == 0) {
					// Preparar mensaje
					String msj = "Ha perdido! La palabra era: " + actualGame.getWordToGuess();
					// Redireccionar
					request.setAttribute("msj", msj);
					request.getRequestDispatcher("record.jsp").forward(request, response);
				} else {
					// Seguir jugando 
					request.getRequestDispatcher("juego.jsp").forward(request, response);
				}				
			}
			
		}
		
		if(request.getParameter("btnNewGame") != null) {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
