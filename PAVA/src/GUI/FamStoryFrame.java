package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FamStoryFrame extends JFrame {

	public FamStoryFrame() {
		setSize(400,550);
		try {
        	setIconImage(ImageIO.read(getClass().getResource("/p.png"))); // http://wiro.donweb-homeip.net/p-2/
        } catch (IOException e) {
        	
        }
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		JLabel titleLabel = new JLabel("Title: ");
		add(titleLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		JTextField titleBox = new JTextField("Add a Title");
		add(titleBox, c);
		
		c.gridx = 0;
		c.gridy = 1;
		JLabel storyLabel = new JLabel("Title: ");
		add(storyLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		JTextField storyBox = new JTextField("Add a Story");
		add(storyBox, c);
		
		
		setLocationRelativeTo(null);
	}
}
