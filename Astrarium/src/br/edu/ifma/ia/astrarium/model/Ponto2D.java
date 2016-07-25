package br.edu.ifma.ia.astrarium.model;

public class Ponto2D {
	
	private int x;
	private int y;
	
	public Ponto2D() {
		
	}
	
	public Ponto2D(int x, int y) {	
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double distancia(Ponto2D outro) {
		return Math.sqrt(Math.pow(outro.getX() - this.getX(), 2) + Math.pow(outro.getY() - this.getY(), 2));
	}
	
	public boolean equals(Ponto2D outro) {
		return this.getX() == outro.getX() && this.getY() == outro.getY();
	}
}
