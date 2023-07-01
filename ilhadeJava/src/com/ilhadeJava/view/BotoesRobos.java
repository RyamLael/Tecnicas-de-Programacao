package com.ilhadeJava.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.ilhadeJava.model.JButtonrobots;
import com.ilhadeJava.model.R2D2;
import com.ilhadeJava.model.Robo;

public class BotoesRobos extends JPanel{
	
	private JButtonrobots botaoR2D2;
	private JButtonrobots botaoC3PO;
	private JButtonrobots botaoBB8;
	private Robo roboEscolhido;
	private int botoesPressionados;

	public BotoesRobos() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 1));
		
		botaoR2D2 = new JButtonrobots(new Icone("icones/R2D2.png",64,64));
		botaoR2D2.setContentAreaFilled(false);
		botaoR2D2.setFocusPainted(false);
		add(botaoR2D2);
		
		botaoC3PO= new JButtonrobots(new Icone("icones/C3PO.png",64,64));
		botaoC3PO.setContentAreaFilled(false);
		botaoC3PO.setFocusPainted(false);
		add(botaoC3PO);
		
		botaoBB8= new JButtonrobots(new Icone("icones/BB8.png",64,64));
		botaoBB8.setContentAreaFilled(false);
		botaoBB8.setFocusPainted(false);
		add(botaoBB8);
		
	}
	
	public int getBotoesPressionados() {
		return botoesPressionados;
	}

	public boolean todosBotoesPressionados() {
		
		this.botoesPressionados++;
		
		if(botoesPressionados==3) {
			botoesPressionados=0;
			return true;
		}
		return false;
	}
	
	public void disableAllbuttons() {
		botaoR2D2.setEnabled(false);
		botaoC3PO.setEnabled(false);
		botaoBB8.setEnabled(false);
	}
	
	public void enableUnpressedButtons() {
		
		ArrayList<JButtonrobots> listaBotoesRobos=  new ArrayList<>();
		listaBotoesRobos.add(botaoR2D2); listaBotoesRobos.add(botaoC3PO); listaBotoesRobos.add(botaoBB8);
		
		for(JButtonrobots botoesrobos : listaBotoesRobos) {
			if(!botoesrobos.isWasPressed()) {
				 botoesrobos.setEnabled(true);
			}
		}
	}
	
	public void restoreAllButtons() {
		
		ArrayList<JButtonrobots> listaBotoesRobos=  new ArrayList<>();
		listaBotoesRobos.add(botaoR2D2); listaBotoesRobos.add(botaoC3PO); listaBotoesRobos.add(botaoBB8);
		
		for(JButtonrobots botoesrobos : listaBotoesRobos) {
			botoesrobos.setWasPressed(false);
			botoesrobos.setEnabled(true);
		}
	}
	
	public JButton getBotaoR2D2() {
		return botaoR2D2;
	}

	public JButton getBotaoC3PO() {
		return botaoC3PO;
	}

	public JButton getBotaoBB8() {
		return botaoBB8;
	}
	public Robo getRoboEscolhido() {
		return roboEscolhido;
	}
	public void setRoboEscolhido(Robo roboEscolhido) {
		this.roboEscolhido = roboEscolhido;
	}
	
}
