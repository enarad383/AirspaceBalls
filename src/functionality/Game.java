package functionality;

import java.util.ArrayList;

import gameplayObjects.*;
import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private Projectile proj;
	boolean isPaused;
	private int gamePage;
	
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
		isPaused = false;
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
		background(0);
		planets.add(new Planet(100, 1, this, 2, 10));
		planets.add(new Planet(400, Math.PI/2, this, 15, 20));
		//planets.add(new Planet(300, 0, this, 15, 20));
		planets.add(new Planet(250, 0, this, 7, 15));
		proj = new Projectile(-300, 0, this, 0, -2.5);
	}
	public void draw(){
		
		if (gamePage == 0){
			menuScreen();
		} else if (gamePage == 1){
			
			gameScreen();
		}
		
		

	}
	
	public Sun getSun(){
		return sun;
	}
	
	
	public void menuScreen(){
		background(0);
		textAlign(CENTER);
		text("Click to start", height/2, width/2);
		
		
	}
	
	public void gameScreen(){
		//background(0);
		if (!isPaused){
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
			if (key == ' '){
				isPaused = !isPaused;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	
	
	}
	
	
	public void mouseClicked(){
		if (gamePage == 0){
			gamePage = 1;
		} else {
			gamePage = 0;
		}
	}
	
	
	
	
	
	
	
}
