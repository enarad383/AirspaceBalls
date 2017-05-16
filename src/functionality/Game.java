package functionality;

import java.util.ArrayList;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private Projectile proj;

	private boolean isPaused;
	private boolean isDebug;

	private int gamePage;

	
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
		isPaused = false;

		isDebug = false;

		gamePage = 0;
		
		

	}
	
	public int getCentX(){
		return width/2;
	}
	public int getCentY(){
		return height/2;
	}
	
	public void setup(){
		
		sun = new Sun(this, 190);
		
		planets.add(new Planet(125, 1, this, 2, 10));
	//	planets.add(new Planet(400, Math.PI/2, this, 15, 20));
		planets.add(new Planet(400, 0, this, 15, 20));
		planets.add(new Planet(250, -Math.PI*3/2, this, 10, 15));
		proj = new Projectile(-300, 0.0, this, 0, -3.25);
	}
	
	public void setDebug(){
		isDebug = !isDebug;
	}
	
	public boolean isDebug(){
		return isDebug;
	}
	
	public void draw(){
		
		if (gamePage == 0){
			menuScreen();
		} else if (gamePage == 1){
			gameScreen();
		}
		
		
		if (keyPressed){
			if (key == '5'){
				gamePage = 1;
			} else if (key == '6'){
				gamePage = 0;
			}
		}
		

	}
	
	public Sun getSun(){
		return sun;
	}
	
	
	public void menuScreen(){
		background(0);
		textAlign(CENTER);
		text("Press 5 to start", height/2, width/2);
	}
	
	public void gameScreen(){
		background(0);
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
			if (key == 'd'){
				setDebug();
			}
			if (keyCode == UP){
				
			}
			if (keyCode == DOWN){
				
			}
			if (keyCode == LEFT){
				
			}
			if (keyCode == RIGHT){
				
			}
		}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
}
