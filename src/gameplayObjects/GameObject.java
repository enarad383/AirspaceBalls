package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

public class GameObject {
	double x, y;
	double velX, velY;
	double r, angle;
	int centX, centY;
	Game game;
	
	public GameObject(double x, double y, Game g){
		setPos(x, y);
		centX = g.getCentX();
		centY = g.getCentY();
		game = g;
	}
	
	public void setPosPolar(double rad, double theta){
		double newX, newY = 0;
		newX = rad*Math.cos(theta);
		newY = rad*Math.sin(theta);
		setPos(newX, newY);
	}
	
	public void setPos(double x, double y){
		this.x = x;
		this.y = y;
	}
	public void changePos(double x, double y){
		this.x += x;
		this.y += y;
	}
	
	public void setVel(double x, double y){
		this.velX = x;
		this.velY = y;
	}
	public void changeVel(double x, double y){
		this.velX += x;
		this.velY += y;
	}
	public void act(){
		x+=velX;
		y+=velY;
	}
	public double distanceTo(GameObject other){
		return Math.sqrt(Math.pow(other.x-x, 2)+Math.pow(other.y-y, 2));
	}
	public double distToX(GameObject other){
		return x-other.x;
	}
	public double distToY(GameObject other){
		return y-other.y;
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(255);
		p.ellipse((float)(x), (float)(y), 30, 30);
	}
	
}
