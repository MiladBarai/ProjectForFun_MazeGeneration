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
	
	public Maze(MazeCell startingCell, MazeCell endingCell, HashMap<Point, MazeCell> pointToMazeCell){
		this.startingCell = startingCell;
		this.endingCell = endingCell;
		this.pointToMazeCell = pointToMazeCell;
		setupMazeCells(pointToMazeCell);
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
	
	public MazeCell getMazeCell(int mazeX, int mazeY){
		Point key = new Point(mazeX, mazeY);
		return pointToMazeCell.get(key);
	}
	

	private void setupMazeCells(HashMap<Point, MazeCell> pointToMazeCell) {
		Set<Point> keys = pointToMazeCell.keySet();
		mazeCells = new HashSet<MazeCell>();
		for(Point key : keys){
			mazeCells.add(pointToMazeCell.get(key));
		}
	}

}
