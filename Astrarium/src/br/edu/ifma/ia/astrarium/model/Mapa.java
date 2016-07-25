package br.edu.ifma.ia.astrarium.model;

import interfaces.Estado;

public class Mapa implements Estado {
	
	private Ponto2D[][] pontos;
	
	@Override
	public boolean estadoValido() {
		return false;
	}

	@Override
	public boolean igual(Estado arg0) {
		return false;
	}
	
	public Ponto2D[][] getPontos() {
		return pontos;
	}
}
