package com.engendro.TicTacToe;

import java.util.Scanner;

public class Main {
	static Jugador persona = new Jugador("P", 3);
	static Jugador ordenador = new Jugador("M", 3);
	static Tablero mesajuego = new Tablero(3, 3);
	
	
	static void pregunta() {
		Scanner teclado = new Scanner (System.in);
		
		
		
		System.out.println("Quién es el primer jugador (0 - Persona / 1 - Maquina):  ");
		int opcion = teclado.nextInt();
		//System.out.println("Se eligio: " + opcion);
		
		
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

	static String jugarFichasSinUso(int H, Jugador gamer)
	{
		String resultado = "ERROR";
		
		if (mesajuego.mostrarCasilla(H)== "-1")
		{
			//No esta ocupada la casilla - es valido el movimiento.
			resultado = mesajuego.escribirCasilla(H, gamer);
			
			//Miro que tengamos alguna ficha sin poner en el tablero
			if (resultado == "OK")
			{
				for (int A = 0; A < gamer.getNumerofichas(); A++)
				{
					if (gamer.mostrarPosicionFicha(A) == -1)
					{
					gamer.añadirMovimiento(A, H); 
					return "OK";
					}
				}
				return "TABLERO";
			}
		}
		return resultado;
	} 
	static String verificarMovimiento(int H, int H1, Jugador gamer)
	{
		switch(gamer.getFicha(H1-1))
		{
		case 1: if (H==2 || H == 4 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 2: if (H==1 || H == 3 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 3: if (H==2 || H == 6 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 4: if (H==1 || H == 7 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 5: if (H==1 || H == 2 || H == 3 || H == 4 || H == 6 || H == 7 || H == 8 || H == 9) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 6: if (H==3 || H == 9 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 7: if (H==4 || H == 8 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 8: if (H==7 || H == 9 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";

		case 9: if (H==8 || H == 6 || H == 5) 
				{
					if (mesajuego.mostrarCasilla(H) == "-1") return "OK";
					else return "ERROR";		
				} else return "ERROR";
		
		default: return "ERROR";
		
		}
	}
	
	static void partida(int opcion)
	{
		Scanner teclado = new Scanner (System.in);
		String error = "ERROR";  // indico que ocupar la casilla H con la pieza H1 no es valido por defecto
		String paso = "ERROR";
		int H, H1, M, M1;
		int turno;
		
		
		// Inicia humano
		
		turno = opcion;   // 0 : Turno a humano
			 			  // 1 : Turno a Maquina
			
		do
		{
			
			if (turno == 0)
			{
				mesajuego.mostrarTablero();
				for (int J = 0; J < persona.getNumerofichas(); J++)
				{
					System.out.println("La ficha " + J + " ocupa la casilla: " + persona.getFicha(J));
				}
					
				System.out.println("Movimiento del jugador HUMANO (número de ficha 0, 1, 2): ");
				H1 = teclado.nextInt();
				System.out.println("Eligio HUMANO ficha: " + H1);
					
				System.out.println("Movimiento del jugador HUMANO (número de Casilla 1 al 9): ");
				H = teclado.nextInt();
				System.out.println("Eligio HUMANO casilla: " + H);
				
					// Escribo el movimiento en el tablero de juego.
					// Si hay fichas sin jugar las uso.
					// Devuelve ERROR, OK (escribio tablero y uso ficha libre), TABLERO (escribio en tablero, no hay ficha libre)
				paso = jugarFichasSinUso(H, persona);
						
					//En esta parte se juega con todas las fichas en el tablero. No paso lo anterior.
				if (paso == "TABLERO")  //Se escribio en tablero, pero no hay ficha libre
				{
					System.out.println("Estoy en veriicarMovimiento...");
					paso = verificarMovimiento(H, H1, persona);
					System.out.println("paso vale = " + paso);
				}
				if (paso == "OK") turno = 1;
				else {
						System.out.println ("Ocurrio un error con la casilla: " + H + " ficha: " + H1);
						System.out.println ("Repetir la jugada de HUMANO..");
					}
			} else 
				{
					mesajuego.mostrarTablero();
					for (int J = 0; J < ordenador.getNumerofichas(); J++)
					{
						System.out.println("La ficha " + J + " ocupa la casilla: " + ordenador.getFicha(J));
					}
					
					System.out.println("Movimiento del jugador ORDENADOR (número de ficha 0, 1, 2): ");
					H1 = teclado.nextInt();
					System.out.println("Eligio ORDENADOR ficha: " + H1);
					
					System.out.println("Movimiento del jugador ORDENADOR (número de Casilla 1 al 9): ");
					H = teclado.nextInt();
					System.out.println("Eligio ORDENADOR casilla: " + H);
				
					// Escribo el movimiento en el tablero de juego.
					// Si hay fichas sin jugar las uso.
					// Devuelve ERROR, OK (escribio tablero y uso ficha libre), TABLERO (escribio en tablero, no hay ficha libre)
					paso = jugarFichasSinUso(H, ordenador);
						
					//En esta parte se juega con todas las fichas en el tablero. No paso lo anterior.
					if (paso == "TABLERO")  //Se escribio en tablero, pero no hay ficha libre
						{
							System.out.println("Estoy en veriicarMovimiento...");
							paso = verificarMovimiento(H, H1, ordenador);
							System.out.println("paso vale = " + paso);
						}
					if (paso == "OK") turno = 0;
					else {
						System.out.println ("Ocurrio un error con la casilla: " + H + " ficha: " + H1);
						System.out.println ("Repetir la jugada del ORDENADOR..");
					}
			}
			System.out.println("Valor de mostrarSiGano: " + mesajuego.mostrarSiGano());
		} while(mesajuego.mostrarSiGano() == "JUGAR");
			
		teclado.close();
			
			// Vamos a ver quien gano.
		System.out.println("Humano: " + persona.mostrarSiGano(mesajuego) + ", Ordenador: " + ordenador.mostrarSiGano(mesajuego) + " \n");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("JUEGO DEL TRES EN RAYA DE SEBAS.");
		mesajuego.mostrarTablero();
		pregunta();
		
		System.out.println("FIN DEL JUEGO.");
		
		

	}

}
