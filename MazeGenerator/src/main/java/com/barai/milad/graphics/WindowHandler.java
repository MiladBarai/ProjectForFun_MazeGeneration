package com.barai.milad.graphics;

import javax.swing.JFrame;
import java.awt.*;

public class WindowHandler extends JFrame{
	
	/**
	 * Generated Serial version ID
	 */
	private static final long serialVersionUID = -5781370672076495909L;
	
	public WindowHandler(int windowWidth, int windowHeight)  {
		this.setSize(windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void drawCell(CellVisualizer cell) {
		this.add(cell, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
