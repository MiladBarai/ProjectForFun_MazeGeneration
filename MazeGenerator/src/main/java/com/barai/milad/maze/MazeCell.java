package com.barai.milad.maze;

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

	public MazeCell(int mazeX, int mazeY) {
		// Setting the cell position in Maze
		this.mazeX = mazeX;
		this.mazeY = mazeY;
		connectedCells = new ArrayList<MazeCell>();
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

		if (deltaX > 1 || deltaY > 1) {
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

}