package com.ilhadeJava.model;

import com.ilhadeJava.view.Icone;

public class Robo extends Entidade{
	
	private int bugsEncontrados;
	private int alunosEncontrados;
	
	public Robo() {
		this.setPontuacao(0);
		this.bugsEncontrados=0;
		this.alunosEncontrados=0;
	}
	
	public int getBugsEncontrados() {
		return bugsEncontrados;
	}

	public void addBugsEncontrados() {
		this.bugsEncontrados++;
	}

	public int getAlunosEncontrados() {
		return alunosEncontrados;
	}

	public void addAlunosEncontrados() {
		this.alunosEncontrados++;
	}
}
