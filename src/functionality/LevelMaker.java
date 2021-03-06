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
	   Level l5 = new Level(5);
	   Level l6 = new Level(6);
	   Level l7 = new Level(7);
	   
	   
	   l1.addCannon(new Cannon(200, 1, 1));
	   l1.addPlanet(new Goal(200, Math.PI, 20, 20));
	   
	   l2.addCannon(new Cannon(200, 50, 1));
	   l2.addPlanet(new Planet(125, 1, 5, 10));
	   l2.addPlanet(new Planet(400, 0, 30, 20));
	   l2.addPlanet(new Goal(250, -2, 20, 15));
	   
	   l3.addCannon(new Cannon(300, Math.PI/2, 1));
	   l3.addPlanet(new Planet(300, 0, 40, 20));
	   l3.addPlanet(new Planet(150, 1, 20, 10));
	   l3.addPlanet(new Planet(450, -2, 50, 30));
	   l3.addPlanet(new Goal(375, Math.PI, 10, 10));
	   
	   l4.addCannon(new Cannon(400, Math.PI, 1));
	   l4.addPlanet(new Planet(400, 0, 20, 10));
	   l4.addPlanet(new Planet(300, 0, 15, 7.5));
	   l4.addPlanet(new Planet(200, 0, 10, 5));
	   l4.addPlanet(new Planet(100, 0, 5, 2.5));
	   l4.addPlanet(new Goal(200, Math.PI/2, 10, 7));
	   
	   l5.addCannon(new Cannon(400, Math.PI, 1));
	   l5.addPlanet(new Planet(400, 0, 20, 10));
	   l5.addPlanet(new Planet(300, 0, 15, 7.5));
	   l5.addPlanet(new Planet(200, 0, 10, 5));
	   l5.addPlanet(new Planet(100, 0, 5, 2.5));
	   l5.addPlanet(new Planet(460, 0, 26, 25));
	   l5.addPlanet(new Goal(200, Math.PI/2, 10, 7));
	   
	   l6.addCannon(new Cannon(125, Math.PI, 1));
	   l6.addPlanet(new Planet(400, 0, 30, 30));
	   l6.addPlanet(new Planet(300, 0, 33, 36));
	   l6.addPlanet(new Planet(200, 0, 10, 5));
	   l6.addPlanet(new Planet(100, 0, 20, 10));
	   l6.addPlanet(new Planet(460, 0, 26, 25));
	   l6.addPlanet(new Goal(200, Math.PI/2, 10, 7));
	   
	   l7.addCannon(new Cannon(120, 1, 1));
	   l7.addPlanet(new Goal(200, Math.PI, 20, 20));
	   
	   

	   reader.writeObject("level1.bz", l1);
	   reader.writeObject("level2.bz", l2);
	   reader.writeObject("level3.bz", l3);
	   reader.writeObject("level4.bz", l4);
	   reader.writeObject("level5.bz", l5);
	   reader.writeObject("level6.bz", l6);
	   reader.writeObject("level7.bz", l7);
	   
	   //System.out.println("MADE");
	   
	  }
	
	
	
	
}
