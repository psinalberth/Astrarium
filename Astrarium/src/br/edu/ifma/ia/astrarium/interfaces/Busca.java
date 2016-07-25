package br.edu.ifma.ia.astrarium.interfaces;

import java.util.List;

import interfaces.Estado;

public interface Busca {
	
	public Problema getProblema();
	
	public void setProblema(Problema problema); 

	public List<Estado> getFronteira();
	
	public void setFronteira(List<Estado> fronteira);

	public List<Estado> getVisitados();
	
	public List<Estado> expandir();
	
	public List<Estado> buscarSolucao();
}
