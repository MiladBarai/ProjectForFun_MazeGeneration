package com.barai.milad.maze;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MazeGeneratorTest {
	
	private static Maze testMaze;
	private static int mazeWidth = 3;
	private static int mazeHeight = 3;
	
	@Before
	public void setUp() throws Exception {
		testMaze = MazeGenerator.generateMaze(mazeWidth, mazeHeight);
	}

	/**
	 * Tests that all of the cells are connected in the Maze
	 */
	@Test
	public void allCellsConnectedTest() {
		Set<MazeCell> allCells = testMaze.getMazeCells();
		for(MazeCell cell :allCells){
			if(cell.getConnectionsCount() <= 0){
				fail("No connections for one of the Cells");
			}
		}
		
	}

}
