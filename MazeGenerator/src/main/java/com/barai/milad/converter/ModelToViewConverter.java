package com.barai.milad.converter;

import java.util.ArrayList;

import javax.swing.JComponent;

import com.barai.milad.graphics.CellVisualizer;
import com.barai.milad.graphics.MazeVisualizer;
import com.barai.milad.maze.Maze;
import com.barai.milad.maze.MazeCell;

public class ModelToViewConverter {

	/**
	 * Class is to have static only functions, disable default constructor
	 */
	private ModelToViewConverter() {

	}

	/**
	 * Converts the {@code maze} into a MazeVisualizer with {@code cellSize} and
	 * a {@code padding} from the frame
	 * 
	 * @param maze
	 * @param cellSize
	 * @param padding
	 * @return MazeVisaulizer representation of the input maze
	 */
	public static MazeVisualizer mazeToVisualizer(Maze maze, int cellSize, int padding) {
		ArrayList<JComponent> components = new ArrayList<JComponent>();
		for (MazeCell cell : maze.getMazeCells()) {
			components.add(cellToVisualizer(cell, cellSize, padding));
		}

		MazeVisualizer result = new MazeVisualizer(components);

		return result;
	}

	/**
	 * Converts the {@code cell} into a CellVisualizer with {@code cellSize}
	 * 
	 * @param cell
	 * @param cellSize
	 * @return cellVisualizer representation of the input cell
	 */
	public static CellVisualizer cellToVisualizer(MazeCell cell, int cellSize) {
		return cellToVisualizer(cell, cellSize, 0);
	}

	private static CellVisualizer cellToVisualizer(MazeCell cell, int cellSize, int padding) {
		boolean[] connDir = cell.getConnectionDirections();

		CellVisualizer result = new CellVisualizer(cell.getMazeX() * cellSize + padding,
				cell.getMazeY() * cellSize + padding, cellSize, cellSize, !connDir[0], !connDir[1], !connDir[2],
				!connDir[3]);
		
		result.setFirst(cell.isFirst());
		result.setLast(cell.isLast());
			

		return result;
	}

}
