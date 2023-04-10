package com.engendro.TicTacToe;

public class Main {

	public static void main(String[] args) {
		Jugador persona = new Jugador("P", 3);
		Jugador ordenador = new Jugador("M", 3);
		Tablero mesajuego = new Tablero(3, 3);
		
		mesajuego.mostrarTablero();

	}

}
