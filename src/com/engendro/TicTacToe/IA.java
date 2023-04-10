package com.engendro.TicTacToe;

public class IA {
	//  DEFINICION DE ELEMENTOS DE LA CLASE IA.
	private String[][] arbol = new String[5][5];
	private int fila ;    		// ladoA
	private int columna;  		// ladoB
	private String player;		// Humano
	private String opponent;	//Ordenador
	
	//  CONSTRUCTOR DE LA CLASE IA.
	public IA() { }
	
	public IA(Tablero gamer, int fila, int columna, Jugador humano, Jugador ordenador) {
		this.fila = fila;
		this.columna = columna;
		this.arbol = gamer.getTabla();
		this.player = humano.getNombre();
		this.opponent = ordenador.getNombre();
		
	}

	// GETTERS & SETTERS
	public String[][] getArbol() {
		return arbol;
	}

	public void setArbol(String[][] arbol) {
		this.arbol = arbol;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
//  METODOS, PROCEDIMIENTOS  Y FUNCIONES.
	
	public int evaluate(int profundidad) {
		
		// Verificar las filas.
		for (int row = 0; row < fila; row++) 
		{ 
			if (arbol[row][0] == arbol[row][1] && arbol[row][1] == arbol[row][2])
			{
				if (arbol[row][0] == player) return +10;
				else if (arbol[row][0] == opponent) return -10;
			}
		}
		
		// Verificar las columnas.
		for (int col = 0; col < columna; col++)
		{
			if (arbol[0][col] == arbol[1][col] && arbol[1][col] == arbol[2][col])
			{
				if (arbol[0][col] == player) return +10;
				else if (arbol[0][col] == opponent) return -10;
			}
		}
		
		// Verificar las diagonales.
		if (arbol[0][0] == arbol[1][1] && arbol[1][1] == arbol[2][2])
		{
			if (arbol[0][0] == player) return +10;
			else if (arbol[0][0] == opponent) return -10;
		}
		
		if (arbol[0][2] == arbol[1][1] && arbol[1][1] == arbol[2][0])
		{
			if (arbol[0][2] == player) return +10;
			else if (arbol[0][2] == opponent) return -10;
		}
		
		// Si no hay nada más se devuelve 0.
		return 0;
	}
	
}
