package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.*;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		
		// Manejo de pagina principal
		if(request.getParameter("startGame") != null) {
			Jugador newPlayer = new Jugador();
			String playerName = request.getParameter("inputPlayerName");
			
			// Asigno Nombre
			if(playerName.isEmpty())
				newPlayer.setNamePlayer("-");
			else 
				newPlayer.setNamePlayer(playerName);
			
			// Asigno nueva partida al array de partidas
			Partida newGame = new Partida();
			newPlayer.getPlayerGames().add(newGame);
			
			// Creo sesion para mantener jugador
			HttpSession session = request.getSession(true);
			session.setAttribute("player", newPlayer);
			request.getRequestDispatcher("juego.jsp").forward(request, response);
		}		
	}

}
