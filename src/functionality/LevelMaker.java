package functionality;

import javax.swing.JFrame;

import gameplayObjects.*;
import functionality.*;

public class LevelMaker {
	
	public static void main(String[] args)
	  {

	   FileIO reader = new FileIO();
	   Level l1 = new Level(1);
	   Level l2 = new Level(2);
	   Level l3 = new Level(3);
	   Level l4 = new Level(4);
	   
	   l1.addCannon(new Cannon(200, 1, 1));
	   l1.addPlanet(new Goal(200, Math.PI, 10, 20));
	   
	   l2.addCannon(new Cannon(200, 50, 1));
	   l2.addPlanet(new Planet(125, 1, 2, 10));
	   l2.addPlanet(new Planet(400, 0, 15, 20));
	   l2.addPlanet(new Goal(250, -2, 10, 15));
	   
	   l3.addCannon(new Cannon(300, Math.PI, 1));
	   l3.addPlanet(new Planet(300, 0, 20, 20));
	   l3.addPlanet(new Planet(150, 1, 10, 10));
	   l3.addPlanet(new Planet(450, -2, 25, 30));
	   l3.addPlanet(new Goal(375, Math.PI, 5, 10));
	   
	   l4.addCannon(new Cannon(400, Math.PI, 1));
	   l4.addPlanet(new Planet(400, 0, 10, 10));
	   l4.addPlanet(new Planet(300, 0, 7.5, 7.5));
	   l4.addPlanet(new Planet(200, 0, 5, 5));
	   l4.addPlanet(new Planet(100, 0, 2.5, 2.5));
	   l4.addPlanet(new Goal(200, Math.PI/2, 5, 7));

	   reader.writeObject("level1.bz", l1);
	   reader.writeObject("level2.bz", l2);
	   reader.writeObject("level3.bz", l3);
	   reader.writeObject("level4.bz", l4);

	   System.out.println("MADE");
	   
	  }
	
	
	
	
}
