package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Object.Chicken;
import Object.MobilLeft;
import Object.MobilRight;
import Object.Pohon;
import Object.Road;

public class Main extends JPanel implements ActionListener, KeyListener{
	private Pohon pohon;
	private MobilRight mobilR;
	private MobilLeft mobilL;
	private Road road;
	private Chicken chicken;
	private char map[][];
	private char oriMap[][];
	private final static int SIZE = 100;
	int mobilRCounter = 0, mobilLCounter = 0;
	int chickenX = 0 ,chickenY = 0;
	boolean start = true;
	boolean stop = false;
	
	//Petunjuk
	//Define 
	//	R = road
	//	T = Tree
	//	C = mobil hadap kanan
	//	V = mobil hadap kiri
	
	
	public Main() {
		addKeyListener(this);
		try {
			File f = new File("src/map.txt");
			Scanner sc = new Scanner(f);
			this.map = new char[8][];
			for(int i = 0; i < 8; i++) {
				this.map[i] = sc.nextLine().toCharArray();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.oriMap = new char[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				oriMap[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		Timer timer = new Timer(10, (ActionListener) this);
		timer.start();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
//		this.pohon = new Pohon(100,300,300,g2d);
//		this.mobil = new MobilRight(new Color(255,127,80),150,300,y,g2d);
//		this.mobilL = new MobilLeft(Color.green,150,x,y,g2d);
//		pohon.draw();
//		mobilL.draw();
//		mobil.draw();

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(this.map[i][j] == 'R' || this.map[i][j] == 'C' || this.map[i][j] == 'V') {
					this.road = new Road(SIZE,j*SIZE,i*SIZE,g2d);
					this.road.draw();
				}
				else if(this.map[i][j] == 'A') {
					boolean isRoad = false;
					for(int k = 0; k < 8; k++) {
						if(this.map[i][k] == 'R' || this.map[i][k] == 'C' || this.map[i][k] == 'V') {
							isRoad = true;
							break;
						}
						else if(this.map[i][k] == ' ') {
							break;
						}
					}
					if(isRoad) {
						this.road = new Road(SIZE,j*SIZE,i*SIZE,g2d);
						this.road.draw();
					}
					else {
						g2d.setColor(new Color(34,139,34));
						g2d.fillRect(j*SIZE,i*SIZE,SIZE,-SIZE);
					}
				}
				else {
					g2d.setColor(new Color(34,139,34));
					g2d.fillRect(j*SIZE,i*SIZE,SIZE,-SIZE);
				}
			}
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(this.map[i][j] == 'A') {
					if(start) {
						this.chickenX = j;
						this.chickenY = i;
						start = false;
					}
//					if(oriMap[chickenY][chickenX] == 'R'|| oriMap[chickenY][chickenX] == 'C' || oriMap[chickenY][chickenX] == 'V') {
//						this.road = new Road(SIZE,chickenX*SIZE,chickenY*SIZE,g2d);
//						this.road.draw();
//					}
//					else {
//						g2d.setColor(new Color(34,139,34));
//						g2d.fillRect(chickenX*SIZE,chickenY*SIZE,SIZE,-SIZE);
//					}
					this.chicken = new Chicken(SIZE,chickenX*SIZE,chickenY*SIZE,g2d);
					this.chicken.draw();
//					for(int k = 7; k > 0; k--) {
//						if(this.map[i][k] == 'C' || this.oriMap[i][k] == 'C'){
//							mobilR = new MobilRight(new Color(255,127,80),150,(k*SIZE+mobilRCounter)%900-150,i*SIZE-20,g2d);
//							mobilR.draw();
//						}
//						else if(this.map[i][k] == 'V' || this.oriMap[i][k] == 'V'){
//							mobilL = new MobilLeft(Color.green,150,(k*SIZE+mobilLCounter%900+150),i*SIZE-20,g2d);
//							mobilL.draw();
//						}
//					}
				}
				if(this.map[i][j] == 'T') {
					pohon = new Pohon(50,j*SIZE,i*SIZE,g2d);
					pohon.draw();
				}
				else if(this.map[i][j] == 'C' || this.oriMap[i][j] == 'C'){
					mobilR = new MobilRight(new Color(255,127,80),150,(j*SIZE+mobilRCounter)%900-150,i*SIZE-20,g2d);
					mobilR.draw();
					chickenHittedRight((j*SIZE+mobilRCounter)%900,i*SIZE);
				}
				else if(this.map[i][j] == 'V' || this.oriMap[i][j] == 'V'){
					mobilL = new MobilLeft(Color.green,150,(j*SIZE+mobilLCounter%900),i*SIZE-20,g2d);
					mobilL.draw();
					chickenHittedLeft((j*SIZE+mobilLCounter%900-100),i*SIZE);
				}
			}
		}
//		drawLine(g2d);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!stop) {
			mobilRCounter++;
			mobilLCounter--;
			repaint();
		}
	}
	
