package Object;

import java.awt.Color;
import java.awt.Graphics2D;

public class Mobil {
	private Color color;
	private Graphics2D g2d;
	private int x, y;
	
	public Mobil(int x, int y, Graphics2D g2d) {
		this.g2d = g2d;
		this.x = x;
		this.y = y;
	}
}
