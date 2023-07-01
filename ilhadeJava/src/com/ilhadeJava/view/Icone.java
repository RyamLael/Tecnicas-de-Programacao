package com.ilhadeJava.view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Icone extends ImageIcon{
	
	public Icone(String endereco, int largura, int altura){
		
		super(endereco);
		this.redimensionar(largura,altura);
		
	}
	
	public void redimensionar(int largura, int altura) {
		Image imagemOriginal = getImage();
		Image imagemRedimensionada = imagemOriginal.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
		setImage(imagemRedimensionada);
	}
}
