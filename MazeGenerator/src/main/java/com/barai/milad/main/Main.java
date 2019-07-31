package com.barai.milad.main;

import java.util.Scanner;

import com.barai.milad.converter.ModelToViewConverter;
import com.barai.milad.graphics.MazeVisualizer;
import com.barai.milad.graphics.WindowHandler;
import com.barai.milad.maze.Maze;
import com.barai.milad.maze.MazeGenerator;

public class Main {

	public static void main(String[] args) {
		int windowDim = 1000;
		int cellDim = 100;
		
		WindowHandler wh = new WindowHandler(windowDim, windowDim);
		Maze maze = MazeGenerator.generateMaze(cellDim, cellDim);
		MazeVisualizer m = ModelToViewConverter.mazeToVisualizer(maze, (windowDim-100)/cellDim, 50);
		wh.drawMaze(m);
		
		Scanner sc = new Scanner(System.in);
		if(sc.next().equals("s")) {
			m = ModelToViewConverter.mazeToVisualizer(maze, (windowDim-100)/cellDim, 50, true);
		}
		wh.drawMaze(m);
		

	}

}
