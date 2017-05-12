package functionality;

import java.util.ArrayList;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private Projectile proj;
	
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
		
		sun = new Sun(this, 190);
		proj = new Projectile(300, 0, this, 0, 0);
		planets.add(new Planet(100, 0, this, 6, 10));
		planets.add(new Planet(400, 0, this, 9, 20));
		planets.add(new Planet(250, 0, this, 7, 15));
	}
	public void draw(){
		background(0);
		translate(getCentX(),getCentY());
		sun.draw(this);
		proj.draw(this);
		proj.orbit(planets);
		for (Planet p: planets){
			p.draw(this);
			p.orbit();
		}
	}
	
	public Sun getSun(){
		return sun;
	}
}
