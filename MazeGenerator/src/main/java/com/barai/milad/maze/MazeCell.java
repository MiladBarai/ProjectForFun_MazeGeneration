package com.barai.milad.maze;

import java.awt.Point;
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
	private boolean first;
	private boolean last;

	public MazeCell(int mazeX, int mazeY) {

		if (mazeX < 0 || mazeY < 0) {
			throw new IllegalArgumentException(
					"input to MazeCell constructor cannot be negative, input values:[" + mazeX + "," + mazeY + "]");
		}

		// Setting the cell position in Maze
		this.mazeX = mazeX;
		this.mazeY = mazeY;
		connectedCells = new ArrayList<MazeCell>();
	}

	public MazeCell(Point p) {
		this((int) p.getX(), (int) p.getY());
	}

	/**
	 * Checks if the MazeCell is connectedTo the input cell
	 * 
	 * @param connectedTo
	 * @return
	 */
	public boolean isConnectedTo(MazeCell connectedTo) {
		return connectedCells.contains(connectedTo);
	}

	/**
	 * Adds a connection from This MazeCell to the {@code connectedTo}
	 * 
	 * @param connectTo
	 */
	public void connectToCell(MazeCell connectTo) {
		/*
		 * Input validation
		 */
		int deltaX = Math.abs(this.mazeX - connectTo.mazeX);
		int deltaY = Math.abs(this.mazeY - connectTo.mazeY);

		if (connectTo == null || this.equals(connectTo)) {
			throw new IllegalArgumentException("ConnectTo cannot be null or same MazeCell");
		}

		if (deltaX > 1 || deltaY > 1 || (deltaX == 1 && deltaY == 1)) {
			throw new IllegalArgumentException("MazeCell connection out of range: [" + this.mazeX + "," + this.mazeY
					+ "] -> [" + connectTo.mazeX + "," + connectTo.mazeY + "]");
		}

		/*
		 * Logical execution
		 */
		connectCell(connectTo);
		connectTo.connectCell(this);
	}

	/**
	 * Set's up actual maze connection
	 * 
	 * @param connectTo
	 */
	private void connectCell(MazeCell connectTo) {
		connectedCells.add(connectTo);
	}

	/**
	 * @return the amount of connected cells
	 */
	public int getConnectionsCount() {
		return connectedCells.size();
	}

	/**
	 * 
	 * Gets an array containing the connection direction booleans. telling if
	 * there is a connection going up, right, down or left in that order
	 * 
	 * @return direction boolean array
	 */
	public boolean[] getConnectionDirections() {
		boolean[] result = new boolean[4];
		int deltaX;
		int deltaY;
		for(MazeCell cell: connectedCells){
			deltaX = cell.mazeX-mazeX;
			deltaY = cell.mazeY-mazeY;
			if(deltaY == -1){
				result[0] = true;
			}
			else if(deltaX == 1){
				result[1] = true;
			}
			else if(deltaY == 1){
				result[2] = true;
			}
			else if(deltaX == -1){
				result[3] = true;
			}
		}
		
		return result;
	}

	public int getMazeX() {
		return mazeX;
	}

	public int getMazeY() {
		return mazeY;
	}

	public ArrayList<MazeCell> getConnectedCells() {
		return connectedCells;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
	
}
