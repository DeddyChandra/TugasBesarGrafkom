package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class Pohon {
	private int x;
	private int y;
	private int tinggi;
	private GeneralPath batang;
	private GeneralPath daun;
	private Graphics2D g2d;
	private int batangWidth;
	
	public Pohon(int tinggi, int x, int y, Graphics2D g2d) {
		this.tinggi = tinggi;
		this.x = x;
		this.y = y;
		this.g2d = g2d;
		batang = new GeneralPath();
		daun = new GeneralPath();
		batangWidth = 40;
		drawBatang();
		drawDaun();
	}
	
	public void drawBatang() {
		batang.moveTo(x+batangWidth/2,y);
		batang.lineTo(x+batangWidth+batangWidth/2, y);
		batang.lineTo(x+batangWidth+batangWidth/2, y-batangWidth);
		batang.lineTo(x+batangWidth/2,y-batangWidth);
		batang.lineTo(x+batangWidth/2, y);
		batang.moveTo(x+batangWidth+batangWidth/2, y-batangWidth);
		batang.lineTo(x+batangWidth+batangWidth/3+batangWidth/2, y-batangWidth-batangWidth/1.5);
		batang.lineTo(x+batangWidth+batangWidth/3+batangWidth/2, y+batangWidth-batangWidth-batangWidth/1.5);
		batang.lineTo(x+batangWidth+batangWidth/2, y);
//		batang.lineTo(x+batangWidth, y+batangWidth);
	}
	
	public void drawDaun() {
		daun.moveTo(x, y-batangWidth);
		daun.lineTo(x+batangWidth+batangWidth, y-batangWidth);
		daun.lineTo(x+batangWidth+batangWidth, y-tinggi-batangWidth);
		daun.lineTo(x, y-tinggi-batangWidth);
		daun.lineTo(x, y-batangWidth);
		daun.moveTo(x+batangWidth+batangWidth, y-batangWidth);
		daun.lineTo(x+batangWidth+batangWidth+batangWidth/2, y-batangWidth-batangWidth);
		daun.lineTo(x+batangWidth+batangWidth+batangWidth/2, y-tinggi-batangWidth-batangWidth);
		daun.lineTo(x+batangWidth/2, y-tinggi-batangWidth-batangWidth);
		daun.lineTo(x, y-tinggi-batangWidth);
		daun.moveTo(x+batangWidth+batangWidth+batangWidth/2, y-tinggi-batangWidth-batangWidth);
		daun.lineTo(x+batangWidth+batangWidth, y-tinggi-batangWidth);
	}
	
	public void draw() {
		g2d.setColor(new Color(160,82,45));
		g2d.fill(batang);
//		g2d.setColor(new Color(139,69,19));
		g2d.setColor(Color.black);
		g2d.draw(batang);
		g2d.setColor(new Color(154,205,50));
		g2d.fill(daun);
		g2d.setColor(new Color(0,100,0));
		g2d.draw(daun);
	}
}
