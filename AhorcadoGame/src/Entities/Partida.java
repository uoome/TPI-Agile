package Entities;

public class Partida {
	
	// Variables
	private int score, guessedLetters, unguessedLetters, lifes;
	private String wordToGuess;
	private String[] alphabet = {"perro","arbol","manzana","kanvan","adrenalina","objeto"};
	private long startTime, endTime, gameDuration;
	
	// Getters and Setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(int guessedLetters) {
		this.guessedLetters = guessedLetters;
	}

	public int getUnguessedLetters() {
		return unguessedLetters;
	}

	public void setUnguessedLetters(int unguessedLetters) {
		this.unguessedLetters = unguessedLetters;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
	}

	public String[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String[] alphabet) {
		this.alphabet = alphabet;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(long gameDuration) {
		this.gameDuration = gameDuration;
	}

	// Constructor
	public Partida() {
		this.setLifes(5);
		this.setWordToGuess(this.generateWord());
		this.setGuessedLetters(0);
		this.setUnguessedLetters(0);
		this.setScore(0);
		this.setStartTime(System.currentTimeMillis());
	}
	
	// Methods
	public String generateWord() {
		int index = (int) (Math.random() * this.getAlphabet().length);
		return alphabet[index];
	}
	
	public void calculateScore() {
		this.setScore(this.getGuessedLetters() * 2 - this.getUnguessedLetters()); 
		System.out.println("Su score es: "  + this.getScore());	
	}

	public void calculateGameTime() {
		this.setGameDuration(this.getEndTime() - this.getStartTime());    
		System.out.println("Duracion (en milisegundos): " + this.getGameDuration());
	}
	
	public int contarCaracteresRepetidos(String caracter) {
        int posicion, contador = 0;
        // Busco la primera vez que aparece
        posicion = this.getWordToGuess().indexOf(caracter);
        System.out.println("La letra se encuentra en la posicion: " + posicion);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++; //se cuenta la repeticion
            //busco a partir de la posición siguiente a la encontrada
            posicion = this.getWordToGuess().indexOf(caracter, posicion + 1);
            if(posicion != -1)
            	System.out.println("La letra se encuentra en la posicion: " + posicion);
        }
        return contador;
	}
	
	// Verificar si va aca, quizas deba ir en el servlet
	public void guess(String letra) {
		if(letra.isEmpty()) {
			System.out.println("Ingrese alguna letra");
			this.setLifes(this.getLifes()-1);
			System.out.println("Vidas restantes: " + this.getLifes());
		} else if(this.getWordToGuess().contains(letra)) {
			System.out.println("El caracter '" + letra + "' es correcto");
			this.setGuessedLetters(this.getGuessedLetters() + this.contarCaracteresRepetidos(letra));			
		} else {
			System.out.println("El caracter '" + letra + "' es erroneo");
			this.setUnguessedLetters(this.getUnguessedLetters() + 1);
			this.setLifes(this.getLifes()-1);
			System.out.println("Vidas restantes: " + this.getLifes());
		}	
	}

	
	
	
	
	
	

}
