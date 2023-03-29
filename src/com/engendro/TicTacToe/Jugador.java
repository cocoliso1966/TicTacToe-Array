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
}
