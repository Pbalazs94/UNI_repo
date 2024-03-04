package Menu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.util.Imaging;

public class MenuOptions extends Screen implements IUpdateable 
{

	private static final BufferedImage BG = Imaging.scale(Resources.images().get("menubg.png"), Game.window().getWidth(), Game.window().getHeight());
	private static final BufferedImage test = Resources.images().get("icon.png");
	
	final File settingsfile = new File("config.properties");
	
	private Menu OptBack;
	private Menu IconPress;
	  public MenuOptions() 
	  {
		    super("MENU");
		  }

		  @Override
		  public void prepare() 
		  {
			Game.loop().attach(this);
		    super.prepare();
		    
		    this.OptBack.getCellComponents().forEach(comp -> {
		    	comp.setFontSize(50);
		    });
		    
		    OptBack.setEnabled(true);
		  }

		  @Override
		  public void render(Graphics2D g) 
		  {
			ImageRenderer.render(g, BG, 0, 0);
		    super.render(g);
		  }

		  @Override
		  protected void initializeComponents() 
		  {
		    super.initializeComponents();
		    final double startX = Game.window().getResolution().getWidth() / 2;
		    final double startY1 = Game.window().getResolution().getHeight()* 0.5;
		    final double startY2 = Game.window().getResolution().getHeight()* 0.6;
		    final double buttonWidth = 500;
		    
		    this.IconPress = new Menu(startX - buttonWidth / 2, startY2 * 1.3, buttonWidth, startY1 / 2);
		    this.OptBack = new Menu(startX - buttonWidth / 2, startY1 * 1.3, buttonWidth, startY1 / 2, "Back");
		    
		    Input.mouse().onPressed(event -> {
		    	if (OptBack.isHovered()) BackMain();
		    });
		    
		    this.getComponents().add(this.IconPress);
		    this.getComponents().add(this.OptBack);
		  }

		@Override
		public void update() 
		{		
		}
		
		public void BackMain()
		{
			OptBack.setEnabled(false);
			
			Game.window().getRenderComponent().fadeOut(2500);
			Game.screens().add(new MenuScreen2());
			Game.screens().remove(Game.screens().current());
			Game.window().getRenderComponent().fadeIn(1500);
		}
}
