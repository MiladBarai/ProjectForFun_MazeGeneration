package com.barai.milad.maze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Generator for creating Mazes
 * 
 * @author Milad Barai
 *
 */
public class MazeGenerator {

	/**
	 * Disable default constructor, Class will only have static functions
	 */
	private MazeGenerator() {

	}

	/**
	 * Generating a maze with random order of cell connections.
	 * 
	 */
	public static Maze generateMaze(int cellWidth, int cellHeight) {
		Maze maze = new Maze(cellWidth, cellHeight);
		connectMazePath(maze);

		return maze;
	}

	/**
	 * Setup all the MazeCell connection in the Maze in an random order and ensures that there is a path from end to start
	 * 
	 * @param startingCell
	 * @param cellHeigth
	 * @param cellWidth
	 */
	private static void connectMazePath(Maze maze) {

		Stack<MazeCell> backTracking = new Stack<MazeCell>();
		HashSet<MazeCell> visited = new HashSet<MazeCell>();
		visited.add(maze.getStartingCell());
		Random random = new Random();

		MazeCell cellPointer = maze.getStartingCell();
		MazeCell nextCell;

		int expectedVisits = maze.getMazeCellCount();
		int nextCellIndex;

		List<MazeCell> connOptions;

		while (expectedVisits > visited.size()) {
			connOptions = maze.getConnectableCells(cellPointer);
			connOptions = removeVisitedFromList(connOptions, visited);
			if (connOptions.isEmpty()) {
				cellPointer = backTracking.pop();
			} else {
				nextCellIndex = random.nextInt(connOptions.size());
				nextCell = connOptions.get(nextCellIndex);
				visited.add(nextCell);
				backTracking.push(cellPointer);
				cellPointer.connectToCell(nextCell);
				cellPointer = nextCell;
			}
		}
	}

	/**
	 * Removes all the visited MazeCells described by {@code visited} from
	 * {@code cells}
	 * 
	 * @param cells
	 * @param visited
	 * @return new list with the visited values removed
	 */
	private static List<MazeCell> removeVisitedFromList(List<MazeCell> cells, HashSet<MazeCell> visited) {

		ArrayList<MazeCell> result = new ArrayList<MazeCell>();

		for (MazeCell cell : cells) {
			if (!visited.contains(cell))
				result.add(cell);
		}

		return result;
	}
}
