package com.engendro.TicTacToe;

public class Tablero {
	//  DEFINICION DE ELEMENTOS DE LA CLASE TABLERO.
	private String[][] tabla = new String[5][5];
	private int ladoA;
	private int ladoB;
	
	//  CONSTRUCTOR DE LA CLASE TABLERO.
	public Tablero() { }
	
	public Tablero(int ladoA, int ladoB) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		
		for (int A = 0; A < ladoA; A++)
		{
			for (int B = 0; B < ladoB; B++)
			{
				if ((A == 0) && (B == 0)) this.tabla[A][B] = "7";
				if ((A == 0) && (B == 1)) this.tabla[A][B] = "8";
				if ((A == 0) && (B == 2)) this.tabla[A][B] = "9";
				
				if ((A == 1) && (B == 0)) this.tabla[A][B] = "4";
				if ((A == 1) && (B == 1)) this.tabla[A][B] = "5";
				if ((A == 1) && (B == 2)) this.tabla[A][B] = "6";
				
				if ((A == 2) && (B == 0)) this.tabla[A][B] = "1";
				if ((A == 2) && (B == 1)) this.tabla[A][B] = "2";
				if ((A == 2) && (B == 2)) this.tabla[A][B] = "3";
				
			}
		}
	}

	// GETTERS & SETTERS
	public String[][] getTabla() {
		return tabla;
	}

	public void setTabla(String[][] tabla) {
		this.tabla = tabla;
	}

	public int getLadoA() {
		return ladoA;
	}

	public void setLadoA(int ladoA) {
		this.ladoA = ladoA;
	}

	public int getLadoB() {
		return ladoB;
	}

	public void setLadoB(int ladoB) {
		this.ladoB = ladoB;
	}
	
	//  METODOS, PROCEDIMIENTOS  Y FUNCIONES.
	
	//  Mostramos todo el contenido del tablero.
	void mostrarTablero() {
		System.out.println();
		for(int A = 0; A < this.ladoA; A++) {
			for(int B = 0; B < this.ladoB; B++) {
				if (B < this.ladoB - 1)
				{
					System.out.print(this.tabla[A][B] + "-");
				} else {
					System.out.println(this.tabla[A][B]);
				}
			}
			if (A == 0) System.out.println("|\\|/|");
			if (A == 1) System.out.println("|/|\\|");
		}
		System.out.println();
	}
	
		
	// Devolver el contenido de una casilla del tablero.
		String mostrarCasilla(int posicion) {
			String resultado = "";
			switch(posicion) {
			case 1: resultado = tabla[2][0];
					break;
			case 2: resultado = tabla[2][1];
					break;
			case 3: resultado = tabla[2][1];
					break;
			case 4: resultado = tabla[1][0];
					break;
			case 5: resultado = tabla[1][1];
					break;
			case 6: resultado = tabla[1][2];
					break;
			case 7: resultado = tabla[0][0];
					break;
			case 8: resultado = tabla[0][1];
					break;
			case 9: resultado = tabla[0][2];
					break;
			default: resultado = "ERROR";
					break;
			}
			return resultado;
		}
		
	// Escribimos una ficha en una casilla concreta del tablero y devuelve OK / ERROR.
		String escribirCasilla(int posicion, Jugador gamer) {
			String resultado = "";
			switch(posicion) {
			case 1: tabla[2][0] = gamer.getNombre();
					resultado = "OK";
					break;
			case 2: tabla[2][1] = gamer.getNombre();
					resultado = "OK";
					break;
			case 3: tabla[2][2] = gamer.getNombre();
					resultado = "OK";
					break;
			case 4: tabla[1][0] = gamer.getNombre();
					resultado = "OK";
					break;
			case 5: tabla[1][1] = gamer.getNombre();
					resultado = "OK";
					break;
			case 6: tabla[1][2] = gamer.getNombre();
					resultado = "OK";
					break;
			case 7: tabla[0][0] = gamer.getNombre();
					resultado = "OK";
					break;
			case 8: tabla[0][1] = gamer.getNombre();
					resultado = "OK";
					break;
			case 9: tabla[0][2] = gamer.getNombre();
					resultado = "OK";
					break;
			default: resultado = "ERROR";
					 break;
			}
			return resultado;
		}
}
