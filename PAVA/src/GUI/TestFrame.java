package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6757203992482711906L;

	public TestFrame() {
		super();
		setTitle("PAVAP");
		setLocationRelativeTo(null);
		setResizable(true);
		//createMenuBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createScreen();
		this.pack();
		
	}

	private void createScreen() {
		HomePanel initial = new HomePanel();
		this.add(initial, BorderLayout.CENTER);
	}
}
