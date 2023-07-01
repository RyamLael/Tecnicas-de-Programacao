package com.ilhadeJava.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel{
	
	private JLabel pontuacaoTotal;
	private JLabel pontuacaoR2D2;
	private JLabel pontuacaoC3PO;
	private JLabel pontuacaoBB8;
	private JLabel bugsEncotrados;
	private JLabel alunosEncontrados;
	
	public Display() {
		
		this.setSize(400,400);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		inicializarpontuacao();
		
		addPontuacao();
		addEntidadesEncontradas();
		addPontuacaoRobos();
	}
	
	private void inicializarpontuacao() {
		
		pontuacaoTotal = new JLabel();
		pontuacaoR2D2 = new JLabel();
		pontuacaoC3PO = new JLabel();
		pontuacaoBB8 = new JLabel();
		bugsEncotrados = new JLabel();
		alunosEncontrados = new JLabel();
		
		pontuacaoTotal.setText("Total: 0");
		pontuacaoR2D2.setText("0");
		pontuacaoC3PO.setText("0");
		pontuacaoBB8.setText("0");
		bugsEncotrados.setText("0");
		alunosEncontrados.setText("0");
	}
	
	private void addPontuacao() {
		
		JPanel pontuacao = new JPanel();
		pontuacao.setLayout(new FlowLayout());
		pontuacao.add(pontuacaoTotal);
		add(pontuacao);
	}
	
	private void addEntidadesEncontradas() {
		
		JPanel entidadesEncontradas = new JPanel();
		
		entidadesEncontradas.add(new JLabel("Total:"));
		entidadesEncontradas.add(new JLabel(new Icone("icones/darth.png", 32,32)));
		entidadesEncontradas.add(bugsEncotrados);
		entidadesEncontradas.add(new JLabel(new Icone("icones/luke.png",32,32)));
		entidadesEncontradas.add(alunosEncontrados);
		this.add(entidadesEncontradas);
		
	}
	
	private void addPontuacaoRobos(){
		
		JPanel pontuacaoRobos = new JPanel();

		JLabel imagemr2d2 = new JLabel(new Icone("icones/r2d2.png",64,64));
		JLabel imagemc3po = new JLabel(new Icone("icones/C3PO.png",64,64));
		JLabel imagembb8 = new JLabel(new Icone("icones/BB8.png",64,64));
		
		pontuacaoRobos.add(imagemr2d2);
		pontuacaoRobos.add(pontuacaoR2D2);
		
		pontuacaoRobos.add(imagemc3po);
		pontuacaoRobos.add(pontuacaoC3PO);
		
		pontuacaoRobos.add(imagembb8);
		pontuacaoRobos.add(pontuacaoBB8);
		this.add(pontuacaoRobos);
	}
	
	public void updateData(int pontuacaor2d2,int pontuacaoc3po, int pontuacaobb8, int bugsencontrados, int alunosencontrados) {
		pontuacaoR2D2.setText(Integer.toString(pontuacaor2d2));
		pontuacaoC3PO.setText(Integer.toString(pontuacaoc3po));
		pontuacaoBB8.setText(Integer.toString(pontuacaobb8));
		pontuacaoTotal.setText("Total: "+Integer.toString(pontuacaor2d2+pontuacaoc3po+pontuacaobb8));
		bugsEncotrados.setText(Integer.toString(bugsencontrados));
		alunosEncontrados.setText(Integer.toString(alunosencontrados));
		
	}
	
	public JLabel getBugsEncotrados() {
		return bugsEncotrados;
	}

	public void setBugsEncotrados(JLabel bugsEncotrados) {
		this.bugsEncotrados = bugsEncotrados;
	}

	public JLabel getAlunosEncontrados() {
		return alunosEncontrados;
	}

	public void setAlunosEncontrados(JLabel alunosEncontrados) {
		this.alunosEncontrados = alunosEncontrados;
	}

}
