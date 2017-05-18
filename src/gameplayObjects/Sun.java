package gameplayObjects;

import java.io.Serializable;

import functionality.Game;
import processing.core.PApplet;

public class Sun extends GameObject implements Serializable{
	
	private double mass;

	public Sun(Game g, double mass) {
		super(0, 0, g);
		this.mass = mass;
		// TODO Auto-generated constructor stub
	}
	
	public double getMass(){
		return mass;
	}
	
	public void draw(PApplet p){
		p.fill(255);
	}

}
