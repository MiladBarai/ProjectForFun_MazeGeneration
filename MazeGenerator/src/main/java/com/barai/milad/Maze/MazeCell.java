package com.barai.milad.Maze;

import java.util.ArrayList;

/**
 * Data structure describing the properties of a single cell in a Maze
 * 
 * @author Milad Barai
 *
 */
public class MazeCell {
	
	private int mazeX;
	private int mazeY;
	private ArrayList<MazeCell> connectedCells;
	
	public MazeCell(int mazeX, int mazeY){
		//Setting the cell position in Maze
		this.mazeX = mazeX;
		this.mazeY = mazeY;
	}
	
	
	
	/**
	 * Adds a connection from This MazeCell to the {@code connectedTo}
	 * @param connectTo
	 */
	public void connectToCell(MazeCell connectTo){
		
	}
	
	/**
	 * Set's up actual maze connection
	 * @param connectTo
	 */
	private void connectCell(MazeCell connectTo){
		
	}

}
