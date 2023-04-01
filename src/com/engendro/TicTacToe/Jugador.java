package com.engendro.TicTacToe;

public class Jugador {
	//  ELEMENTOS DE LA CLASE JUGADOR
	private String nombre;
	private int[] ficha = new int[20];
	private int numerofichas;
	
	//  CONSTRUCTORES DE LA CLASE JUGADOR.
	public Jugador() { }
	
	public Jugador(String bando, int numerofichas) {
		this.nombre = bando;
		this.numerofichas = numerofichas;
		
		for(int A = 0; A < numerofichas; A++)
		{
			this.ficha[A] = -1;
		}
	}

	//GETTERS & SETTERS.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getFicha() {
		return ficha;
	}

	public void setFicha(int[] ficha) {
		this.ficha = ficha;
	}

	public int getNumerofichas() {
		return numerofichas;
	}

	public void setNumerofichas(int numerofichas) {
		this.numerofichas = numerofichas;
	}
	
	// METRODOS, PROCEDIMIENTOS Y FUNCIONES.
	
	// Mostrar las fichas y datos de un jugador.
	void mostrarFichas() {
		for(int A = 0; A < this.numerofichas; A++) {
			System.out.print(this.ficha[A] + " ");
		}
		System.out.println();
	}
	
	// Añadir un movimiento de un ficha de un jugador concreto.
	void añadirMovimiento(int numeroDeFicha, int casillaOcupada) {
		ficha[numeroDeFicha] = casillaOcupada;
	}
	
	// Ver en que casilla del tablero esta una ficha concreta de este jugador.
	int mostrarPosicionFicha(int numeroDeFicha) {
		return ficha[numeroDeFicha];
	}
	
	// Ver si el jugador consiguio ganar la partida (por el momento tener un pleno de tres).
	String mostrarSiGano(Tablero mesa) {
		String resultado = "";
		int B = 1;
		
		// Verificar que el Jugador tiene todas sus fichas en juego. Las tengo todas B = 1
		for (int A = 0; A < numerofichas; A++) {
			if (ficha[A] == -1) B = 0;
		}
		
		if (B == 0)resultado = "NO"; // Si pasa es que todas las fichas estan en juego.
		
		if (B != 0)
			{
				
				if ((mesa.mostrarCasilla(7)== nombre) && (mesa.mostrarCasilla(4)== nombre) && (mesa.mostrarCasilla(1) == nombre)) resultado = "GANO";
				if ((mesa.mostrarCasilla(8)== nombre) && (mesa.mostrarCasilla(5)== nombre) && (mesa.mostrarCasilla(2) == nombre)) resultado = "GANO";
				if ((mesa.mostrarCasilla(9)== nombre) && (mesa.mostrarCasilla(6)== nombre) && (mesa.mostrarCasilla(3) == nombre)) resultado = "GANO";
				
				if ((mesa.mostrarCasilla(7)== nombre) && (mesa.mostrarCasilla(8)== nombre) && (mesa.mostrarCasilla(9) == nombre)) resultado = "GANO";
				if ((mesa.mostrarCasilla(4)== nombre) && (mesa.mostrarCasilla(5)== nombre) && (mesa.mostrarCasilla(6) == nombre)) resultado = "GANO";
				if ((mesa.mostrarCasilla(1)== nombre) && (mesa.mostrarCasilla(2)== nombre) && (mesa.mostrarCasilla(3) == nombre)) resultado = "GANO";
				
				if ((mesa.mostrarCasilla(7)== nombre) && (mesa.mostrarCasilla(5)== nombre) && (mesa.mostrarCasilla(3) == nombre)) resultado = "GANO";
				if ((mesa.mostrarCasilla(9)== nombre) && (mesa.mostrarCasilla(5)== nombre) && (mesa.mostrarCasilla(1) == nombre)) resultado = "GANO";
				
			}
		
		return resultado;
	}
}
