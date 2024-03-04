package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;
import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP_ARROW:
		case KeyEvent.VK_LEFT_ARROW:
		case KeyEvent.VK_DOWN_ARROW:
		case KeyEvent.VK_RIGHT_ARROW:
			gamePanel.setMoving(false);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP_ARROW:
			gamePanel.setDirection(UP);
			break;
		case KeyEvent.VK_LEFT_ARROW:
			gamePanel.setDirection(LEFT);
			break;
		case KeyEvent.VK_DOWN_ARROW:
			gamePanel.setDirection(DOWN);
			break;
		case KeyEvent.VK_RIGHT_ARROW:
			gamePanel.setDirection(RIGHT);
			break;
		}
	}
}
