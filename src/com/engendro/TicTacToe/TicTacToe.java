package com.engendro.TicTacToe;

public class TicTacToe {

	public static void main(String[] args) {
		Jugador persona = new Jugador("P", 3);
		Jugador ordenador = new Jugador("M", 3);
		Tablero mesajuego = new Tablero(3, 3);

		
		ordenador.añadirMovimiento( 0, 7);
		ordenador.mostrarFichas();
		mesajuego.escribirCasilla(7, ordenador);
		mesajuego.mostrarTablero(); 
		System.out.println("la ficha o del jugador ordenador esta en: " + ordenador.mostrarPosicionFicha(1));
		System.out.println("La posicion de todas las fichas de ordenador es: " + ordenador.getFicha());
	}

}
