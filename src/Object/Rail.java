package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Rail {
	private int x;
	private int y;
	private int size;
	private GeneralPath r;
	private GeneralPath connector;
	private GeneralPath middle;
	private Graphics2D g2d;
	
	public Rail(int size, int x, int y, Graphics2D g2d) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.g2d = g2d;
		this.r = new GeneralPath();
		this.connector = new GeneralPath();
		this.middle = new GeneralPath();
		this.drawRail();
		this.drawMiddle();
		this.drawConnector();
	}
	
	public void drawMiddle() {
		middle.moveTo(x+31, y-4);
		middle.lineTo(x+35, y-4);
		middle.lineTo(x+35, y-96);
		middle.lineTo(x+31, y-96);
		middle.lineTo(x+31, y-4);
		
		middle.moveTo(x+63, y-4);
		middle.lineTo(x+67, y-4);
		middle.lineTo(x+67, y-96);
		middle.lineTo(x+63, y-96);
		middle.lineTo(x+63, y-4);
		
		middle.moveTo(x+96, y-4);
		middle.lineTo(x+100, y-4);
		middle.lineTo(x+100, y-96);
		middle.lineTo(x+96, y-96);
		middle.lineTo(x+96, y-4);
	}
	
	public void drawConnector() {
		connector.moveTo(x, y-10);
		connector.lineTo(x+100, y-10);
		connector.lineTo(x+100, y-15);
		connector.lineTo(x, y-15);
		
		connector.moveTo(x, y-90);
		connector.lineTo(x+100, y-90);
		connector.lineTo(x+100, y-85);
		connector.lineTo(x, y-85);
	}
	
	public void drawRail() {
		r.moveTo(x,y);
		r.lineTo(x+size,y);
		r.lineTo(x+size,y-size);
		r.lineTo(x, y-size);
		r.lineTo(x,y);
	}
	
	public void draw() {
		this.g2d.setColor(new Color(161, 46, 20));
		this.g2d.fill(r);
		
		this.g2d.setColor(new Color(162, 162, 162));
		this.g2d.fill(connector);
		this.g2d.fill(middle);
		
//		this.g2d.setColor(Color.black);
//		this.g2d.draw(connector);
//		this.g2d.draw(middle);
	}
}
