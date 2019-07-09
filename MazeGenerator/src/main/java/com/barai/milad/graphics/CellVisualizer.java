package com.barai.milad.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
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
	private int width;
	private int height;

	boolean left;
	boolean right;
	boolean bottom;
	boolean top;
	
	boolean first;
	boolean last;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4727575049581533821L;

	/**
	 * Constructor for creating a cell visualizer.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 */
	public CellVisualizer(int x, int y, int width, int height,boolean top, boolean right,boolean bottom, boolean left){
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		
		this.width = width;
		this.height = height;
		
		bottomLeft = new Point(x, y);
		bottomRight = new Point(x + width, y);

		topLeft = new Point(x, y + height);
		topRight = new Point(x + width, y + height);
		
	}

	public void paint(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setStroke(new BasicStroke(4));

		if(first){
			graphics2D.setColor(new Color(66,245,147,95));
			graphics2D.fillRect(bottomLeft.x,bottomLeft.y, width, height);
		}
		else if(last){
			graphics2D.setColor(new Color(245,90,66,95));
			graphics2D.fillRect(bottomLeft.x,bottomLeft.y, width, height);
		}
		graphics2D.setColor(Color.BLACK);
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

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
