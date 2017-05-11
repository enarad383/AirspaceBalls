package functionality;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	
	private final int centerX = width/2;
	private final int centerY = height/2;
	private Sun sun;
	
	public Game(){
		super();
		runSketch();
	}
	
	public int getCentX(){
		return centerX;
	}
	public int getCentY(){
		return centerY;
	}
	
	public void setup(){
		
	}
	public void draw(){
		background(0);
	}
	
	public Sun getSun(){
		return sun;
	}
}
