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
				this.tabla[A][B] = "O";
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
	
	// Añadir un movimiento de un ficha de un jugador concreto en el tablero.
		void añadirMovimiento(Jugador gamer, int casillaOcupada) {
			switch(casillaOcupada) {
			case 1: tabla[2][0] = gamer.getNombre();
					break;
			case 2: tabla[2][1] = gamer.getNombre();
					break;
			case 3: tabla[2][2] = gamer.getNombre();
					break;
			case 4: tabla[1][0] = gamer.getNombre();
					break;
			case 5: tabla[1][1] = gamer.getNombre();
					break;
			case 6: tabla[1][2] = gamer.getNombre();
					break;
			case 7: tabla[0][0] = gamer.getNombre();
					break;
			case 8: tabla[0][1] = gamer.getNombre();
					break;
			case 9: tabla[0][2] = gamer.getNombre();
					break;
			}
		}
}
