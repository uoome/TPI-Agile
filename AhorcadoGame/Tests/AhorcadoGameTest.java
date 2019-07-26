import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entities.*;

class AhorcadoGameTest {
	
	private Partida partidaActual;
	private String palabra;
	
	public void correrLetras(Partida p, String[] cadena) {
		for (String letra : cadena) {
			p.guess(letra);
		}	
	}

	@BeforeEach
	protected void setUp() {
		partidaActual = new Partida();
		palabra = "perro";
		partidaActual.setWordToGuess(palabra);
	}
	
	@Test	
	void palabra_perro_ingreso_caracter_vacio_quita_una_vida() {
		// Act
		partidaActual.guess("");
		
		// Assert 
		assertEquals(4,partidaActual.getLifes());
	}
	
	@Test
	void palabra_perro_ingreso_letra_a_quita_una_vida() {
		// Act
		partidaActual.guess("a");
		
		// Assert 
		assertEquals(4, partidaActual.getLifes());
	}
	
	@Test
	void palabra_perro_ingreso_letra_p_no_quita_vida() {
		// Act
		partidaActual.guess("p");
		
		// Assert 
		assertEquals(5, partidaActual.getLifes());
	}
	
	
	@Test
	void palabra_perro_perder_juego_errando_todas_las_letras() {		
		// Arrange
		String cadena[] = {"a","b","c","d","x"};
		
		// Act
		this.correrLetras(partidaActual, cadena);
	
		// Assert 
		assertEquals(0, partidaActual.getLifes());
	}
	
	
	@Test
	void palabra_perro_ganar_al_adivinar_todas_las_letras() {
		// Arrange
		String cadena[] = {"p","e","r","o"};
		
		// Act
		this.correrLetras(partidaActual, cadena);		
		
		// Assert 
		assertEquals(palabra.length(), partidaActual.getGuessedLetters());
	}
	
	@Test
	void ingresar_nombre_jugador_vacio_devuelve_falso() {		
		// Arrange 
		Jugador player = new Jugador();
		boolean rta;
		
		// Act
		player.setNamePlayer("");
		if(player.getNamePlayer().isEmpty())
			rta = false;
		else rta = true;
		
		// Assert
		assertEquals(false, rta);
	}
	
	@Test
	void ingresar_nombre_jugador_devuelve_true() {		
		// Arrange 
		Jugador player = new Jugador();
		boolean rta;

		// Act
		player.setNamePlayer("Nico");
		if(player.getNamePlayer().isEmpty())
			rta = false;
		else rta = true;
			
		// Assert
		assertEquals(true, rta);
		
	}
	
	@Test
	void ingresar_nombre_jugador_Nico_devuelve_Nico() {		
		// Arrange 
		Jugador player = new Jugador();

		// Act
		player.setNamePlayer("Nico");
			
		// Assert
		assertEquals("Nico", player.getNamePlayer());
	}
	
	@Test
	void generar_palabra_harcodeada_se_encuentra_en_alfabeto() {
		// Arrange
		String palabraHarco;
		boolean rta = false;
		
		// Act
		palabraHarco = partidaActual.generateWord();		
		for(String a : partidaActual.getAlphabet()) {
			if(palabraHarco.equals(a))
				rta = true;
		}
		
		// Assert
		assertEquals(true, rta);
	}
	
	@Test
	void palabra_perro_ganar_de_primera_devuelve_score_10() {
		// Arrange
		String cadena[] = {"p","e","r","o"};
				
		// Act
		this.correrLetras(partidaActual,cadena);				
		partidaActual.calculateScore();
				
		// Assert 
		assertEquals(10, partidaActual.getScore());	
	}
	
	@Test
	void palabra_perro_ganar_errando_3_letras_devuelve_score_7() {
		// Arrange
		String cadena[] = {"p","a","j","e","k","r","o"};
				
		// Act
		this.correrLetras(partidaActual, cadena);	
		partidaActual.calculateScore();
				
		// Assert 
		assertEquals(7, partidaActual.getScore());		
	}
	
	@Test
	void mostrar_tiempo_de_juego_devuelve_tiempo_transcurrido () {
		// Arrange
		long tiempoInicio = System.currentTimeMillis();
		partidaActual.setStartTime(tiempoInicio);
		String cadena[] = {"p","a","j","e","k","r","o"};
						
		// Act
		this.correrLetras(partidaActual, cadena);	
		long tiempoFin = System.currentTimeMillis();
		partidaActual.setEndTime(tiempoFin);
		partidaActual.calculateGameTime();
						
		// Assert 
		assertEquals(tiempoFin - tiempoInicio, partidaActual.getGameDuration());	
	}
	
	@Test
	void palabra_perro_adivinar_letra_e_muestra_palabra_con_letra_e(){
		// Arrange
		partidaActual.setWordToDisplay("*****");
		
		// Act
		partidaActual.formWord("e", 1);
		
		// Assert
		assertEquals("*e***", partidaActual.getWordToDisplay());
	}
	
	@Test
	void palabra_perro_adivinar_letras_e_y_r_muestra_palabra_con_letras(){
		// Arrange
		partidaActual.setWordToDisplay("*****");
		
		// Act
		partidaActual.formWord("e", 1);
		partidaActual.formWord("r",2);
		partidaActual.formWord("r",3);
		
		// Assert
		assertEquals("*err*", partidaActual.getWordToDisplay());
	}

}
