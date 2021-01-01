package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Chicken {
	private int x;
	private int y;
	private int width;
	private double height;
	private int miring;
	private GeneralPath hat;
	private GeneralPath legR;
	private GeneralPath legL;
	private GeneralPath legRUp;
	private GeneralPath body;
	private GeneralPath bodyL;
	private GeneralPath bodyF;
	private GeneralPath wingL;
	private GeneralPath wingR;
	private Graphics2D g2d;
	
	public Chicken(int size, int x, int y, Graphics2D g2d) {
		this.x = x;
		this.y = y;
		this.width = size;
		this.height = 1.4 * size;
		this.miring = 5;
		this.g2d = g2d;
		this.hat = new GeneralPath();
		this.legR = new GeneralPath();
		this.legRUp = new GeneralPath();
		this.legL = new GeneralPath();
		this.body = new GeneralPath();
		this.bodyL = new GeneralPath();
		this.bodyF = new GeneralPath();
		this.wingL = new GeneralPath();
		this.wingR = new GeneralPath();
		this.drawLegR();
		this.drawLegRUp();
		this.drawLegL();
		this.drawBody();
		this.drawBodyL();
		this.drawBodyF();
		this.drawWingL();
		this.drawWingR();
		this.drawHat();
//		this.background();
	}
	
	public void background() {
		g2d.setColor(new Color(34,139,34));
		g2d.fillRect(100,100,500,500);
	}
	
	public void drawLegR() {
		legR.moveTo(x+83, y-20);
		legR.lineTo(x+76, y-22);
		legR.lineTo(x+70, y-18);
		legR.lineTo(x+66, y-18);
		legR.lineTo(x+70, y-22);
		legR.lineTo(x+62, y-23);
		legR.lineTo(x+47, y-10);
		legR.lineTo(x+65, y-7);
		legR.lineTo(x+83, y-20);
		legR.moveTo(x+47, y-10);
		legR.lineTo(x+47, y-3);
		legR.lineTo(x+65, y);//line to a
		legR.lineTo(x+83, y-13);
		legR.lineTo(x+83, y-20);
		legR.moveTo(x+65, y);
		legR.lineTo(x+65, y-7);// a to a
	
	}
	
	public void drawHat() {
		hat.moveTo(x+42, y-115);
		hat.lineTo(x+58, y-111);
		hat.lineTo(x+58, y-123);
		hat.lineTo(x+42, y-127);
		hat.lineTo(x+42, y-115);
		
		hat.moveTo(x+42, y-127);
		hat.lineTo(x+56, y-138);
		hat.lineTo(x+71, y-134);
		hat.lineTo(x+58, y-123);
		
		hat.moveTo(x+58, y-111);
		hat.lineTo(x+71, y-123);
		hat.lineTo(x+71, y-134);
		hat.lineTo(x+58, y-123);
	}
	
	public void drawLegRUp() {
		legRUp.moveTo(x+56, y-12);
		legRUp.lineTo(x+63, y-11);
		legRUp.lineTo(x+63, y-21);
		legRUp.lineTo(x+56, y-23);
		legRUp.lineTo(x+56, y-12);
		legRUp.moveTo(x+63, y-11);
		legRUp.lineTo(x+66, y-13);
		legRUp.lineTo(x+66, y-23);
		legRUp.lineTo(x+63, y-21);
	}
	
	public void drawLegL() {
		legL.moveTo(x+22,y-15);
		legL.lineTo(x+41,y-11);
		legL.lineTo(x+50,y-23);
		legL.lineTo(x+32,y-26);
		legL.lineTo(x+22,y-15);
		legL.lineTo(x+22,y-11);
		legL.lineTo(x+40,y-6);
		legL.lineTo(x+40,y-6);
		legL.lineTo(x+52,y-18);
		legL.lineTo(x+50,y-23);
		legL.moveTo(x+40,y-6);
		legL.lineTo(x+41,y-11);
	}
	
	public void drawEye() {
		this.g2d.setColor(Color.white);
		this.g2d.fillOval(x+81,y-100,8,8);
		this.g2d.setColor(Color.black);
		this.g2d.fillOval(x+84,y-98,4,4);
	}
	
	public void drawBodyF() {
		bodyF.moveTo(x+20, y-113);
		bodyF.lineTo(x+20, y-34);
		bodyF.lineTo(x+67, y-22);
		bodyF.lineTo(x+67, y-101);
		bodyF.lineTo(x+20, y-113);
		bodyF.lineTo(x+46, y-133);
		bodyF.lineTo(x+92, y-120);
		bodyF.lineTo(x+67, y-101);
		
		bodyF.moveTo(x+92, y-120);
		bodyF.lineTo(x+92, y-39);
		bodyF.lineTo(x+67, y-22);
		bodyF.lineTo(x+67, y-101);
	}
	
	public void drawBody() {
		//behind
		body.moveTo(x+7, y-59);
		body.lineTo(x+18, y-56);
		body.lineTo(x+13, y-52);
		body.lineTo(x+38, y-45);
		body.lineTo(x+42, y-50);
		body.lineTo(x+54, y-47);
		body.lineTo(x+66, y-57);
		body.lineTo(x+20, y-69);
		body.lineTo(x+7, y-59);
		body.moveTo(x+13, y-52);
		body.lineTo(x+13, y-18);
		body.lineTo(x+38, y-11);
		body.lineTo(x+38, y-45);
		
		body.moveTo(x+43, y-50);
		body.lineTo(x+43, y-15);
		body.lineTo(x+54, y-12);
		body.lineTo(x+54, y-47);
	}
	
	public void drawBodyL() {
		bodyL.moveTo(x+7, y-59);
		bodyL.lineTo(x+7, y-25);
		bodyL.lineTo(x+18, y-22);
		bodyL.lineTo(x+18, y-56);
		
		bodyL.moveTo(x+38, y-45);
		bodyL.lineTo(x+38, y-11);
		bodyL.lineTo(x+43, y-15);
		bodyL.lineTo(x+43, y-50);
		
		bodyL.moveTo(x+54, y-47);
		bodyL.lineTo(x+54, y-12);
		bodyL.lineTo(x+67, y-25);
		bodyL.lineTo(x+67, y-57);
	}
	
	public void drawWingL() {
		wingL.moveTo(x, y-40);
		wingL.lineTo(x+7, y-38);
		wingL.lineTo(x+7, y-60);
		wingL.lineTo(x, y-63);
		wingL.lineTo(x, y-40);
		
		wingL.moveTo(x, y-63);
		wingL.lineTo(x+19, y-78);
		wingL.lineTo(x+26, y-75);
		wingL.lineTo(x+8, y-60);
	}
	
	public void drawWingR() {
		wingR.moveTo(x+61, y-46);
		wingR.lineTo(x+61, y-25);
		wingR.lineTo(x+74, y-20);
		wingR.lineTo(x+74, y-41);
		wingR.lineTo(x+61, y-46);
		
		wingR.lineTo(x+85, y-67);
		wingR.lineTo(x+98, y-63);
		wingR.lineTo(x+74, y-41);
		
		wingR.moveTo(x+74, y-20);
		wingR.lineTo(x+98, y-40);
		wingR.lineTo(x+98, y-63);
		wingR.lineTo(x+74, y-41);
	}
	
	public void draw() {
		this.g2d.setColor(new Color(253,106,50));
		this.g2d.fill(legR);
		this.g2d.setColor(Color.black);
		this.g2d.draw(legR);
		
		this.g2d.setColor(new Color(253,106,50));
		this.g2d.fill(legRUp);
		this.g2d.setColor(Color.black);
		this.g2d.draw(legRUp);
		
		this.g2d.setColor(new Color(253,106,50));
		this.g2d.fill(legL);
		this.g2d.setColor(Color.black);
		this.g2d.draw(legL);
		
		this.g2d.setColor(new Color(255,216,46));
		this.g2d.fill(wingL);
		this.g2d.setColor(Color.black);
		this.g2d.draw(wingL);
		
		this.g2d.setColor(new Color(255,216,46));
		this.g2d.fill(bodyF);
		this.g2d.setColor(Color.black);
		this.g2d.draw(bodyF);
		
		this.g2d.setColor(new Color(255,216,46));
		this.g2d.fill(bodyL);
		this.g2d.setColor(Color.black);
		this.g2d.draw(bodyL);
		
		this.g2d.setColor(new Color(255,216,46));
		this.g2d.fill(body);
		this.g2d.setColor(Color.black);
		this.g2d.draw(body);
		
		this.g2d.setColor(new Color(255,216,46));
		this.g2d.fill(wingR);
		this.g2d.setColor(Color.black);
		this.g2d.draw(wingR);
		
		this.g2d.setColor(Color.red);
		this.g2d.fill(hat);
		this.g2d.setColor(Color.black);
		this.g2d.draw(hat);
		
		this.drawEye();
	}
}
