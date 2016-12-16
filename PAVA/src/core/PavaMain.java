package core;

import java.awt.EventQueue;

import GUI.LoginFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class PavaMain.
 * @author Adrian
 */
public final class PavaMain {
	
	/**
	 * Instantiates a new pava main.
	 */
	private PavaMain() {
		throw new AssertionError("Instantiating utility class...");
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(() -> {
			LoginFrame ex = new LoginFrame();
            ex.setVisible(true);
        });
	}
}
