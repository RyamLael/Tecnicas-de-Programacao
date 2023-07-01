package com.ilhadeJava.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelSuperior extends JPanel{

	private JButton botaoJogar;
	private JTextField campodetexto;
	private JButton relatorio;

	public PainelSuperior() {
		
		setBackground(Color.lightGray);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 1));
		
		add(new JLabel("Nome do jogador:"));
		
		campodetexto = new JTextField();
		campodetexto.setPreferredSize(new Dimension(130,28));
		add(campodetexto);
		
		botaoJogar = newButton("Jogar", new Color(64,181,251));		
		add(botaoJogar);
		
		relatorio = newButton("Relatorio", new Color(64,181,251));
		add(relatorio);
	}
	
	private JButton newButton(String nome, Color cor ) {
		
		JButton button = new JButton(nome);
		setPreferredSize(new Dimension(30, 30));
		
        button.setBackground(cor);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        
		return button;
	}
	
	public JTextField getCampodetexto() {
		return campodetexto;
	}

	public JButton getBotaoJogar() {
		return botaoJogar;
	}
}
