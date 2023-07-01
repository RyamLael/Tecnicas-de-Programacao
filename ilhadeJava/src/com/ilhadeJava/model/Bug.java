package com.ilhadeJava.model;

import com.ilhadeJava.view.Icone;

public class Bug extends Entidade{
	
	public Bug() {
		this.setPontuacao(-15);
		setIcone(new Icone("icones/darth.png",32,32));
	}
}
