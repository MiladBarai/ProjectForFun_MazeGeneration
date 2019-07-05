package com.barai.milad.Main;

import com.barai.milad.Graphics.CellVisualizer;
import com.barai.milad.Graphics.WindowHandler;

public class Main {

	public static void main(String[] args) {
		WindowHandler wh = new WindowHandler(500, 500);
		CellVisualizer test = new CellVisualizer();
		wh.drawCell(test);

	}

}