	public void drawLine(Graphics2D g2d) {
		g2d.setColor(Color.black);
		for(int i = 0; i < 10; i++) {
			g2d.drawLine(i*SIZE,0,i*SIZE,1000);
		}
		for(int i = 0; i < 10; i++) {
			g2d.drawLine(0,i*SIZE,1000,i*SIZE);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if((e.getKeyCode() == 38 || e.getKeyCode() == 87) && checkPosition(chickenX,chickenY-1)) {
			this.chickenY -= 1;
			moveChicken(chickenX,chickenY+1);
			map[chickenY][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 40 || e.getKeyCode() == 83) && checkPosition(chickenX,chickenY+1) ){
			this.chickenY += 1;
			moveChicken(chickenX,chickenY-1);
			map[chickenY][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 37 || e.getKeyCode() == 65) && checkPosition(chickenX-1,chickenY) ){
			this.chickenX -= 1;
			moveChicken(chickenX+1,chickenY);
			map[chickenY][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 39 || e.getKeyCode() == 68) && checkPosition(chickenX+1,chickenY) ){
			this.chickenX += 1;
			moveChicken(chickenX-1,chickenY);
			map[chickenY][chickenX] = 'A';
		}
//		repaint();
	}

	public boolean chickenHittedRight(int x, int y) {
		if(y == chickenY * SIZE) {
			if(x == chickenX * SIZE) {
				stop = true;
				return true;
			}
			else if(x >= chickenX * SIZE && x-200 <= chickenX * SIZE) {
				stop = true;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean chickenHittedLeft(int x, int y) {
		if(y == chickenY * SIZE) {
			if(x == chickenY * SIZE) {
				stop = true;
				return true;
			}
			else if(x >= chickenX * SIZE && x+200 <= chickenX * SIZE) {
				stop = true;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveChicken(int x, int y) {
//		System.out.println(oriMap[y][x] + " " + y + " " + x);
//		for(int i = 0; i < 8; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.print(oriMap[i][j]);
//			}
//			System.out.println();
//		}
		if(oriMap[y][x] == 'A') {
			map[y][x] = ' ';
		}
		else {
			map[y][x] = oriMap[y][x];
		}
	}
	
	public boolean checkPosition(int x, int y) {
		if(x >= 0) {
			if(y >= 0) {
				if(map[y][x] != 'T') {
					return true;
				}
			}
			else if(y < 9) {
				if(map[y][x] != 'T') {
					return true;
				}
			}
		}
		else if(x < 9) {
			if(y >= 0) {
				if(map[y][x] != 'T') {
					return true;
				}
			}
			else if(y < 9) {
				if(map[y][x] != 'T') {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Animal Crossing");
		Main m = new Main();
		f.getContentPane().add("Center",m);
		f.setSize(new Dimension(817,740));
		m.setFocusable(true);
		f.add(m);
		f.setVisible(true);
	}
}
