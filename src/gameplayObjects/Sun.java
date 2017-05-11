package gameplayObjects;

import functionality.Game;

public class Sun extends GameObject{
	
	private double mass;

	public Sun(Game g, double mass) {
		super(g.getCentX(), g.getCentY(), g);
		this.mass = mass;
		// TODO Auto-generated constructor stub
	}
	
	public double getMass(){
		return mass;
	}

}
