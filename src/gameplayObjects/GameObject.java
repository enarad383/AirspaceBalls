package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

/**Represents any object in the game.
 * 
 * @author enarad383
 *
 */
public class GameObject {
	protected double x, y;
	protected double velX, velY;
	private double r, angle;
	private int centX, centY;
	protected Game game;
	private boolean isVisible;
	
	public GameObject(double x, double y, Game g){
		setPos(x, y);
		centX = g.getCentX();
		centY = g.getCentY();
		game = g;
		isVisible = true;
	}
	
	/** Uses polar coordinates to set the position of the object.
	 * 
	 * @param rad The radius coordinate
	 * @param theta The angle coordinate
	 */
	public void setPosPolar(double rad, double theta){
		double newX, newY = 0;
		newX = rad*Math.cos(theta);
		newY = rad*Math.sin(theta);
		setPos(newX, newY);
	}
	
	/** Uses cartesian coordinates to set the position of the object.
	 * 
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 */
	public void setPos(double x, double y){
		this.x = x;
		this.y = y;
	}
	/** Changes the position of the object.
	 * 
	 * @param x The amount to move in the X direction.
	 * @param y The amount to move in the Y direction.
	 */
	public void changePos(double x, double y){
		this.x += x;
		this.y += y;
	}
	
	/**Sets the velocity of the object.
	 * 
	 * @param x The X-component of the velocity vector.
	 * @param y The Y-component of the velocity vector.
	 */
	public void setVel(double x, double y){
		this.velX = x;
		this.velY = y;
	}
	
	/**Changes the velocity by the given amounts.
	 * 
	 * @param x The x component of the acceleration vector.
	 * @param y The y component of the acceleration vector.
	 */
	public void changeVel(double x, double y){
		this.velX += x;
		this.velY += y;
	}
	
	/**Changes the objects position based on its velocity vector.
	 * 
	 */
	public void act(){
		x+=velX;
		y+=velY;
	}
	
	/** Gets the angle between this object and another gameObject.
	 * 
	 * @param other The other gameObject to find the angle to.
	 * @return The angle between the objects in Radians.
	 */
	public double getAngleTo(GameObject other){
		double ans = Math.atan(distToX(other)/distToY(other)); //problem: only gives answers from -pi/2 to pi/2
		if (distToX(other)>0){ //attempting to solve problem
			ans += Math.PI; //problem solved, thanks stack overflow
		}
		else if (distToY(other)>0){
			ans += 2*Math.PI;
		}
		
		return ans;
	}
	
	/**Returns the linear distance between this and another gameObject.
	 * 
	 * @param other The other gameObject to get distance from.
	 * @return The distance between them directly.
	 */
	public double distanceTo(GameObject other){
		return Math.sqrt(Math.pow(other.x-x, 2)+Math.pow(other.y-y, 2));
	}
	
	/**Gets the X component of the distance vector between this and another gameObject.
	 * 
	 * @param other The other gameObject to find the x distance to.
	 * @return The distance along the x axis to the other gameObject.
	 */
	public double distToX(GameObject other){
		return other.x-x;
	}
	
	/**
	 * 
	 * @return The object's x position.
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * 
	 * @return The object's y position.
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * 
	 * @return The object's x velocity.
	 */
	public double getVelX(){
		return velX;
	}
	
	/**
	 * 
	 * @return The object's y velocity.
	 */
	public double getVelY(){
		return velY;
	}
	
	/**
	 * 
	 * @return Whether or not the object is visible.
	 */
	public boolean isVisible(){
		return isVisible;
	}
	
	/**Sets whether or not the object is visible.
	 * 
	 * @param is The desired visibiltiy.
	 */
	public void setVisible(boolean is){
		isVisible = is;
	}
	
	/**Gets the Y component of the distance vector between this and another gameObject.
	 * 
	 * @param other The other gameObject to find the y distance to.
	 * @return The distance along the y axis to the other gameObject.
	 */
	public double distToY(GameObject other){
		return other.y-y;
	}
	
	public void draw(PApplet p){
		if (isVisible){
			p.ellipseMode(p.CENTER);
			p.fill(255);
			p.ellipse((float)(x), (float)(y), 30, 30);
		}
	}
	
}
