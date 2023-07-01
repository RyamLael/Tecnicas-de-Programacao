package com.ilhadeJava.view;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelLateral extends JPanel{
	
	private Display display;
	private BotoesRobos botoesRobos;
	private BotoesOperadores botoesOperadores;
	
	public PainelLateral() {
		
		display = new Display();
		botoesRobos = new BotoesRobos();
		botoesOperadores = new BotoesOperadores();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(display);
		add(botoesRobos);
		add(botoesOperadores);
		setVisible(false);
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public BotoesRobos getBotoesRobos() {
		return botoesRobos;
	}
	
	public BotoesOperadores getBotoesOperadores() {
		return botoesOperadores;
	}

}
