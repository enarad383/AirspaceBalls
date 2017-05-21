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
	private int totalShots;
	private boolean didFinish;
	
	
	
	/**
	 * Represents the text and information given when playing the game.
	 * 
	 */
	public GameHUD (){
		shots = 0;
		level = 1;
		totalShots = 0;
		didFinish = false;
		
	}
	
	/**
	 * Draws the various text and information in the window. 
	 * @param p PApplet
	 */
	public void draw(PApplet p){
		
		p.pushStyle();
		p.pushMatrix();
		p.textAlign(LEFT);
		p.textSize(12);
		p.fill(0,255,0);
		p.text("Level: " + level + "    Score: " + totalShots + "    Shots: " + shots, (p.sketchWidth()/2) - 450, (p.sketchHeight()/2) - 430);
		p.popStyle();
		p.popMatrix();
	}
	
	/**
	 * Adds 1 to the shot count.
	 */
	public void addShot(){
		shots++;
		totalShots++;
	}
	
	/**
	 * Adds 1 to the level count.
	 */
	public void addLevel(){
		level++;
	}
	
	/**
	 * Resets the shot counter to 0.
	 */
	public void resetShots(){
		shots = 0;
	}
	
	public int getScore(){
		return totalShots;
	}
	
	

}
