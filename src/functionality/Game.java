package functionality;

import java.util.ArrayList;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private Projectile proj;
	boolean isPaused;
	
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
		isPaused = false;
	}
	
	public int getCentX(){
		return width/2;
	}
	public int getCentY(){
		return height/2;
	}
	
	public void setup(){
		
		sun = new Sun(this, 190);
		
	//	planets.add(new Planet(100, 1, this, 2, 10));
	//	planets.add(new Planet(400, Math.PI/2, this, 15, 20));
		planets.add(new Planet(300, 0, this, 15, 20));
		planets.add(new Planet(250, -Math.PI*3/2, this, 10, 15));
		proj = new Projectile(-300, 0.0, this, 0, 2.5);
	}
	public void draw(){
		if (!isPaused){
			background(0);
			translate(getCentX(),getCentY());
			sun.draw(this);
			ellipse(0, 0, 30, 30);
			proj.orbit(planets);
			proj.draw(this);
			
			for (Planet p: planets){
				p.draw(this);
				p.orbit();
			}
		}
		if (keyPressed){
			if (key == 'p'){
				isPaused = true;
			}
			if (key == 'u'){
				isPaused = false;
			}
		}

	}
	
	public Sun getSun(){
		return sun;
	}
}
