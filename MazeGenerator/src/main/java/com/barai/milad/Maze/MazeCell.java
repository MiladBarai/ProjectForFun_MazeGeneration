package com.barai.milad.Maze;

import java.util.ArrayList;

/**
 * Data structure describing the properties of a single cell in a Maze
 * 
 * @author Milad Barai
 *
 */
public class MazeCell {
	
	int mazeX;
	int mazeY;
	ArrayList<MazeCell> connectedCells;
	
	boolean topWall;
	boolean bottomWall;
	boolean rightWall;
	boolean leftWall;
	
	public MazeCell(int mazeX, int mazeY){
		//Setting the cell poisition in Maze
		this.mazeX = mazeX;
		this.mazeY = mazeY;
		
		//Setting the walls of the maze to default true
		topWall = true;     
		bottomWall = true;  
		rightWall = true;   
		leftWall = true;		
	}
	
	
	
	/**
	 * Adds a connection from This MazeCell to the {@code connectedTo}
	 * @param connectTo
	 */
	public void connectToCell(MazeCell connectTo){
		
	}
	
	/**
	 * Set's up actuall maze connection
	 * @param connectTo
	 */
	private void connectCell(MazeCell connectTo){
		
	}
	
	/**
	 * remove walls from the mazeConnections
	 */
	private void removeWallFromConnection(){
		
	}

}
