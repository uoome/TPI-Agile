package Entities;

import java.util.ArrayList;

public class Jugador {

	// Variables
	private String namePlayer;
	private int id_player;
	private ArrayList<Partida> playerGames;

	// Getters and Setters
	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public int getId_player() {
		return id_player;
	}

	public void setId_player(int id_player) {
		this.id_player = id_player;
	}

	public ArrayList<Partida> getPlayerGames() {
		return playerGames;
	}

	public void setPlayerGames(ArrayList<Partida> playerGames) {
		this.playerGames = playerGames;
	}

	// Constructor
	public Jugador() {
		this.setPlayerGames(new ArrayList<Partida>());
	}

	// Methods
	public void showStorys() {
		System.out.println("Historial de partidas");

		if (this.getNamePlayer().isEmpty())
			System.out.println("Nombre jugador: -");
		else
			System.out.println("Nombre jugador: " + this.getNamePlayer());

		System.out.println("Cantidad de partidas jugadas: " + this.getPlayerGames().size());

		for (Partida p : this.getPlayerGames()) {
			System.out.println("*************");
			System.out.println("Score: " + p.getScore());
			System.out.println("Duracion: " + p.getGameDuration());
		}
	}

}
