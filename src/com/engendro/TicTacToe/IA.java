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
	
	// Este constructor completo requiere los siguientes parametros:
	// gamer: El tablero completo del juego total que se copia en arbol.
	// fila, columna: Las dimensiones del tablero del juego.
	// humano, ordenador: Extraemos el elemento nombre de ambos jugadores.
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
	
	// Función para evaluar el resultado de una jugada realizada en arbol.
	// El parámetro barbol[][], es una copia de arbol de un momento del juego que evalua
	// en la función minimax. 
	// Cada invocación recursiva de minimax tendra un arbol distinto.
	// 
	public int evaluate(String barbol[][]) {
		
		// Verificar las filas.
		for (int row = 0; row < fila; row++) 
		{ 
			if (barbol[row][0] == barbol[row][1] && barbol[row][1] == barbol[row][2])
			{
				if (barbol[row][0] == player) return +10;
				else if (barbol[row][0] == opponent) return -10;
			}
		}
		
		// Verificar las columnas.
		for (int col = 0; col < columna; col++)
		{
			if (barbol[0][col] == barbol[1][col] && barbol[1][col] == barbol[2][col])
			{
				if (barbol[0][col] == player) return +10;
				else if (barbol[0][col] == opponent) return -10;
			}
		}
		
		// Verificar las diagonales.
		if (barbol[0][0] == barbol[1][1] && barbol[1][1] == barbol[2][2])
		{
			if (barbol[0][0] == player) return +10;
			else if (barbol[0][0] == opponent) return -10;
		}
		
		if (barbol[0][2] == barbol[1][1] && barbol[1][1] == barbol[2][0])
		{
			if (barbol[0][2] == player) return +10;
			else if (barbol[0][2] == opponent) return -10;
		}
		
		// Si no hay nada más se devuelve 0.
		return 0;
	}

	// Función para elegir casillas libres para seleccionar el siguiente movimiento 
	// de ficha y evaluarlo.
	// Es invocado por minimax que evalua cada movimiento creando una foto distinta
	// de arbol por cada movimiento nuevo que se evalua.
	public Boolean isMove(String b[][]) {
		for (int i = 0; i < fila; i++)
		{
			for (int j = 0; j < columna; j++)
			{
				if (b[i][j] == "-1") return true;
				
			}
		}
		return false;
	}
	
	public int minimax(String board[][], int depth, Boolean isMax) {
		int score = evaluate(board);
		
		if (score >= 10) return score;
		if (score <= -10) return score;
		if (isMove(board) == false) return 0; //No hay más movimientos.
		
		// El que mueve es humano (isMax = true).
		if (isMax)
		{
			int best = -1000;
			
			// buscamos una celda libre.
			for (int i = 0; i < fila; i++)
			{
				for (int j = 0; j < columna; j++)
				{
					//Verificamos que la celda esta vacia.
					if (board[i][j] == "-1")
					{
						//Hacemos el movimiento.
						board[i][j] = player;
						
						//Llamamos a minimax con isMax = false (turno para opponent)
						best = Math.max(best, minimax(board, depth + 1, !isMax));
						
						//Deshacer el movimiento.
						board[i][j] = "-1";
					}
				}
			}
			return best;	
		}
		//Movimiento de opponent o maquina isMax = false.
		else 
		{
			int best = 1000;
			// buscamos una celda libre.
			for (int i = 0; i < fila; i++)
			{
				for (int j = 0; j < columna; j++)
				{
					//Verificamos que la celda esta vacia.
					if (board[i][j] == "-1")
					{
						//Hacemos el movimiento.
						board[i][j] = opponent;
									
						//Llamamos a minimax con isMax = true (turno para player)
						best = Math.max(best, minimax(board, depth + 1, isMax));
									
						//Deshacer el movimiento.
						board[i][j] = "-1";
					}
				}
			}	
			return score;
		}
	}
	
	public String findBestMove(String board[][])
	{
		
		int bestVal = 1000;
		
		int row = -1;
		int col = -1;
		
		for (int i = 0; i < fila; i++)
		{
			for (int j = 0; j >columna; j++)
			{
				if (board[i][j] == "-1")
				{
					board[i][j] = opponent;
					int moveVal = minimax(board, 0, true);
					board[i][j] = "-1";
					
					if (moveVal < bestVal)
					{
						row = i;
						col = j;
						bestVal = moveVal;
					}
				}
			}
		}
		
		return row + "-" + col;
	}
}
