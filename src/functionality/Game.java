package functionality;

import java.util.ArrayList;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
	}
	
	public int getCentX(){
		return width/2;
	}
	public int getCentY(){
		return height/2;
	}
	
	public void setup(){
		
		sun = new Sun(this, 1.9*Math.pow(10, 30));
		planets.add(new Planet(2*Math.pow(10, 11), 0, this, 6*Math.pow(10, 24), 10));
		planets.add(new Planet(7*Math.pow(10, 11), 0, this, 9*Math.pow(10,25), 20));
	}
	public void draw(){
		background(0);
		sun.draw(this);
		for (Planet p: planets){
			p.draw(this);
			p.orbit();
		}
	}
	
	public Sun getSun(){
		return sun;
	}
}
