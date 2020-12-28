package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Road {
	private int x;
	private int y;
	private int size;
	private GeneralPath r;
	private GeneralPath middle;
	private Graphics2D g2d;
	
	public Road(int size, int x, int y, Graphics2D g2d) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.g2d = g2d;
		this.r = new GeneralPath();
		this.middle = new GeneralPath();
		this.drawRoad();
		this.drawMiddle();
	}
	
	public void drawMiddle() {
		middle.moveTo(x, y-size/2-5);
		middle.lineTo(x+20, y-size/2-5);
		middle.lineTo(x+20, y-size/2+5);
		middle.lineTo(x, y-size/2+5);
		middle.lineTo(x, y-size/2-5);
		
		middle.moveTo(x+size, y-size/2-5);
		middle.lineTo(x+size-20, y-size/2-5);
		middle.lineTo(x+size-20, y-size/2+5);
		middle.lineTo(x+size, y-size/2+5);
		middle.lineTo(x+size, y-size/2-5);
	}
	
	public void drawRoad() {
		r.moveTo(x,y);
		r.lineTo(x+size,y);
		r.lineTo(x+size,y-size);
		r.lineTo(x, y-size);
		r.lineTo(x,y);
	}
	
	public void draw() {
		this.g2d.setColor(new Color(102, 102, 102));
		this.g2d.fill(r);
		this.g2d.setColor(Color.WHITE);
		this.g2d.fill(middle);
	}
}
