package com.ilhadeJava.view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.ilhadeJava.controller.GerenciadorDeJogo;

public class TelaPrincipal extends JFrame{

	private PainelSuperior painelSuperior;
	private Tabuleiro tabuleiro;
	private PainelLateral painelLateral;
	
	public TelaPrincipal() {
		
		setTitle("O Regaste dos Alunos na Ilha de Java");
		setSize(1000,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("icones/deathstar.png").getImage());
		
		painelSuperior = new PainelSuperior();
		tabuleiro = new Tabuleiro();
		painelLateral = new PainelLateral();
		
		GerenciadorDeJogo gerenciador = new GerenciadorDeJogo(this);
		
		setLayout(new BorderLayout());
		add(painelSuperior, BorderLayout.NORTH);
		add(tabuleiro,BorderLayout.CENTER);
		add(painelLateral, BorderLayout.EAST);
		
	}

	public PainelSuperior getPainelSuperior() {
		return painelSuperior;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public PainelLateral getPainelLateral() {
		return painelLateral;
	}
	
}
