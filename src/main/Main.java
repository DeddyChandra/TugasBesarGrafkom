package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Object.Pohon;

public class Main extends JPanel{
	private Pohon pohon;
	
	public Main() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.pohon = new Pohon(200,500,500,g2d);
		pohon.draw();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Animal Crossing");
		Main m = new Main();
		f.getContentPane().add("Center",m);
		f.pack();
		f.setSize(new Dimension(1000,1000));
		f.setVisible(true);
	}
}
