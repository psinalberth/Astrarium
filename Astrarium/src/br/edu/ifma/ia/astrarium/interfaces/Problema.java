package br.edu.ifma.ia.astrarium.interfaces;

import java.util.Set;

import interfaces.Estado;

public interface Problema {
	
	public boolean testaObjetivo(Estado estado);
	
	public Estado estadoInicial();
	
	public Estado estadoAtual();
	
	public Estado resultado(Acao acao, Estado estado);
	
	public Set<Acao> acoes(Estado estado);
	
	public double custo(Acao acao, Estado e1, Estado e2);
}
