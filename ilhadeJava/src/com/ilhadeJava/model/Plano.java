package com.ilhadeJava.model;

import java.util.ArrayList;

public class Plano {
	
	private ArrayList<Celula> listaCelulas;

	public Plano() {
		
		listaCelulas= new ArrayList<Celula>();
		
		for(int id=0; id<64;id++) {
			listaCelulas.add(new Celula(id));
		}
	}
	
	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}
	
	public Celula getCelula(int id) {
		return listaCelulas.get(id);
	}
	
	public int celulasVazias() {
		int celulasNaovisitadas = 64;
		
		for(Celula celula : listaCelulas) {
			if(celula.isRoboPassou())
				celulasNaovisitadas--;
		}
		return celulasNaovisitadas;
	}
}
