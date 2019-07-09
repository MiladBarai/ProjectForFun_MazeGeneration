package com.barai.milad.maze;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MazeTest {

	private static Maze testMaze;
	private static MazeCell x0y1;
	private static int mazeWidth = 10;
	private static int mazeHeight = 10;

	@Before
	public void setUp() throws Exception {
		testMaze = new Maze(mazeWidth, mazeHeight);
		// connect 0,0 and 1,1
		x0y1 = testMaze.getMazeCell(0, 1);
		testMaze.getStartingCell().connectToCell(x0y1);
	}

	/**
	 * Testing that the MazeCells are being created and stored properly as well
	 * as can be returned
	 */
	@Test
	public void getMazeCellWithinRangeTest() {
		MazeCell temp = testMaze.getMazeCell(mazeWidth - 1, mazeHeight - 1);
		assertNotNull(temp);
	}

	/**
	 * Testing that the Maze does not create to many cells and return null if a
	 * cell out of range is being requested
	 */
	@Test
	public void getMazeCellOutOfRangeTest() {
		MazeCell temp = testMaze.getMazeCell(mazeWidth, mazeHeight);
		assertNull(temp);
	}

	/**
	 * Testing that the connected x1y1 cell is not in the returned list as it is
	 * already connected
	 */
	@Test
	public void getConnectableCellsExclConnectedTest() {
		MazeCell starting = testMaze.getStartingCell();
		List<MazeCell> connectables = testMaze.getConnectableCells(starting);
		assertFalse(connectables.contains(x0y1));
	}

	/**
	 * Tests for the correct content in the connectable list of maze cells for
	 * non-connected cells
	 */
	@Test
	public void getConnectableCellsConntentTest() {
		MazeCell starting = testMaze.getStartingCell();
		List<MazeCell> connectables = testMaze.getConnectableCells(starting);
		MazeCell x1y0 = testMaze.getMazeCell(1, 0);
		assertEquals(connectables.size(), 1);
		assertTrue(connectables.contains(x1y0));

	}

	/**
	* Tests for correct content in the connectable list of maze cells for
	* connected cells
	*/
	@Test
	public void getConnectableCellsConntentConnectedTest() {
		MazeCell temp = testMaze.getMazeCell(4, 4);
		
		//Surrounding cells that should be connectbale
		MazeCell x4y5 = testMaze.getMazeCell(4, 5);
		MazeCell x4y3 = testMaze.getMazeCell(4, 3);
		MazeCell x5y4 = testMaze.getMazeCell(5, 4);
		MazeCell x3y4 = testMaze.getMazeCell(3, 4);
		
		ArrayList<MazeCell> expectedList = new ArrayList<MazeCell>(Arrays.asList(x4y5,x4y3,x5y4,x3y4));
		List<MazeCell> actualList = testMaze.getConnectableCells(temp);
		assertTrue(actualList.containsAll(expectedList));
		
	}
}
