package Menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.ComponentMouseEvent;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.util.Imaging;

public class MenuScreen2 extends Screen implements IUpdateable
{

private static final BufferedImage BG = Imaging.scale(Resources.images().get("menubg1.png"), Game.window().getWidth(), Game.window().getHeight());
private static final BufferedImage BBG = Imaging.scale(Resources.images().get("buttonbg.png"), 240);

  private Menu mainMenuStart;
  private Menu mainMenuMultiplayer;
  private Menu mainMenuOptions;
  private Menu mainMenuExit;

  public MenuScreen() 
  {
    super("MENU");
  }

  @Override
  public void prepare() 
  {
	  
	int fontSize = 50;
    super.prepare();
    Game.loop().attach(this);
    Game.window().getRenderComponent().setBackground(Color.BLACK);
    Game.graphics().setBaseRenderScale(6f * Game.window().getResolutionScale());

    this.mainMenuStart.getCellComponents().forEach(comp -> {
      comp.setTextAntialiasing(true);
      comp.setFontSize(fontSize);
      comp.getAppearance().setForeColor(Color.WHITE);
      comp.getAppearanceHovered().setForeColor(Color.BLACK);
    });
    
    this.mainMenuMultiplayer.getCellComponents().forEach(comp -> {
        comp.setTextAntialiasing(true);
        comp.setFontSize(fontSize);
        comp.getAppearance().setForeColor(Color.WHITE);
        comp.getAppearanceHovered().setForeColor(Color.BLACK);
      });
    
    this.mainMenuOptions.getCellComponents().forEach(comp -> {
        comp.setTextAntialiasing(true);
        comp.setFontSize(fontSize);
        comp.getAppearance().setForeColor(Color.WHITE);
        comp.getAppearanceHovered().setForeColor(Color.BLACK);
      });
    
    this.mainMenuExit.getCellComponents().forEach(comp -> {
        comp.setTextAntialiasing(true);
        comp.setFontSize(fontSize);
        comp.getAppearance().setForeColor(Color.WHITE);
        comp.getAppearanceHovered().setForeColor(Color.BLACK);
      });

    this.mainMenuStart.setEnabled(true);
    this.mainMenuMultiplayer.setEnabled(true);
    this.mainMenuOptions.setEnabled(true);
    this.mainMenuExit.setEnabled(true);
  }

  @Override
  public void render(Graphics2D g) 
  {
    ImageRenderer.render(g, BG, 0, 0);
    
    g.setColor(new Color(26, 47, 4));
    RenderingHints originalHints = g.getRenderingHints();
    TextRenderer.enableTextAntiAliasing(g);
    g.setRenderingHints(originalHints);
    super.render(g);
  }

  @Override
  protected void initializeComponents() {
    super.initializeComponents();
    final double startX = Game.window().getResolution().getWidth() * 0.84;
    final double startY1 = Game.window().getResolution().getHeight()* 0.1;
    final double startY2 = Game.window().getResolution().getHeight()* 0.2;
    final double startY3 = Game.window().getResolution().getHeight()* 0.3;
    final double startY4 = Game.window().getResolution().getHeight()* 0.4;
    final double buttonWidth = 500;

    this.mainMenuStart = new Menu(startX - buttonWidth / 2, startY1 * 1.3, buttonWidth, startY1 / 2, "Singlepalyer");
    this.mainMenuMultiplayer = new Menu(startX - buttonWidth / 2, startY2 * 1.3, buttonWidth, startY2 / 2, "Multiplayer");
    this.mainMenuOptions = new Menu(startX - buttonWidth / 2, startY3 * 1.3, buttonWidth, startY3 / 2, "Options");
    this.mainMenuExit = new Menu(startX - buttonWidth / 2, startY4 * 1.3, buttonWidth, startY4 / 2, "Exit");
    
    Input.mouse().onPressed(event -> {
    	if (mainMenuOptions.isPressed()) OpenSettings();
    });

    this.getComponents().add(this.mainMenuStart);
    this.getComponents().add(this.mainMenuMultiplayer);
    this.getComponents().add(this.mainMenuOptions);
    this.getComponents().add(this.mainMenuExit);
  }
  
  public void OpenSettings()
  {
	  this.mainMenuStart.setEnabled(false);
	  this.mainMenuMultiplayer.setEnabled(false);
	  this.mainMenuOptions.setEnabled(false);
	  this.mainMenuExit.setEnabled(false);
	  
	  Game.window().getRenderComponent().fadeOut(5000);
	  Game.screens().add(new MenuOptions());
	  Game.screens().remove(Game.screens().current());
	  Game.window().getRenderComponent().fadeIn(1500); 
  }
  
  public void OpenMulti()
  {
	  this.mainMenuStart.setEnabled(false);
	  this.mainMenuMultiplayer.setEnabled(false);
	  this.mainMenuOptions.setEnabled(false);
	  this.mainMenuExit.setEnabled(false);
	  
	  Game.window().getRenderComponent().fadeOut(5000);
	  Game.screens().add(new MenuMultiplayer());
	  Game.screens().remove(Game.screens().current());
	  Game.window().getRenderComponent().fadeIn(1500); 
  }
  
  public void ExitGame()
  {
	  this.mainMenuStart.setEnabled(false);
	  this.mainMenuMultiplayer.setEnabled(false);
	  this.mainMenuOptions.setEnabled(false);
	  this.mainMenuExit.setEnabled(false);
	  
	  System.exit(0);
  }

  @Override
  public void update() 
  {

  }
}
