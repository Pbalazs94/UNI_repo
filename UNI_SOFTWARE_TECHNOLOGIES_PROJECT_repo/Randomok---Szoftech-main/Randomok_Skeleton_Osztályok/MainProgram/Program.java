package MainProgram;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;

import Menu.MenuScreen2;

public class Program {

	public static void main(String[] args) 
	{
		Game.info().setName("Train Simulator");
		Game.info().setSubTitle("");
		Game.info().setVersion("v0.0.1");
		Game.info().setDescription("A train economy simulator made in the LITIENGINE");
		
		Game.init(args);
		
		Game.window().setIcon(Resources.images().get("icon.png"));
		Game.graphics().setBaseRenderScale(10f);
		
		Resources.load("game.litidata");
		
		Game.screens().add(new MenuScreen2());
		
		Game.start();
	}

}
