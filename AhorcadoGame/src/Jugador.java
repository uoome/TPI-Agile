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
	public Jugador(){
        this.setPlayerGames(new ArrayList<Partida>());
    }
	
	// Methods
    
    

}
