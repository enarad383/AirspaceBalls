package gameplayObjects;

import java.io.Serializable;

import functionality.Game;
import processing.core.PApplet;


/**Represents a sun object that is the center of the solar system.
 * 
 * @author enarad383
 *
 */
public class Sun extends GameObject implements Serializable{

	
	private double mass;

	/**Constructs a sun object.
	 * 
	 * @param g The game to calculate relations with.
	 * @param mass The mass of the sun.
	 */
	public Sun(double mass) {
		super(0, 0);
		this.mass = mass;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return The mass of the sun, used for gravity.
	 */
	public static double getMass(){
		return 190;
	}
	
	public void draw(PApplet p){
		p.fill(255);
	}

}
