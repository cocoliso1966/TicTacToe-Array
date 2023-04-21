package com.engendro.TicTacToe;

import java.util.Scanner;

public class Main {
	static Jugador persona = new Jugador("P", 3);
	static Jugador ordenador = new Jugador("M", 3);
	static Tablero mesajuego = new Tablero(3, 3);
	
	
	static void pregunta() {
		Scanner teclado = new Scanner (System.in);
		
		
		
		System.out.println("Quién es el 1º jugador (0 - Persona / 1 - Maquina):  ");
		int opcion = teclado.nextInt();
		System.out.println("Se eligio: " + opcion);
		
		
		if (opcion == 0) 
		{ 
			System.out.println("Se elegio Persona (0).");
			partida(opcion);
		}
		if (opcion == 1) 
		{
			System.out.println("Se eligio Maquina (1).");
			partida(opcion);
		}
		teclado.close();
	}

	static void partida(int opcion)
	{
		Scanner teclado = new Scanner (System.in);
		String error = "ERROR";  // indico que ocupar la casilla H con la pieza H1 no es valido por defecto
		int H, H1, M, M1;
		int valido, turno;
		
		
		// Inicia humano
		if (opcion == 0)
		{
			turno = 0;   // 0 : Turno a humano
			 			 // 1 : Turno a Maquina
			
			do
			{
				if (turno == 0)
				{
					valido = 0; // valor = 0 --> indico que tengo todas las fichas en juego.
							    // valor = 1 --> He puesto una ficha libre en el tablero (solo podre poner 3 veces).
					
					for (int J = 0; J < persona.getNumerofichas(); J++)
					{
						System.out.println("La ficha " + J+1 + " ocupa la casilla: " + persona.getFicha(J));
					}
					
					System.out.println("Movimiento del jugador humano (número de ficha 1, 2, 3): ");
					H1 = teclado.nextInt();
					
					System.out.println("Movimiento del jugador humano (número de Casilla 1 al 9): ");
					H = teclado.nextInt();
				
					if (mesajuego.mostrarCasilla(H)== "-1")
					{
						//No esta ocupada la casilla - es valido el movimiento.
						mesajuego.escribirCasilla(H, persona);
						
						//Miro que tengamos alguna ficha sin poner en el tablero
						for (int A = 0; A < persona.getNumerofichas(); A++)
						{
							if (persona.mostrarPosicionFicha(A) == -1)
							{
								persona.añadirMovimiento(A, H); 
								valido = 1; //He puesto en juego una ficha de este jugador
								break;
							}
						}
						
						//En esta parte se juega con todas las fichas en el tablero. No paso lo anterior.
						if (valido == 0)
						{
							switch(persona.getFicha(H1-1))
							{
							case 1: if (H==2 || H == 4 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 2: if (H==1 || H == 3 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 3: if (H==2 || H == 6 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 4: if (H==1 || H == 7 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 5: if (H==1 || H == 2 || H == 3 || H == 4 || H == 6 || H == 7 || H == 8 || H == 9) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 6: if (H==3 || H == 9 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 7: if (H==4 || H == 8 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 8: if (H==7 || H == 9 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							case 9: if (H==8 || H == 6 || H == 5) 
									{
										if (mesajuego.mostrarCasilla(H) == "-1") error = "OK";
										else error = "ERROR";		
									} else error = "ERROR";
									break;
							default: break;
							}
						}
						if (error == "OK") persona.añadirMovimiento(H1-1, H);
					}
				} else {
					
				}
			 
			} while(error == "A");
		}
	}
	
	public static void main(String[] args) {
		
		mesajuego.mostrarTablero();
		
		
		pregunta();
		

	}

}
