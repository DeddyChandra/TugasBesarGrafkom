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
import Object.KeretaBody;
import Object.KeretaHead;
import Object.MobilLeft;
import Object.MobilRight;
import Object.Pohon;
import Object.Rail;
import Object.Road;

public class Main extends JPanel implements ActionListener, KeyListener{
	private Pohon pohon;
	private MobilRight mobilR;
	private MobilLeft mobilL;
	private Road road;
	private Rail rail;
	private Chicken chicken;
	private KeretaHead keretaHead;
	private KeretaBody keretaBody;
	private char map[][];
	private char oriMap[][];
	private final static int SIZE = 100;
	private int mobilRCounter = 0, mobilLCounter = 0, keretaCounter = 0;
	private int chickenX = 0 ,chickenY = 0;
	private boolean start = true;
	private boolean stop = false;
	private boolean rechangeChickenPos =  true;
	int positionDraw = 0, totalY = 0;
	
	//Petunjuk
	//Define 
	//	R = road
	//	T = Tree
	//	C = mobil hadap kanan
	//	V = mobil hadap kiri
	//  S = SMRT
	//  U = rel kereta
	
	
	public Main() {
		totalY = 55;
		addKeyListener(this);
		try {
			File f = new File("src/map.txt");
			Scanner sc = new Scanner(f);
			this.map = new char[totalY][];
			for(int i = 0; i < totalY; i++) {
				this.map[i] = sc.nextLine().toCharArray();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.oriMap = new char[totalY][8];
		for(int i = 0; i < totalY; i++) {
			for(int j = 0; j < 8; j++) {
				oriMap[i][j] = map[i][j];
			}
		}
//		for(int i = 0; i < totalY; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
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
//		keretaBody = new KeretaBody(Color.white,new Color(235,43,43),300,300,g2d);
//		keretaBody.draw();
//		pohon.draw();
//		mobilL.draw();
//		mobil.draw();
		if(start) {
			positionDraw = totalY;
		}
		else {
			if(chickenY == 1) {
				positionDraw = positionDraw - 6; 
				rechangeChickenPos = true;
				this.chickenY = 0;
			}
		}
//		System.out.println("asdasd chickenY = " + chickenY + " " + chickenX + " " + positionDraw);
//		printMap();
		
		int x = 1;
		for(int i = positionDraw-7; i < positionDraw; i++) {
			for(int j = 0; j < 8; j++) {
//				System.out.println(i + " " + j + " " + map[i][j]);
				if(this.map[i][j] == 'R' || this.map[i][j] == 'C' || this.map[i][j] == 'V') {
					this.road = new Road(SIZE,j*SIZE,x*SIZE,g2d);
					this.road.draw();
				}
				else if(this.map[i][j] == 'A') {
					boolean isRoad = false;
					boolean isRail = false;
					for(int k = 0; k < 8; k++) {
						if(this.map[i][k] == 'R' || this.map[i][k] == 'C' || this.map[i][k] == 'V') {
							isRoad = true;
							break;
						}
						else if(this.map[i][k] == 'S' || this.map[i][k] == 'U') {
							isRail = true;
							break;
						}
						else if(this.map[i][k] == ' ') {
							break;
						}
					}
					if(isRoad) {
						this.road = new Road(SIZE,j*SIZE,x*SIZE,g2d);
						this.road.draw();
					}
					else if(isRail) {
						this.rail = new Rail(SIZE, j*SIZE, x*SIZE, g2d);
						this.rail.draw();
					}
					else {
						g2d.setColor(new Color(34,139,34));
						g2d.fillRect(j*SIZE,x*SIZE,SIZE,-SIZE);
					}
				}
				else if(this.map[i][j] == 'U' || this.map[i][j] == 'S') {
					this.rail = new Rail(SIZE, j*SIZE, x*SIZE, g2d);
					this.rail.draw();
				}
				else {
					g2d.setColor(new Color(34,139,34));
					g2d.fillRect(j*SIZE,x*SIZE,SIZE,-SIZE);
				}
			}
			x++;
		}
		
		x = 1;
		for(int i = positionDraw-7; i < positionDraw; i++) {
			for(int j = 0; j < 8; j++) {
				if(this.map[i][j] == 'A') {
					if(start || rechangeChickenPos) {
						this.chickenX = j;
						this.chickenY = x;
						start = false;
						rechangeChickenPos = false;
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
					pohon = new Pohon(50,j*SIZE,x*SIZE,g2d);
					pohon.draw();
				}
				else if(this.map[i][j] == 'C' || this.oriMap[i][j] == 'C'){
					mobilR = new MobilRight(new Color(255,127,80),150,(j*SIZE+mobilRCounter)%1000-150,x*SIZE-20,g2d);
					mobilR.draw();
					chickenHittedRightCar((j*SIZE+mobilRCounter)%1000,x*SIZE);
				}
				else if(this.map[i][j] == 'V' || this.oriMap[i][j] == 'V'){
					System.out.println(850+(j*SIZE+mobilLCounter)%1000-150);
					mobilL = new MobilLeft(Color.green,150,850+(j*SIZE+mobilLCounter)%1000-150,x*SIZE-20,g2d);
					chickenHittedLeftCar(850+(j*SIZE+mobilLCounter)%1000-250,x*SIZE);
//					System.out.println((j*SIZE+mobilLCounter%1000)+ " " + (x*SIZE-20));
//					System.out.println("chickenY = " + chickenY*SIZE + " " + chickenX*SIZE);
					mobilL.draw();
				}
				else if(this.map[i][j] == 'S'|| this.oriMap[i][j] == 'S') {
					keretaBody = new KeretaBody(Color.white,new Color(235,43,43),((j-6)*SIZE+keretaCounter)%1400-290,(x)*SIZE,g2d);
					keretaBody.draw();
					keretaBody = new KeretaBody(Color.white,new Color(235,43,43),((j-3)*SIZE+keretaCounter)%1400-300,(x)*SIZE,g2d);
					keretaBody.draw();
					keretaHead = new KeretaHead(Color.white,new Color(235,43,43),(j*SIZE+keretaCounter)%1400-310,x*SIZE,g2d);
					keretaHead.draw();
					chickenHittedTrain((j*SIZE+keretaCounter)%1400-30,x*SIZE);
				}
			}
			x++;
		}
//		drawLine(g2d);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!stop) {
			mobilRCounter++;
			mobilLCounter--;
			keretaCounter += 2;
			repaint();
		}
	}
	
	public void printMap() {
		System.out.println("===================");
		for(int i = 0; i < totalY; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("===================");
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

		if((e.getKeyCode() == 38 || e.getKeyCode() == 87) && checkPosition(chickenX,chickenY-1+positionDraw-8)) {
			this.chickenY -= 1;
			moveChicken(chickenX,chickenY+1+positionDraw-8);
			map[chickenY+positionDraw-8][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 40 || e.getKeyCode() == 83) && checkPosition(chickenX,chickenY+1+positionDraw-8) ){
			this.chickenY += 1;
			moveChicken(chickenX,chickenY-1+positionDraw-8);
			map[chickenY+positionDraw-8][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 37 || e.getKeyCode() == 65) && checkPosition(chickenX-1,chickenY+positionDraw-8) ){
			this.chickenX -= 1;
			moveChicken(chickenX+1,chickenY+positionDraw-8);
			map[chickenY+positionDraw-8][chickenX] = 'A';
		}
		else if((e.getKeyCode() == 39 || e.getKeyCode() == 68) && checkPosition(chickenX+1,chickenY+positionDraw-8) ){
			this.chickenX += 1;
			moveChicken(chickenX-1,chickenY+positionDraw-8);
			map[chickenY+positionDraw-8][chickenX] = 'A';
		}
//		repainz.out.println(chickenX+" " +chickenY +  " " + map[chickenY][chickenX]);
	}

	public boolean chickenHittedTrain(int x, int y) {
		
		if(y == chickenY * SIZE) {
			if(x == chickenX * SIZE) {
				System.out.println("hitted by train");
				stop = true;
				return true;
			}
			else if(x >= chickenX * SIZE && x-900 <= chickenX * SIZE){
				System.out.println("hitted by train");
				stop = true;
				return true;
			}
		}
		return false;
	}
	
	public boolean chickenHittedRightCar(int x, int y) {
		
		if(y == chickenY * SIZE) {
			if(x == chickenX * SIZE) {
				System.out.println("hitted by right car");
				stop = true;
				return true;
			}
			else if(x >= chickenX * SIZE && x-200 <= chickenX * SIZE) {
				System.out.println("hitted by right car");
				stop = true;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean chickenHittedLeftCar(int x, int y) {

		if(y == chickenY * SIZE) {
			if(x == chickenX * SIZE) {
				System.out.println("hitted by left car");
				stop = true;
				return true;
			}
			else if(x <= chickenX * SIZE && x+200 >= chickenX * SIZE) {
				System.out.println("hitted by left car");
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
		System.out.println(x + " "  + y + " " +(positionDraw));
		if(x >= 0 && x < totalY) {
			if(y < totalY && y < positionDraw) {
				if(map[y][x] != 'T') {
					System.out.println("trye");
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
