package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class MobilRight {
	private Color color;
	private Graphics2D g2d;
	private int x, y;
	private GeneralPath mobilBody;
	private GeneralPath mobilTop;
	private GeneralPath mobilWindow;
	private GeneralPath mobilWheel;
	private int panjang;
	
	public MobilRight(Color color,int panjang, int x, int y, Graphics2D g2d) {
		this.color = color;
		this.panjang = panjang;
		this.g2d = g2d;
		this.x = x;
		this.y = y;
		this.mobilBody = new GeneralPath();
		this.mobilTop = new GeneralPath();
		this.mobilWindow = new GeneralPath();
		this.mobilWheel = new GeneralPath();
		drawMobilBody();
		drawMobilTop();
		drawMobilWindow();
//		drawMobilWheel();
	}
	
	public void drawMobilBody() {
		mobilBody.moveTo(x, y-10);
		mobilBody.lineTo(x+panjang, y-10);
		mobilBody.lineTo(x+panjang, y-50);
		mobilBody.lineTo(x, y-50);
		mobilBody.lineTo(x, y-10);
		mobilBody.moveTo(x+panjang, y-10);
		mobilBody.lineTo(x+panjang+15, y-60);
		mobilBody.lineTo(x+panjang+15, y-60-50);
		mobilBody.lineTo(x+15, y-60-50);
		mobilBody.lineTo(x, y-50);
		mobilBody.moveTo(x+panjang+15, y-60-50);
		mobilBody.lineTo(x+panjang, y-50);
	}
	
	public void drawMobilTop() {
		mobilTop.moveTo(x+20, y-65);
		mobilTop.lineTo(x+130,y-65);
		mobilTop.lineTo(x+100,y-95);
		mobilTop.lineTo(x+20,y-95);
		mobilTop.lineTo(x+20, y-65);
		mobilTop.moveTo(x+130,y-65);
		mobilTop.lineTo(x+130+10,y-95);
		mobilTop.lineTo(x+100+10,y-125);
		mobilTop.lineTo(x+20+10,y-125);
		mobilTop.lineTo(x+20,y-95);
		mobilTop.moveTo(x+100+10,y-125);
		mobilTop.lineTo(x+100,y-95);
	}
	
	public void drawMobilWindow() {
		mobilWindow.moveTo(x+130-5,y-70);
		mobilWindow.lineTo(x+130+10-5, y-100);
		mobilWindow.lineTo(x+100+10+5,y-120);
		mobilWindow.lineTo(x+100+5,y-90);
		mobilWindow.lineTo(x+130-5,y-70);
		
		mobilWindow.moveTo(x+30,y-65);
		mobilWindow.lineTo(x+30,y-90);
		mobilWindow.lineTo(x+60,y-90);
		mobilWindow.lineTo(x+60,y-65);
		mobilWindow.lineTo(x+30,y-65);
		
		mobilWindow.moveTo(x+70,y-65);
		mobilWindow.lineTo(x+120,y-65);
		mobilWindow.lineTo(x+90,y-90);
		mobilWindow.lineTo(x+70,y-90);
		mobilWindow.lineTo(x+70,y-65);
	}
	
	public void drawMobilWheel() {
//		mobilWheel.moveTo(x+10, y);
//		mobilWheel.lineTo(x+50, y);
//		mobilWheel.lineTo(x+50, y-40);
//		mobilWheel.lineTo(x+10, y-40);
//		mobilWheel.lineTo(x+10, y);
//		
//		mobilWheel.moveTo(x+panjang-10,y);
//		mobilWheel.lineTo(x+panjang-50, y);
//		mobilWheel.lineTo(x+panjang-50, y-40);
//		mobilWheel.lineTo(x+panjang-10, y-40);
//		mobilWheel.lineTo(x+panjang-10, y);
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+10,y-40,50,50);
		this.g2d.fillOval(x+panjang-60,y-40,50,50);
		this.g2d.setColor(Color.white);
		this.g2d.fillOval(x+25,y-25,20,20);
		this.g2d.fillOval(x+panjang-45,y-25,20,20);
	}
	
	public void draw() {
		g2d.setColor(color);
		g2d.fill(mobilBody);
		g2d.setColor(Color.BLACK);
		g2d.draw(mobilBody);
		g2d.setColor(Color.white);
		g2d.fill(mobilTop);
		g2d.setColor(Color.BLACK);
		g2d.draw(mobilTop);
		g2d.setColor(Color.BLACK);
		g2d.fill(mobilWindow);
		g2d.fill(mobilWheel);
		g2d.setColor(Color.white);
//		g2d.draw(mobilWheel);
		this.drawMobilWheel();
	}
}
