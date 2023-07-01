package com.ilhadeJava.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Insets;

public class BotoesOperadores extends JPanel {
	
	private JButton verificar;
	private JButton proximaRodada;
	private JButton sair;
	
	
	BotoesOperadores(){
		
		setLayout(new GridLayout(3,1,1,5));
		
		verificar= new JButton("Verificar");
		verificar.setPreferredSize(new Dimension(50,50));
		verificar.setEnabled(false);
		add(verificar);
		
		proximaRodada= new JButton("Proxima Rodada");
		proximaRodada.setPreferredSize(new Dimension(50,50));
		add(proximaRodada);
		
		sair= new JButton("Sair Do Jogo");
		sair.setPreferredSize(new Dimension(50,50));
		add(sair);
		
		
	}


	public JButton getVerificar() {
		return verificar;
	}


	public JButton getProximaRodada() {
		return proximaRodada;
	}


	public JButton getSair() {
		return sair;
	}
}
