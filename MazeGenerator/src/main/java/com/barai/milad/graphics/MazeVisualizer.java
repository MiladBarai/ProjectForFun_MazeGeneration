package com.barai.milad.graphics;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class MazeVisualizer extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7433510539901253680L;
	private List<JComponent> mazeContent;
	
	public MazeVisualizer(List<JComponent> mazeContent){
		this.mazeContent = mazeContent;
	}
	
	public void paint(Graphics g){
		for(JComponent content: mazeContent){
			content.print(g);
		}
	}

}
