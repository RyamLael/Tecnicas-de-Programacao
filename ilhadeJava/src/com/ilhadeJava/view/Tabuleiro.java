package com.ilhadeJava.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.ilhadeJava.model.Celula;
import com.ilhadeJava.model.Plano;

public class Tabuleiro extends JPanel{
	
	private Plano plano;

	public Tabuleiro() {
		
		plano = new Plano();
		setSize(650,650);
		
		setLayout(new GridLayout(8,8));
		criarTabuleiro();
		
		setVisible(false);
	}
	private void criarTabuleiro() {
		
		Color corClara = new Color(150, 150, 150);
		Color corEscura = new Color(77, 77, 77);
		
		for(int coluna=1, id=0, cor=0; coluna<=8;coluna++,cor++) {
			for(int linha=1;linha<=8;linha++,id++,cor++){
				
				Celula celula = new Celula(id);
				
				if(cor%2==0) 
					celula.getBotao().setBackground(corEscura);
				else
					celula.getBotao().setBackground(corClara);
				
				add(celula.getBotao());
				plano.getCelula(id).setBotao(celula.getBotao());
				
			}
		}
	}
	

	public Plano getPlano() {
		return plano;
	}
}
