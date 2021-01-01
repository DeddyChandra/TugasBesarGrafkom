package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class KeretaHead {
	private Color color;
	private Graphics2D g2d;
	private int x, y;
	private GeneralPath keretaBody;
	private GeneralPath keretaLower;
	private GeneralPath keretaDoor;
	private GeneralPath keretaWindows;
	private GeneralPath keretaLine;
	private Color bodyColor, lineColor;
	private int panjang;
	private Image img;
	
	public KeretaHead(Color bodyColor, Color lineColor, int x, int y, Graphics2D g2d) {
		this.x = x;
		this.y = y;
		this.g2d = g2d;
		this.keretaBody = new GeneralPath();
		this.keretaLower = new GeneralPath();
		this.keretaDoor = new GeneralPath();
		this.keretaWindows = new GeneralPath();
		this.keretaLine = new GeneralPath();
		this.bodyColor = bodyColor;
		this.lineColor = lineColor;
		
		URL imgUrl = getClass().getClassLoader().getResource("img/smrtTop.png");
		if(imgUrl == null) {
			System.err.println("Couldn't find file: img/smrt.png");
		}
		else {
			try {
				img = ImageIO.read(imgUrl);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		drawKeretaBody();
		drawKeretaLower();
		drawDoor();
		drawWindows();
		drawLine();
	}
	
	public void drawWheel() {
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+203,y-32,20,20);
//		this.g2d.setColor(Color.white);
		this.g2d.drawOval(x+203,y-32,20,20);
		
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+180,y-32,20,20);
//		this.g2d.setColor(Color.white);
		this.g2d.drawOval(x+180,y-32,20,20);
		
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+72,y-32,20,20);
//		this.g2d.setColor(Color.white);
		this.g2d.drawOval(x+72,y-32,20,20);
		
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+49,y-32,20,20);
//		this.g2d.setColor(Color.white);
		this.g2d.drawOval(x+49,y-32,20,20);
	}
	
	public void drawLine(){
		keretaLine.moveTo(x+10, y-53);
		keretaLine.lineTo(x+10, y-50);
		keretaLine.lineTo(x+280, y-50);
		keretaLine.lineTo(x+280, y-53);
		
		keretaLine.moveTo(x+10, y-47);
		keretaLine.lineTo(x+11, y-44);
		keretaLine.lineTo(x+280, y-44);
		keretaLine.lineTo(x+280, y-47);
		
		keretaLine.moveTo(x+281,y-53);
		keretaLine.lineTo(x+295,y-72);
		keretaLine.lineTo(x+294,y-68);
		keretaLine.lineTo(x+281,y-50);
		
		keretaLine.moveTo(x+281,y-47);
		keretaLine.lineTo(x+295,y-66);
		keretaLine.lineTo(x+294,y-62);
		keretaLine.lineTo(x+281,y-44);
	}
	
	public void drawWindows() {
		keretaWindows.moveTo(x+9, y-90);
		keretaWindows.lineTo(x+13, y-63);
		keretaWindows.lineTo(x+38, y-63);
		keretaWindows.lineTo(x+34, y-90);
		keretaWindows.lineTo(x+9, y-90);
		
		keretaWindows.moveTo(x+42, y-90);
		keretaWindows.lineTo(x+46, y-63);
		keretaWindows.lineTo(x+85, y-63);
		keretaWindows.lineTo(x+81, y-90);
		keretaWindows.lineTo(x+43, y-90);
		
		keretaWindows.moveTo(x+90, y-90);
		keretaWindows.lineTo(x+94, y-63);
		keretaWindows.lineTo(x+125, y-63);
		keretaWindows.lineTo(x+121, y-90);
		keretaWindows.lineTo(x+90, y-90);
		
		keretaWindows.moveTo(x+163, y-90);
		keretaWindows.lineTo(x+167, y-63);
		keretaWindows.lineTo(x+207, y-63);
		keretaWindows.lineTo(x+203, y-90);
		keretaWindows.lineTo(x+163, y-90);
		
		keretaWindows.moveTo(x+211, y-90);
		keretaWindows.lineTo(x+215, y-63);
		keretaWindows.lineTo(x+266, y-64);
		keretaWindows.lineTo(x+220, y-91);
		keretaWindows.lineTo(x+211, y-90);
		
		keretaWindows.moveTo(x+266, y-64);
		keretaWindows.lineTo(x+281, y-89);
		keretaWindows.lineTo(x+241, y-120);
		keretaWindows.lineTo(x+220, y-91);
	}
	
	public void drawDoor() {
		keretaDoor.moveTo(x+136,y-30);
		keretaDoor.lineTo(x+128,y-90);
		keretaDoor.lineTo(x+156,y-90);
		keretaDoor.lineTo(x+165,y-30);
	}
	
	public void drawKeretaLower() {
		keretaLower.moveTo(x+12,y-34);
		keretaLower.lineTo(x+14,y-21);
		keretaLower.lineTo(x+221,y-21);
		keretaLower.lineTo(x+258, y-21);
		keretaLower.lineTo(x+282, y-34);
	}
	
	public void drawKeretaBody() {
		keretaBody.moveTo(x,y-98);
		keretaBody.lineTo(x+12,y-31);
		keretaBody.lineTo(x+218,y-31);
		keretaBody.lineTo(x+282,y-34);
		keretaBody.lineTo(x+280,y-56);
		keretaBody.lineTo(x+209,y-98);
		keretaBody.lineTo(x,y-98);
		keretaBody.lineTo(x+24,y-129);
		keretaBody.lineTo(x+230,y-129);
		keretaBody.lineTo(x+209,y-98);
		
		keretaBody.moveTo(x+230,y-129);
		keretaBody.lineTo(x+295,y-77);
		keretaBody.lineTo(x+280,y-56);
		keretaBody.lineTo(x+209,y-98);
		
		keretaBody.moveTo(x+295,y-77);
		keretaBody.lineTo(x+296,y-54);
		keretaBody.lineTo(x+282,y-34);
		keretaBody.lineTo(x+280,y-56);
	
	}
	
	public void draw() {
		g2d.setColor(bodyColor);
		g2d.fill(keretaBody);
		g2d.setColor(Color.black);
		g2d.draw(keretaBody);
		
		g2d.setColor(bodyColor);
		g2d.fill(keretaDoor);
		
		g2d.setColor(Color.black);
		g2d.fill(keretaWindows);
		g2d.setColor(new Color(140,140,140));
		g2d.draw(keretaWindows);
		
		g2d.setColor(lineColor);
		g2d.fill(keretaLine);
//		g2d.setColor(Color.black);
		g2d.draw(keretaLine);
		
		g2d.setColor(Color.black);
		g2d.draw(keretaDoor);
		
		drawWheel();	
		
		g2d.setColor(new Color(140,140,140));
		g2d.fill(keretaLower);
		g2d.setColor(Color.black);
		g2d.draw(keretaLower);
		
		g2d.drawImage(img, x+47, y-128, null); 
	}
}
