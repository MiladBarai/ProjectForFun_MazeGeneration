package com.barai.milad.maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
	private List<MazeCell> solution;

	public Maze(int mazeWidth, int mazeHeight) {
		mazeCells = new HashSet<MazeCell>();
		pointToMazeCell = new HashMap<Point, MazeCell>();

		Point tempPoint;
		MazeCell tempCell;

		for (int i = 0; i < mazeWidth; i++) {
			for (int j = 0; j < mazeHeight; j++) {
				tempPoint = new Point(i, j);
				tempCell = new MazeCell(tempPoint);
				mazeCells.add(tempCell);
				pointToMazeCell.put(tempPoint, tempCell);
			}
		}

		startingCell = pointToMazeCell.get(new Point(0, 0));
		endingCell = pointToMazeCell.get(new Point(mazeWidth - 1, mazeHeight - 1));
		
		startingCell.setFirst(true);
		endingCell.setLast(true);
	}

	public MazeCell getStartingCell() {
		return startingCell;
	}

	public MazeCell getEndingCell() {
		return endingCell;
	}

	public Set<MazeCell> getMazeCells() {
		return mazeCells;
	}

	/**
	 * Get total MazeCell count
	 * 
	 * @return total MazeCell count
	 */
	public int getMazeCellCount() {
		return mazeCells.size();
	}
	
	public void setSolution(List<MazeCell> solution) {
		this.solution = solution;
	}
	
	public List<MazeCell> getSolution() {
		return solution;
	}

	/**
	 * Get all the MazeCells in the direct vicinity that can setup a connection
	 * to the to the MazeCell input {@code midpoint} as a List.<br/>
	 * 
	 * @param midPoint
	 * @return a List with MazeCells that can setup a connection to
	 *         {@code midpoint} starting from the top, ordered clockwise
	 */
	public List<MazeCell> getConnectableCells(MazeCell midPoint) {
		ArrayList<MazeCell> connectableCells = new ArrayList<MazeCell>();
		MazeCell temp;

		for (int i = -1; i < 2; i++) {

			if (i != 0) {
				// Get Y axis Cells within the range
				temp = getMazeCell(midPoint.getMazeX(), midPoint.getMazeY() + i);
				if (temp != null && !midPoint.isConnectedTo(temp)) {
					connectableCells.add(temp);
				}

				// Get X axis Cells within the range
				temp = getMazeCell(midPoint.getMazeX() - i, midPoint.getMazeY());
				if (temp != null && !midPoint.isConnectedTo(temp)) {
					connectableCells.add(temp);
				}
			}
		}

		return connectableCells;
	}

	/**
	 * Get maze cell in specified {@code mazeX}, {@code mazeY}. If there is no
	 * maze cell in specified range null is returned
	 * 
	 * @param mazeX
	 * @param mazeY
	 * @return MazeCell in the specified x,y OR null
	 */
	public MazeCell getMazeCell(int mazeX, int mazeY) {
		Point key = new Point(mazeX, mazeY);
		return pointToMazeCell.get(key);
	}

}
