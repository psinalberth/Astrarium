package br.edu.ifma.ia.astrarium.run;

import br.edu.ifma.ia.astrarium.impl.BuscaAEstrelaImpl;
import br.edu.ifma.ia.astrarium.impl.ProblemaImpl;
import br.edu.ifma.ia.astrarium.interfaces.Busca;
import br.edu.ifma.ia.astrarium.interfaces.Problema;
import br.edu.ifma.ia.astrarium.model.Mapa;
import br.edu.ifma.ia.astrarium.model.Ponto2D;

public class Main {

	public static void main(String[] args) {
		
		final int DIMENSAO = 10;
		
		Mapa mapa = new Mapa(DIMENSAO);
		
		Ponto2D p = new Ponto2D(4, 1);
		p.setPai(null);
		
		mapa.adicionaPonto(new Ponto2D(0, 1));
		mapa.adicionaPonto(new Ponto2D(2, 7));
		mapa.adicionaPonto(new Ponto2D(4, 6));
		mapa.adicionaPonto(p);
		mapa.adicionaPonto(new Ponto2D(9, 5));
		mapa.setUltimoPonto(p);
		
		for (Ponto2D ponto : mapa.getPontos())
			System.out.println(ponto);
		
		Problema problema = new ProblemaImpl(mapa);
		Busca busca = new BuscaAEstrelaImpl(problema);
		System.out.println(busca.buscarSolucao());
	}
}
