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
	private ArrayList<Spark> sparks;
	private ArrayList<Level> levels;
	
	private int currentLevel;
	
	private Cannon can;
	
	private FileIO reader;
	
	private int shootTimer;
	private int winTimer;
	private int debugTimer;
	
	private boolean isPaused;
	private boolean isDebug;
	private boolean isWon;
	
	private int gamePage;

	private MenuButtons menu;
	private GameHUD hud;

	
	

	/**
	 * Represents the Game.
	 */
	public Game(){
		super();
		runSketch();
		planets = new ArrayList<Planet>();
		projectiles = new ArrayList<Projectile>();
		sparks = new ArrayList<Spark>();
		isPaused = false;
		isWon = false;
		isDebug = false;
		reader = new FileIO();
		levels = new ArrayList<Level>();

		gamePage = 0;
		shootTimer = 0;
		winTimer = 0;
		currentLevel = 0;
		
		

	}
	/**
	 * Determines the center x value of the window. 
	 * @return x value of the center of the window. 
	 */
	public int getCentX(){
		return width/2;
	}
	
	/**
	 * Determines the center y value of the window. 
	 * @return y value of the center of the window. 
	 */
	public int getCentY(){
		return height/2;
	}
	
	/**
	 * Sets the window. 
	 */
	public void setup(){
		
		hud = new GameHUD();
		
		sun = new Sun(190);
		levels.add((Level)reader.readObject("level1.bz"));
		levels.add((Level)reader.readObject("level2.bz"));
		levels.add((Level)reader.readObject("level3.bz"));
		levels.add((Level)reader.readObject("level4.bz"));
		levels.add((Level)reader.readObject("level5.bz"));
		levels.add((Level)reader.readObject("level6.bz"));
		levels.add((Level)reader.readObject("level7.bz"));
		for (int i = 0; i<10; i++){
			sparks.add(new Spark(0, 0, 0,0, 0));
		}
	}
	
	private void loadLevel(Level lev){
		can = lev.getCannon();
		planets = lev.getPlanets();
		
	}
	
	/**
	 * Modify the Debug value. 
	 */
	public void setDebug(){
		debugTimer = 10;
		isDebug = !isDebug;
	}
	
	public void setGoaled(boolean goaled){
		isWon = goaled;
	}
	
	/**
	 * Determines if the game is in debug mode.
	 * @return true if the game is in debug mode. 
	 */
	public boolean isDebug(){
		return isDebug;
	}
	
	
	
	/**
	 * Represents what is drawn in the window. Which screen is being displayed. 
	 */
	public void draw(){
		
		if (gamePage == 0){
			menuScreen();
		} else if (gamePage == 1){
			//levelTest();
			gameScreen();
		} else if (gamePage == 2){
			instrScreen();
		} else if (gamePage == 3){
			winScreen();
		}
		
		
		if (keyPressed && key == BACKSPACE){
			gamePage = 0;
		}
		
		
	}
	
	/**
	 * 
	 * @return The sun object.
	 */
	public Sun getSun(){
		return sun;
	}
	
	/**
	 * 
	 * @return The list containing all projectiles in the game.
	 */
	public ArrayList<Projectile> getProjectiles(){
		return projectiles;
	}
	
	/**
	 * Represents the menu screen. This is the screen displayed when first opening the game. 
	 */
	public void menuScreen(){
		background(0);
		currentLevel = 0;
		hud.resetLevel();
		hud.resetShots();
		hud.resetScore();
		menu = new MenuButtons (this);
		menu.draw(this);
		textSize(60);
		textAlign(CENTER);
		fill(255, 0, 0);
		for (int i = 10; i>0; i--){
			fill (25*i, 0, 0);
			text("AIRSPACE BALLS", 500+0.5f*i, 350+2*i);
			text("AIRSPACE BALLS", 500-0.5f*i, 350-2*i);
		}
		
		textSize(10);
	}
	
	/**
	 * Represents the win screen, only seen after completing a level. 
	 */
	public void winScreen(){
		background(0);
		textAlign(CENTER);
		textSize(50);
		for (int i = 10; i>0; i--){
			fill (0, 25*i, 0);
			text("LEVEL COMPLETE", 500+0.5f*i, 350+1*i);
			text("LEVEL COMPLETE", 500-0.5f*i, 350-1*i);
		}
		textSize(48);
		textAlign(CENTER);
		fill(0,255,0);
		if(currentLevel != 7){
			
		
			text("Your score is : " + hud.getScore(), 500, 440);
			text("Press space to continue", 500, 560);
			if (keyPressed){
				if (key == ' '){
					gamePage = 1;
					if (currentLevel<levels.size()){
						shootTimer = 10;
						loadLevel(levels.get(currentLevel));
						hud.resetShots();
						hud.addLevel();
					}
					else{
						gamePage = 0;
						currentLevel = 0;
					}
					projectiles = new ArrayList<Projectile>();
				}
			}
		} else {
			text("Your final score is : " + hud.getScore(), 500, 440);
			text("Press backspace to return to menu", 500, 560);
			//currentLevel = 0;
			hud.resetShots();
			//hud.resetLevel();
		}
		
		
		
		
	}
	
	/**
	 * Represents the instructions screen. This is the screen displayed after the INSTRUCTIONS button is selected.
	 */
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
				+ "as it�s flung into the gravity fields of several planets. This is a game targeted towards the light "
				+ "simulation enthusiast. Airspace Balls provides a fun way to explore the basics of orbital mechanics while also allowing "
				+ "one to fine-tune their skills at aiming.", (sketchWidth()*3)/4 -140, (sketchHeight())/4 + 25, (sketchWidth())/4+125, (sketchHeight())/2);
		
		
		text("BACKSPACE = Exit to main menu. \n\nLEFT & RIGHT ARROWS = Turn the cannon. \nUP & DOWN ARROWS = Adjust cannon power. \nSPACE = Fire the projectile. \n\nD = Debug mode. \nP = Pause. ", (sketchWidth())/4 -140, (sketchHeight())/4 + 25, (sketchWidth())/4+125, (sketchHeight())/2);
		
		
		
		
		textSize(10);
	}
	
	/**
	 * Represents the game screen. This screen is displayed when the PLAY button is selected. This is also where level files are read. 
	 */
	public void gameScreen(){
		loadLevel(levels.get(currentLevel));
		
		
		
		hud.draw(this);
		
		
		
		if (!isPaused){
			background(0);
			hud.draw(this);
			translate(getCentX(),getCentY());
			sun.draw(this);
			strokeWeight(1);
			stroke(255);
			ellipse(0, 0, 30, 30);
			for (Projectile proj: projectiles){
				proj.orbit(planets);
				proj.draw(this, this);
			}
			Iterator<Projectile> projit= projectiles.iterator();
			while (projit.hasNext()){
				Projectile pro = projit.next();
				if (!pro.isLive()){	
					
					for (Spark sp: sparks){	
						sp.setTime(20);
						sp.setPos(pro.getX(), pro.getY());
						sp.setVel(pro.getVelX()/1.5+10*(Math.random()-0.5), pro.getVelY()/1.5+10*(Math.random()-0.5));
						sp.setVisible(true);
					}
					projit.remove();
				}
			}
			for (Planet p: planets){
				p.draw(this);
				if (p instanceof Goal){
					((Goal)p).orbit(this);
				}
				else{
					p.orbit();
				}
			}
			for (Spark sp: sparks){
				sp.act();
				sp.draw(this);
				
			}
			can.orbit();
			can.draw(this);
			if (isDebug){
				textAlign(LEFT);
				fill(0, 255, 0);
				textSize(12);
				text("FPS: " + frameRate, -450, -450);
				text("Num projectiles: " + projectiles.size(), -450, -410);
				text("Power: " + Math.round(can.getPower()), -450, -390);
				
			}
			if (shootTimer>0){
				shootTimer--;
			}
			if (debugTimer>0){
				debugTimer--;
			}
			if (isWon){
				winTimer ++;
			}
			if (winTimer>60){
				winTimer = 0;
				isWon = false;
				currentLevel++;
				gamePage = 3;
			}
			
			
		}
		if (keyPressed){
			if (key == 'p'){
				isPaused = !isPaused;
				
			}
			
			
			if (key == 'u'){
				isPaused = false;
			}
			if (key == 'd' && debugTimer == 0){
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
			if (key == ' ' && shootTimer == 0){
				fireProjectile();
			}
			
			
			
		}
	}
	
	
	/**
	 * Fires a projectile from the cannon.
	 */
	public void fireProjectile(){
		projectiles.add(new Projectile(can.getX(), can.getY(), this, 
				can.getVelX()+can.getPower()*Math.cos(can.getAimAngle()),
				can.getVelY()+can.getPower()*Math.sin(can.getAimAngle())));
		shootTimer = 20;
		hud.addShot();
	}
	
	
	/**
	 * Checks if a button was pressed.
	 */
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
