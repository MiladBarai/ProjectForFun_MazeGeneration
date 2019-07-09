package com.barai.milad.maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.barai.milad.maze.MazeCell;

public class MazeCellTest {

	private static MazeCell midCell;

	private static MazeCell x1y2;
	private static MazeCell x1y0;

	private static MazeCell x2y1;
	private static MazeCell x0y1;

	private static MazeCell x8y3;

	/**
	 * Creating structure:
	 * 
	 * <br/>
	 * ------------x1y2----------- <br/>
	 * -----x0y1 midCell x2y1----- <br/>
	 * ------------x1y0----------- <br/>
	 * <br/>
	 * ...x8y3 <br/>
	 * Where all the Cells are connected except x8y3
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Creating the Cells
		midCell = new MazeCell(1, 1);
		x1y2 = new MazeCell(1, 2);
		x1y0 = new MazeCell(1, 0);
		x2y1 = new MazeCell(2, 1);
		x0y1 = new MazeCell(0, 1);
		x8y3 = new MazeCell(8, 3);

		// Setting up connections
		midCell.connectToCell(x1y0);
		midCell.connectToCell(x1y2);
		midCell.connectToCell(x2y1);
		midCell.connectToCell(x0y1);
	}

	/**
	 * Tests if the connection is set up from MazeCell A->B, from running
	 * A.connectToCell(B)
	 */
	@Test
	public void connectToTest() {
		assertEquals(true, midCell.isConnectedTo(x1y0));
		assertEquals(true, midCell.isConnectedTo(x1y2));
		assertEquals(true, midCell.isConnectedTo(x2y1));
		assertEquals(true, midCell.isConnectedTo(x0y1));
	}

	/**
	 * Tests if the connection is set up dual-linked from MazeCell A->B, from
	 * running A.connectToCell(B) Should also set up connection B->A
	 */
	@Test
	public void dualLinkedConnectionTest() {
		assertEquals(true, x1y0.isConnectedTo(midCell));
		assertEquals(true, x1y2.isConnectedTo(midCell));
		assertEquals(true, x2y1.isConnectedTo(midCell));
		assertEquals(true, x0y1.isConnectedTo(midCell));
	}

	/**
	 * Test that the inputCheck is done for connections to non adjacent cells
	 */
	@Test(expected = IllegalArgumentException.class)
	public void connectionNonAdjacentTest() {
		midCell.connectToCell(x8y3);
	}

	/**
	 * Test that the inputCheck is done for connections to and from the same
	 * cell
	 */
	@Test(expected = IllegalArgumentException.class)
	public void connectionToSameCell() {
		midCell.connectToCell(midCell);
	}

	/**
	 * Test that the inputCheck is done for the Y value in the constructor of
	 * the MazeCell
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructMazeCellNegativeX() {
		new MazeCell(-1, 0);
	}

	/**
	 * Test that the inputCheck is done for the Y value in the constructor of
	 * the MazeCell
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructMazeCellNegativeY() {
		new MazeCell(0, -1);
	}
	
	/**
	 * Test that the connection directions are correctly returned
	 * in a 4 way connection
	 */
	@Test
	public void getConnectionDirections4wayTest(){
		//Top, right, bottom, left all expected to be true
		boolean[] expected = {true, true, true, true};
		assertArrayEquals(expected, midCell.getConnectionDirections());
	}
	
	/**
	 * Test that the connection directions are correctly returned
	 * in a 1 way connection
	 */
	@Test
	public void getConnectionDirections1wayTest(){
		//Top, expected to be true, rest false
		boolean[] expected = {true, false, false, false};
		assertArrayEquals(expected, x1y0.getConnectionDirections());
	}
}
