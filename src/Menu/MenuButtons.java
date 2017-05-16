package Menu;
import java.awt.*;
import javax.swing.*;

import functionality.Game;
import processing.core.PApplet;

import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class MenuButtons extends PApplet{
	
	private int x, y;
	private String text;
	
	public MenuButtons(int xCoord, int yCoord, String text, Game g) {
		x = xCoord;
		y = yCoord;
		this.text = text;
		draw(g);
	}
	
	public MenuButtons(int xCoord, int yCoord, Game g){
		x = xCoord;
		y = yCoord;
		draw(g);
	}
	
	
	
	
	public void draw(PApplet p){
		p.stroke(153);
		p.fill(0,255,0);
		p.rectMode(CENTER);
		p.rect((float)x, (float)y, 75, 25);
		
		if (text != null){
			p.textAlign(CENTER);
			p.fill(255,0,0);
			p.text(text, x, y+20, 100, 50);
			
		}
		
	}
	
	public boolean onRect()  {
		  if (mouseX >= x && mouseX <= x+75 && mouseY >= y && mouseY <= y+25) {
		    return true;
		  } else {
		    return false;
		  }
		}
	
	
	
}