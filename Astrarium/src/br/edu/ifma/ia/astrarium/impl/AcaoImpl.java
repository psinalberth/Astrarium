package br.edu.ifma.ia.astrarium.impl;

import br.edu.ifma.ia.astrarium.interfaces.Acao;
import br.edu.ifma.ia.astrarium.model.Ponto2D;

public class AcaoImpl implements Acao {
	
	private Ponto2D ponto;
	
	public AcaoImpl(Ponto2D ponto) {
		this.ponto = ponto;
	}
	
	public Ponto2D getPonto() {
		return ponto;
	}
	
	@Override
	public String toString() {
		return getAcao();
	}
	
	public String getAcao() {
		return "Conectar ao ponto " + ponto;
	}
}
