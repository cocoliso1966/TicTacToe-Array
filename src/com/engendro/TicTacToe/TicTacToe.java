package com.engendro.TicTacToe;

public class TicTacToe {

	public static void main(String[] args) {
		Jugador persona = new Jugador("P", 3);
		Jugador ordenador = new Jugador("M", 3);
		Tablero mesajuego = new Tablero(3, 3);
		
		persona.mostrarFichas();
		ordenador.mostrarFichas();
		mesajuego.mostrarTablero();
		
		ordenador.a�adirMovimiento( 0, 5);
		ordenador.mostrarFichas();
		mesajuego.a�adirMovimiento(ordenador, 5);
		mesajuego.mostrarTablero();
	}

}
