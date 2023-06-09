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
				this.tabla[A][B] = "-1";				
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
				if (B == 0)
				{
					if (this.tabla[A][B] == "-1") System.out.print(this.tabla[A][B]);
					else System.out.print(" " + this.tabla[A][B]);
				} else {
							if (this.tabla[A][B] == "-1") System.out.print(" " + this.tabla[A][B]);
							else System.out.print("  " + this.tabla[A][B]);
				}
			}
			System.out.println();
			if (A == 0) System.out.println("|\\  | /|");
			if (A == 1) System.out.println("|/  | \\|");
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
			case 3: resultado = tabla[2][2];
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
		
		// Funci�n que verifica si se termina el juego (devuelve GANO) o hay que continuar la partida (JUGAR)
		// No indica qui�n gano sino que determina que alguien tiene un 3 en raya.
		String mostrarSiGano() {
			String resultado = "JUGAR";
				
					
			if ((mostrarCasilla(7)== mostrarCasilla(4)) && (mostrarCasilla(4)== mostrarCasilla(1)) && (mostrarCasilla(7) != "-1") && (mostrarCasilla(4) != "-1") && (mostrarCasilla(1) != "-1"))  resultado = "GANO";
			if ((mostrarCasilla(8)== mostrarCasilla(5)) && (mostrarCasilla(5)== mostrarCasilla(2)) && (mostrarCasilla(8) != "-1") && (mostrarCasilla(5) != "-1") && (mostrarCasilla(2) != "-1")) resultado = "GANO";
			if ((mostrarCasilla(9)== mostrarCasilla(6)) && (mostrarCasilla(6)== mostrarCasilla(3)) && (mostrarCasilla(9) != "-1") && (mostrarCasilla(6) != "-1") && (mostrarCasilla(3) != "-1")) resultado = "GANO";
					
			if ((mostrarCasilla(7)== mostrarCasilla(8)) && (mostrarCasilla(8)== mostrarCasilla(9)) && (mostrarCasilla(7) != "-1") && (mostrarCasilla(8) != "-1") && (mostrarCasilla(9) != "-1")) resultado = "GANO";
			if ((mostrarCasilla(4)== mostrarCasilla(5)) && (mostrarCasilla(5)== mostrarCasilla(6)) && (mostrarCasilla(4) != "-1") && (mostrarCasilla(5) != "-1") && (mostrarCasilla(6) != "-1")) resultado = "GANO";
			if ((mostrarCasilla(1)== mostrarCasilla(2)) && (mostrarCasilla(2)== mostrarCasilla(3)) && (mostrarCasilla(1) != "-1") && (mostrarCasilla(2) != "-1") && (mostrarCasilla(3) != "-1")) resultado = "GANO";
					
			if ((mostrarCasilla(7)== mostrarCasilla(5)) && (mostrarCasilla(5)== mostrarCasilla(3)) && (mostrarCasilla(7) != "-1") && (mostrarCasilla(5) != "-1") && (mostrarCasilla(3) != "-1")) resultado = "GANO";
			if ((mostrarCasilla(9)== mostrarCasilla(5)) && (mostrarCasilla(5)== mostrarCasilla(1)) && (mostrarCasilla(9) != "-1") && (mostrarCasilla(5) != "-1") && (mostrarCasilla(1) != "-1")) resultado = "GANO";
			
			
			return resultado;
		}
}
