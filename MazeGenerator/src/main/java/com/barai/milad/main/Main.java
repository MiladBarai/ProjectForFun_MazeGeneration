package com.barai.milad.main;

import com.barai.milad.converter.ModelToViewConverter;
import com.barai.milad.graphics.MazeVisualizer;
import com.barai.milad.graphics.WindowHandler;
import com.barai.milad.maze.MazeGenerator;

public class Main {

	public static void main(String[] args) {
		int windowDim = 500;
		int cellDim = 30;
		
		WindowHandler wh = new WindowHandler(windowDim, windowDim);
		MazeVisualizer m = ModelToViewConverter.mazeToVisualizer(MazeGenerator.generateMaze(cellDim, cellDim), (windowDim-100)/cellDim, 50);
		
		wh.drawMaze(m);

	}

}
