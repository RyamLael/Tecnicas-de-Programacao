package com.ilhadeJava.model;

import com.ilhadeJava.view.Icone;

public class Aluno extends Entidade{
	public Aluno() {
		this.setPontuacao(10);
		setIcone(new Icone("icones/luke.png", 32,32));
	}
}
