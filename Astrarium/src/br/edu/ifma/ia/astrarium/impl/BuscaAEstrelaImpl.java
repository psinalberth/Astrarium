package br.edu.ifma.ia.astrarium.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ifma.ia.astrarium.interfaces.Acao;
import br.edu.ifma.ia.astrarium.interfaces.Busca;
import br.edu.ifma.ia.astrarium.interfaces.Problema;
import interfaces.Estado;

public class BuscaAEstrelaImpl implements Busca {
	
	private Problema problema;
	private List<Estado> visitados;
	private List<Estado> fronteira;
	
	public BuscaAEstrelaImpl(Problema problema) {
		this.problema = problema;
		this.fronteira = new ArrayList<Estado>();
		this.visitados = new ArrayList<Estado>();
	}
	
	public Problema getProblema() {
		return problema;
	}
	
	public List<Estado> getVisitados() {
		return visitados;
	}
	
	public List<Estado> expandir() {
		
		Set<Acao> acoes = getProblema().acoes(getProblema().estadoAtual());
		
		List<Estado> estados = new ArrayList<Estado>();
		
		for (Acao acao : acoes) {
			
			Estado estado = getProblema().resultado(acao, getProblema().estadoAtual());
			estados.add(estado);
		}
		
		return estados;
	}
	
	public List<Estado> getFronteira() {
		return fronteira;
	}
	
	public List<Estado> buscarSolucao() {
		
		List<Estado> solucao = new ArrayList<Estado>();
		Estado atual = getProblema().estadoAtual();
		
		this.getFronteira().add(atual);
		
		while (!getFronteira().isEmpty() && !problema.testaObjetivo(atual)) {
			
			if (problema.testaObjetivo(atual)) {
				break;
			}
			
			atual = getFronteira().remove(getFronteira().size()-1);
			solucao.add(atual);
			
			List<Estado> estados = expandir();
			
			for (Estado estado : estados) {
				
				if (!getVisitados().contains(estado)) {
				
					getFronteira().add(estado);
				}
			}
			
			getVisitados().add(atual);
		}
		
		return solucao;
	}

	@Override
	public void setProblema(Problema problema) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFronteira(List<Estado> fronteira) {
		// TODO Auto-generated method stub
		
	}
}