package com.ilhadeJava.model;

import javax.swing.JButton;

import com.ilhadeJava.view.Icone;

public class JButtonrobots extends JButton{
	
	private boolean wasPressed;

	public JButtonrobots(Icone icone) {
		super(icone);
	}
	
	public boolean isWasPressed() {
		return wasPressed;
	}

	public void setWasPressed(boolean wasPressed) {
		this.wasPressed = wasPressed;
	}
}