package br.edu.ifma.ia.astrarium.model;

import interfaces.Estado;

public class Mapa implements Estado {

	@Override
	public boolean estadoValido() {	
		return false;
	}

	@Override
	public boolean igual(Estado arg0) {
		return false;
	}

}
