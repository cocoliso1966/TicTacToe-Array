package com.engendro.TicTacToe;

public class TicTacToe {
	static class Move
	{
		int row, col;
	};
	
	static char player = 'x', opponent = 'o';
	
	static Boolean isMovesLeft(char board[][])
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == '_')
					return true;
		return false;
	}
	
	static int evaluate(char b[][])
	{
		// Checking for Rows for X or O victory.
		for (int row = 0; row < 3; row++)
		{
			if (b[row][0] == b[row][1] &&
				b[row][1] == b[row][2])
			{
				if (b[row][0] == player)
					return +10;
				else if (b[row][0] == opponent)
					return -10;
			}
		}

		// Checking for Columns for X or O victory.
		for (int col = 0; col < 3; col++)
		{
			if (b[0][col] == b[1][col] &&
				b[1][col] == b[2][col])
			{
				if (b[0][col] == player)
					return +10;

				else if (b[0][col] == opponent)
					return -10;
			}
		}

		// Checking for Diagonals for X or O victory.
		if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
		{
			if (b[0][0] == player)
				return +10;
			else if (b[0][0] == opponent)
				return -10;
		}

		if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
		{
			if (b[0][2] == player)
				return +10;
			else if (b[0][2] == opponent)
				return -10;
		}

		// Else if none of them have won then return 0
		return 0;
	}

	static int minimax(char board[][], int depth, Boolean isMax)
	{
		int score = evaluate(board);

		// If Maximizer has won the game
		// return his/her evaluated score
		if (score == 10)
			return score;

		// If Minimizer has won the game
		// return his/her evaluated score
		if (score == -10)
			return score;

		// If there are no more moves and
		// no winner then it is a tie
		if (isMovesLeft(board) == false)
			return 0;

		// If this maximizer's move
		if (isMax)
		{
			int best = -1000;

			// Traverse all cells
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					// Check if cell is empty
					if (board[i][j]=='_')
					{
						// Make the move
						board[i][j] = player;

						// Call minimax recursively and choose
						// the maximum value
						best = Math.max(best, minimax(board, depth + 1, !isMax));

						// Undo the move
						board[i][j] = '_';
					}
				}
			}
			return best;
		}

		// If this minimizer's move
		else
		{
			int best = 1000;

			// Traverse all cells
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					// Check if cell is empty
					if (board[i][j] == '_')
					{
						// Make the move
						board[i][j] = opponent;

						// Call minimax recursively and choose
						// the minimum value
						best = Math.min(best, minimax(board, depth + 1, !isMax));

						// Undo the move
						board[i][j] = '_';
					}
				}
			}
			return best;
		}
	}
	
	
	static Move findBestMove(char board[][])
	{
		int bestVal = -1000;
		Move bestMove = new Move();
		bestMove.row = -1;
		bestMove.col = -1;

		// Traverse all cells, evaluate minimax function
		// for all empty cells. And return the cell
		// with optimal value.
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				// Check if cell is empty
				if (board[i][j] == '_')
				{
					// Make the move
					//board[i][j] = player;
					board[i][j] =opponent;
					
					// compute evaluation function for this
					// move.
					//int moveVal = minimax(board, 0, false);
					int moveVal = minimax(board, 0, true);
					
					// Undo the move
					board[i][j] = '_';

					// If the value of the current move is
					// more than the best value, then update
					// best/
					if (moveVal > bestVal)
					{
						bestMove.row = i;
						bestMove.col = j;
						bestVal = moveVal;
					}
				}
			}
		}

		System.out.printf("The value of the best Move " + "is : %d\n\n", bestVal);

		return bestMove;
	}

	
	
	public static void main(String[] args) {
		//Jugador persona = new Jugador("P", 3);
		//Jugador ordenador = new Jugador("M", 3);
		//Tablero mesajuego = new Tablero(3, 3);

		
		//ordenador.añadirMovimiento( 0, 7);
		//ordenador.mostrarFichas();
		//mesajuego.escribirCasilla(7, ordenador);
		//mesajuego.mostrarTablero(); 
		//System.out.println("la ficha o del jugador ordenador esta en: " + ordenador.mostrarPosicionFicha(1));
		//System.out.println("La posicion de todas las fichas de ordenador es: " + ordenador.getFicha());
		
		char board[][] = {{ 'x', 'o', 'o' },
						  { 'x', '_', '_' },
						  { '_', '_', 'x' }};
	
		Move bestMove = findBestMove(board);

		System.out.printf("The Optimal Move is :\n");
		System.out.printf("ROW: %d COL: %d\n\n", bestMove.row, bestMove.col );
	}

}
