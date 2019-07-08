package com.barai.milad.maze;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.awt.Point;

/**
 * Data structure for describing an entire maze
 * 
 * @author Milad Barai
 *
 */
public class Maze {
	
	private MazeCell startingCell;
	private MazeCell endingCell;
	private HashSet<MazeCell> mazeCells;
	private HashMap<Point, MazeCell> pointToMazeCell;

	public Maze(int mazeWidth, int mazeHeight){
		mazeCells = new HashSet<MazeCell>();
		HashMap<Point, MazeCell> pointToMazeCell = new HashMap<Point, MazeCell>();
		
		Point tempPoint;
		MazeCell tempCell;
		
		for(int i=0; i<mazeWidth; i++){
			for(int j=0; j<mazeHeight; j++){
				tempPoint = new Point(i,j);
				tempCell = new MazeCell(tempPoint);
				mazeCells.add(tempCell);
				pointToMazeCell.put(tempPoint, tempCell);
			}
		}
		
		startingCell = pointToMazeCell.get(new Point(0,0));
		endingCell = pointToMazeCell.get(new Point(mazeWidth-1, mazeHeight-1));
	}

	public MazeCell getStartingCell() {
		return startingCell;
	}

	public MazeCell getEndingCell() {
		return endingCell;
	}

	public HashSet<MazeCell> getMazeCells() {
		return mazeCells;
	}
	
	/**
	 *returns the total amount of cells in the maze
	 * @return
	 */
	public int getMazeCellCount(){
		return mazeCells.size();
	}
	
	public MazeCell getMazeCell(int mazeX, int mazeY){
		Point key = new Point(mazeX, mazeY);
		return pointToMazeCell.get(key);
	}
	
}
