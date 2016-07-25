package br.edu.ifma.ia.astrarium.model;

import br.edu.ifma.ia.astrarium.interfaces.Acao;

public class Ponto2D {
	
	private int x;
	private int y;
	private Acao conectar;
	private Ponto2D link;
	
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
	
	public Acao conectar(Ponto2D ponto) {
		return this.conectar;
	}
	
	public void setLink(Ponto2D link) {
		this.link = link;
	}
	
	public Ponto2D getLink() {
		return link;
	}
	
	public boolean temLigacao() {
		return link != null;
	}
	
	@Override
	public String toString() {
		return "[" + this.getX() + ", " + this.getY() + "]";
	}
}