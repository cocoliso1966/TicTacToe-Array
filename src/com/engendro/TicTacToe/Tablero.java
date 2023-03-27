package com.engendro.TicTacToe;

public class Tablero {
	//  DEFINICION DE ELEMENTOS DE LA CLASE TABLERO.
	private String[][] tabla;
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
				this.tabla[A][B] = "FREE";
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
	void mostrartablero() {
		System.out.println("/n");
		for(int A = 0; A < this.ladoA; A++) {
			for(int B = 0; B < this.ladoB; B++) {
				if (B < this.ladoB - 1)
				{
					System.out.println(this.tabla[A][B] + "-");
				} else {
					System.out.println(this.tabla[A][B]);
				}
			}
			System.out.println("/n");
		}
		System.out.println("/n");
	}
}
