package functionality;

import javax.swing.JFrame;

public class LevelMaker {
	
	
	
	
	
	
	public static void main(String[] args)
	  {
	   Game g = new Game();
	   Level make = new Level(1);
	   //make.addSun(g);
	   //make.addCannon(g);
	   make.addPlanet(125, 1, g, 2, 10);
	   //make.addPlanet(400, 0, g, 15, 20);
	   //make.addPlanet(250, -Math.PI*3/2, g, 10, 15);
	   //make.addPlanet(400, 0, new Game(), 15, 20);
	   
	   System.out.println("MADE");
	   
	   make.saveState();
	   
	    
	  }
	
	
	
	
}
