package functionality;

import java.io.Serializable;
import java.util.ArrayList;

import gameplayObjects.Cannon;
import gameplayObjects.Planet;
import gameplayObjects.Sun;

public class Level implements Serializable{
	
	private static int levelNum;
	//private Sun sun;
	private ArrayList<Planet> planets;
	//private Cannon cann;
	
	
	/**
	 * Represents Level or a specific configuration of planets.
	 * @param num The level number.
	 */
	public Level (int num){
		planets = new ArrayList<Planet>();
		levelNum = num;
		
	}
	
	/**
	 * Add a planet to the level. Use this when making a level. 
	 * @param radius The distance at which the planet orbits the sun.
	 * @param angle The polar angle at which the planet starts.
	 * @param g The Game object in which it is created.
	 * @param grav The acceleration due to the gravity of the planet.
	 * @param size The visual size of the planet.
	 */
	public void addPlanet(double radius, double angle, Game g, double grav, double size){
		planets.add(new Planet(radius, angle, g, grav, size));
	}
	
	
	public void addSun(Game g){
		//sun = new Sun(g, 190);
	}
	
	public void addCannon(Game g){
		//cann = new Cannon(200, 50, g, 1);
	}
	
	
	public static Level loadState(){
		  FileIO reader = new FileIO();
		  return (Level)reader.readObject("saveFile" + levelNum + ".ssf");
	  }
	
	
	public void saveState(){
		  FileIO writer = new FileIO();
		  writer.writeObject("saveFile" + levelNum + ".ssf", this);
	  }
	
	
}
