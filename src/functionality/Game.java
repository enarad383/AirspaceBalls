package functionality;

import java.util.ArrayList;

import Menu.GameHUD;
import Menu.MenuButtons;
import gameplayObjects.*;

import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private Projectile proj;
	private Cannon can;

	private boolean isPaused;
	private boolean isDebug;

	private int gamePage;
	
	private MenuButtons but1;

	
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
		can = new Cannon(200, 50, this, 1);
		planets.add(new Planet(125, 1, this, 2, 10));
	//	planets.add(new Planet(400, Math.PI/2, this, 15, 20));
		planets.add(new Planet(400, 0, this, 15, 20));
		planets.add(new Planet(250, -Math.PI*3/2, this, 10, 15));
		proj = new Projectile(-300, 0.0, this, 0, -3.25);
		proj.setVisible(false);
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
		
		
	}
	
	public Sun getSun(){
		return sun;
	}
	
	
	public void menuScreen(){
		background(0);
		but1 = new MenuButtons (height/18, width/30, "GO!", this); //will auto draw.
	}
	
	public void gameScreen(){
		
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
			can.orbit();
			can.draw(this);
			
		}
		if (keyPressed){
			if (key == 'p'){
				isPaused = !isPaused;
				
			}
			if (key == 'u'){
				isPaused = false;
			}
			if (key == 'd'){
				setDebug();
			}
			if (keyCode == UP){
				can.changePower(true);
			}
			if (keyCode == DOWN){
				can.changePower(false);
			}
			if (keyCode == LEFT){
				can.aim(false);
			}
			if (keyCode == RIGHT){
				can.aim(true);
			}
			if (key == ' '){
				fireProjectile();
			}
		}
	}
	
	public void fireProjectile(){
		proj.setVisible(true);
		proj = new Projectile(can.getX(), can.getY(), this, 
				can.getVelX()+can.getPower()*Math.cos(can.getAimAngle()),
				can.getVelY()+can.getPower()*Math.sin(can.getAimAngle()));
	}
	
	
	public void mousePressed(){
		
		if (mouseButton == LEFT || but1.onRect()){
			gamePage = 1;
		}
		
		
	}
	
	
	
	
	
	
	
}
