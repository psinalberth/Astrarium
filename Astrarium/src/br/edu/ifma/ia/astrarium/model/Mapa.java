package br.edu.ifma.ia.astrarium.model;

import java.util.Set;

import interfaces.Estado;

public class Mapa implements Estado {
	
	private Set<Ponto2D> pontos;
	
	@Override
	public boolean estadoValido() {
		return false;
	}

	@Override
	public boolean igual(Estado arg0) {
		return false;
	}
	
	public Set<Ponto2D> getPontos() {
		return pontos;
	}
}
