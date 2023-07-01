package com.ilhadeJava.model;

import com.ilhadeJava.view.Icone;

public abstract class Entidade {
	private Icone icone;
	private int pontuacao;
	
	public Icone getIcone() {
		return icone;
	}
	public void setIcone(Icone icone) {
		this.icone = icone;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
