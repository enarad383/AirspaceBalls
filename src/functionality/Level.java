package functionality;

import java.io.Serializable;
import java.util.ArrayList;

import gameplayObjects.Cannon;
import gameplayObjects.Planet;
import gameplayObjects.Sun;

public class Level implements Serializable{
	
	private int levelNum;
	private Sun sun;
	private ArrayList<Planet> planets;
	private Cannon cann;
	
	public static final long SerialVersionUID = 2;
	
	
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
	public void addPlanet(Planet p){
		planets.add(p);
	}
	
	/**
	 * Add a Sun to the level. Only one sun per level.
	 * @param g Game object.
	 */
	public void addSun(Sun s){
		sun = s;
	}
	
	/**
	 * Add a cannon to the level. Only one cannon per level. 
	 * @param g Game object.
	 */
	public void addCannon(Cannon c){
		cann = c;
	}
	
	public Cannon getCannon(){
		return cann;
	}
	
	public ArrayList<Planet> getPlanets(){
		return planets;
	}
	
	public int getLevelNum(){
		return levelNum;
	}
	
	
}
