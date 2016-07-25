package br.edu.ifma.ia.astrarium.impl;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifma.ia.astrarium.interfaces.Acao;
import br.edu.ifma.ia.astrarium.interfaces.Problema;
import br.edu.ifma.ia.astrarium.model.Mapa;
import br.edu.ifma.ia.astrarium.model.Ponto2D;
import interfaces.Estado;

public class ProblemaImpl implements Problema  {
	
	private Estado estadoInicial;
	private Estado estadoAtual;
	
	public ProblemaImpl(Estado estadoInicial) {
		
		this.estadoInicial = estadoInicial;
		this.estadoAtual = estadoInicial;
	}

	@Override
	public Set<Acao> acoes(Estado estado) {
		
		Mapa tmp = (Mapa) estado;
		Ponto2D ultimo = tmp.getUltimoPonto();
		Set<Acao> acoes = new HashSet<Acao>();
		
		for (Ponto2D ponto : tmp.getPontos()) {
			acoes.add(new AcaoImpl(ponto));
		}
		
		System.out.println(acoes);
		
		return acoes;
	}
	
	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	@Override
	public double custo(Acao arg0, Estado arg1, Estado arg2) {
		return 0;
	}

	@Override
	public Estado estadoInicial() {
		return estadoInicial;
	}

	@Override
	public Estado resultado(Acao acao, Estado estado) {
		
		Mapa mapa = (Mapa) estadoAtual();		
		Mapa tmp = mapa.replica();
		
		mapa.getUltimoPonto().conectar(acao.getPonto());
		
		if (acao.getPonto().temLigacao()) {
			
			estadoAtual = tmp;
		}
		
		tmp.getUltimoPonto().distancia(acao.getPonto());
		
		return estadoAtual;
	}

	@Override
	public boolean testaObjetivo(Estado estado) {
		
		boolean valido = true;
		
		Mapa mapa = (Mapa) estado;
		
		for (Ponto2D ponto : mapa.getPontos()) {
			
			if (!ponto.temLigacao())
				valido = false;
		}
		
		return valido;
	}

	@Override
	public Estado estadoAtual() {
		return estadoAtual;
	}
}
