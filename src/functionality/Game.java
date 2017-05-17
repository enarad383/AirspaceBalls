package functionality;

import java.util.ArrayList;
import java.util.Iterator;

import Menu.GameHUD;
import Menu.MenuButtons;
import gameplayObjects.*;

import processing.core.PApplet;

public class Game extends PApplet{
	

	private Sun sun;
	private ArrayList<Planet> planets;
	private ArrayList<Projectile> projectiles;
	private Cannon can;
	
	private boolean isArmed;
	private boolean isPaused;
	private boolean isDebug;

	private int gamePage;
	
	private MenuButtons menu;

	
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
		projectiles = new ArrayList<Projectile>();
		isPaused = false;

		isDebug = false;
		isArmed = false;
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
		} else if (gamePage == 2){
			instrScreen();
		}
		
		if (keyPressed && key == BACKSPACE){
			gamePage = 0;
		}
		
		
	}
	
	public Sun getSun(){
		return sun;
	}
	
	
	public void menuScreen(){
		background(0);
		menu = new MenuButtons (this);
		menu.draw(this);
		textSize(10);
	}
	
	public void instrScreen(){	//NOT DONE
		background(0);
		fill(170);
		rectMode(CORNER);
		rect((float)sketchWidth()/4-90, (float)sketchHeight()/4+2, 180, 2);
		rect((float)(sketchWidth()*3)/4-115, (float)(sketchHeight())/4+2, 230, 2);
		
		textAlign(CENTER);
		textSize(38);
		text("Controls:", sketchWidth()/4, sketchHeight()/4);
		text("Description:", (sketchWidth()*3)/4, (sketchHeight())/4);
		textAlign(LEFT);
		fill(255);
		textSize(16);
		
		
		text("The game of golf is difficult, as a ball must be precisely aimed to hit a target very far away. "
				+ "However, regular old earth golf only has one source of gravity to worry about. "
				+ "In Airspace Balls, the game of golf is scaled up to take place in an entire solar system. "
				+ "Rather than taking aim and judging distance, the player must predict how a ball will travel "
				+ "as it’s flung into the gravity fields of several planets. This is a game targeted towards the light "
				+ "simulation enthusiast. Airspace Balls provides a fun way to explore the basics of orbital mechanics while also allowing "
				+ "one to fine-tune their skills at aiming.", (sketchWidth()*3)/4 -140, (sketchHeight())/4 + 25, (sketchWidth())/4+125, (sketchHeight())/2);
		
		
		
		
		
		
		
		textSize(10);
	}
	
	public void gameScreen(){
		
		if (!isPaused){
			background(0);
			translate(getCentX(),getCentY());
			sun.draw(this);
			ellipse(0, 0, 30, 30);
			for (Projectile proj: projectiles){
				proj.orbit(planets);
				proj.draw(this);
			}
			Iterator<Projectile> projit= projectiles.iterator();
			while (projit.hasNext()){
				if (!projit.next().isLive()){
					projit.remove();
				}
			}
			for (Planet p: planets){
				p.draw(this);
				p.orbit();
			}
			can.orbit();
			can.draw(this);
			if (isDebug){
				textAlign(LEFT);
				fill(0, 255, 0);
				text("FPS: " + frameRate, -450, -450);
				
			}
			
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
		projectiles.add(new Projectile(can.getX(), can.getY(), this, 
				can.getVelX()+can.getPower()*Math.cos(can.getAimAngle()),
				can.getVelY()+can.getPower()*Math.sin(can.getAimAngle())));
	}
	
	
	public void mousePressed(){
		
		if (mousePressed && mouseButton==LEFT && menu.onButton(mouseX, mouseY)){
			if (menu.getButtonPressed() == 0){
				gamePage = 1;
			} else if (menu.getButtonPressed() == 1){
				gamePage = 2;
			}
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
}
