package com.barai.milad.Graphics;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class CellVisualizer extends JComponent {
	private Point bottomLeft;
	private Point bottomRight;
	private Point topRight;
	private Point topLeft;

	boolean left;
	boolean right;
	boolean bottom;
	boolean top;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4727575049581533821L;

	/**
	 * Default constructor used for prof of concept
	 */
	public CellVisualizer() {
		int x = 0;
		int y = 0;
		int width = 200;
		int height = 200;
		left = true;
		bottom = true;
		right = true;
		top = true;

		bottomLeft = new Point(x, y);
		bottomRight = new Point(x + width, y);

		topLeft = new Point(x, y + height);
		topRight = new Point(x + width, y + height);
	}

	public void paint(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setStroke(new BasicStroke(4));

		if (left) {
			drawFromPointToPoint(g, bottomLeft, topLeft);
		}
		if (right) {
			drawFromPointToPoint(g, bottomRight, topRight);
		}
		if (bottom) {
			drawFromPointToPoint(g, topLeft,topRight);
		}
		if (top) {
			drawFromPointToPoint(g, bottomLeft,bottomRight);
		}

	}

	private void drawFromPointToPoint(Graphics g, Point p1, Point p2) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

}
