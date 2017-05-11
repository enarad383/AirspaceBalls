package functionality;


import java.awt.Dimension;

import javax.swing.JFrame;


import processing.awt.PSurfaceAWT;

public class Main {

	public static void main(String[] args) {
		//drawing.runSketch(); //removed because runSketch can only be called from PApplet
		Game game = new Game();
		PSurfaceAWT surf = (PSurfaceAWT) game.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		window.setMinimumSize(new Dimension(100,100));
		window.setSize(1920, 1040);
		window.setLocation(0,0);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		window.setResizable(true);
		
		GameHUD hud = new GameHUD();
		window.add(hud);
=======
		window.setResizable(false);
>>>>>>> branch 'master' of https://github.com/enarad383/AirspaceBalls.git

		window.setVisible(true);
	}

	
	
}
