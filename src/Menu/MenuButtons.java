package Menu;
import java.awt.*;
import javax.swing.*;

import functionality.Game;
import processing.core.PApplet;
import processing.core.PFont;

import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class MenuButtons extends PApplet{
	
	private int x1, y1;
	private String start, instructions;
	
	private boolean overPlay, overInstr;
	
	/**Creates all of the menu buttons.
	 * 
	 * @param g A Game object.
	 * 
	 */
	public MenuButtons(Game g) {
		start = "PLAY";
		instructions = "INSTRUCTIONS";
		
		x1 = g.sketchWidth()/2;
		y1 = g.sketchHeight()/2;
		overPlay = false;
		overInstr = false;
		
		
	}
	
	
	/**
	 * Draws the buttons (PLAY & INSTRUCTIONS).
	 * @param p A PApplet Object.
	 */
	public void draw(PApplet p){
		
		onButton(p.pmouseX, p.pmouseY);
		
		if (overPlay){
			p.fill(255);
			p.textSize(40);
		} else {
			p.fill(255, 67, 0);
			p.textSize(38);
		}
		
		p.rectMode(CORNER);
		p.rect((float)x1-50, (float)y1+2, 100, 2);
		p.textAlign(CENTER);
		
		p.text(start, x1,y1); //PLAY button
		
		if (overInstr){
			p.fill(255);
			p.textSize(40);
		} else {
			p.fill(255, 67, 0);
			p.textSize(38);
		}
		
		p.rectMode(CORNER);
		p.rect((float)x1-140, (float)y1+2 + 75, 280, 2);
		p.textAlign(CENTER);
		
		p.text(instructions, x1,y1 + 75); //INSTRUCTION button
			

	}
	
	
	/**
	 * Detects whether the mouse is on a button or not.
	 * @param mouseX The x position of the mouse in the window.
	 * @param mouseY The y position of the mouse in the window.
	 * @return true if the mouse is over a button. 
	 */
	public boolean onButton(int mouseX, int mouseY)  {
		  if ((mouseX >= x1-50 && mouseX <= x1+50 && mouseY >= y1-36 && mouseY <= y1)) {
			  overPlay = true;
			  return true;
		  } else if ((mouseX >= x1-140 && mouseX <= x1+140 && mouseY >= y1-36 + 75 && mouseY <= y1+75) ){
			  overInstr = true;
			  return true;
		  } else {
			  
			  overInstr = false;
			  overPlay = false;
			  return false;
		  }
		  
		  
	}
	
	
	/**
	 * Determines which button was clicked on.
	 * @return 0 if the PLAY buttons was clicked. 1 if the INSTRUCTIONS button was clicked.
	 */
	public int getButtonPressed(){
		if (overInstr){
			return 1;
		} else if (overPlay){
			return 0;
		} else {
			return -1;
		}
	}
	
	
}