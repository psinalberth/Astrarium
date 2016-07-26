package br.edu.ifma.ia.astrarium.model;

import java.util.HashSet;
import java.util.Set;

import interfaces.Estado;

public class Mapa implements Estado {
	
	private Set<Ponto2D> pontos;
	private Ponto2D ultimoPonto;
	private int dimensao;
	
	public Mapa(int dimensao) {
		this.dimensao = dimensao;
		setup();
	}
	
	public void adicionaPonto(Ponto2D ponto) {
		this.pontos.add(ponto);
		this.ultimoPonto = ponto;
	}
	
	private void setup() {
		this.pontos = new HashSet<Ponto2D>();
	}

	@Override
	public boolean estadoValido() {
		return (this.ultimoPonto.temLigacao());
	}

	@Override
	public boolean igual(Estado outro) {
	
		Mapa tmp = (Mapa) outro;
		
		boolean igual = true;
			
		for (Ponto2D outroPonto : tmp.getPontos()) {
			
			if (!this.getPontos().contains(outroPonto))
				igual = false;
		}
		
		return igual;
	}
	
	public Set<Ponto2D> getPontos() {
		return pontos;
	}
	
	public Ponto2D getUltimoPonto() {
		return ultimoPonto;
	}
	
	public void setUltimoPonto(Ponto2D ultimoPonto) {
		this.ultimoPonto = ultimoPonto;
	}
	
	public int getDimensao() {
		return dimensao;
	}
	
	public Mapa replica() {
		
		Mapa temp = new Mapa(this.getDimensao());
		
		for (Ponto2D ponto : this.getPontos()) {
			temp.adicionaPonto(ponto);
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		return getUltimoPonto().toString();
	}
}
