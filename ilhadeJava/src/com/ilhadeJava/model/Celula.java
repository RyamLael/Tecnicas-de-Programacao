package com.ilhadeJava.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

import com.ilhadeJava.view.Icone;

public class Celula {
	
	private ArrayList<Entidade> listaEntidades;
	private JButton botao;
	private boolean roboPassou;
	private int id;
	
	public Celula(int id) {
		
		listaEntidades = new ArrayList<Entidade>();
		this.id=id;
		
		botao = new JButton();
		botao.setEnabled(false);
		botao.setFocusPainted(false);
	}

	public JButton getBotao() {
		return botao;
	}

	public boolean isRoboPassou() {
		return roboPassou;
	}
	
	public void setRoboPassou(boolean roboPassou) {
		this.roboPassou = roboPassou;
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Entidade> getListaEntidades() {
		return listaEntidades;
	}

	public void setListaEntidades(ArrayList<Entidade> listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public void setBotao(JButton botao) {
		this.botao = botao;
	}
	
	public boolean possuiRobo(Robo robo) {
		
		for(Entidade entidades : listaEntidades) {
			if (entidades.getClass().isAssignableFrom(robo.getClass())) 
				return (true);
		}
		return false;
	}

	public boolean possuiRobos() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Robo) 
				return true;
		}
		return false;
	}
	
	public boolean possuiAlunos() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Aluno)
				return true;
		}
		return false;
	}
	
	public boolean possuiBugs() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Bug)
				return true;
		}
		return false;
	}
	
	public boolean possuiEntidades() {
		for(Entidade entidades : listaEntidades) {
			if(entidades instanceof Aluno || entidades instanceof Bug)
				return true;
		}
		return false;
	}
	
	public void removerRobo(Robo robo) {
			listaEntidades.remove(robo);
	}
	
}
