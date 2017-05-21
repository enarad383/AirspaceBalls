package Menu;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import functionality.Game;
import processing.core.PApplet;

import java.util.*;


public class GameHUD extends PApplet 
{
	
	private int shots;
	private int level;
	
	
	
	
	
	/**
	 * Represents the text and information given when playing the game.
	 * @param g A Game object. 
	 */
	public GameHUD (){
		shots = 0;
		level = 1;
	}
	
	/**
	 * Draws the various text and information in the window. 
	 */
	public void draw(PApplet p){
		p.fill(0,255,0);
		p.text("Shots: " + shots + "    Level: " + level, 200, 200);
	}
	
	public void addShot(){
		shots++;
	}
	
	public void addLevel(){
		level++;
	}
	
	public void resetShots(){
		shots = 0;
	}
	
	
	

}
