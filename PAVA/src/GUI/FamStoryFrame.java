package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Frame for family updates
 * @author Adrian
 *
 */
public class FamStoryFrame extends JFrame {

	File imageFile;
	public FamStoryFrame() {
		setLocationRelativeTo(null);
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
		JTextField titleBox = new JTextField("", 10);
		add(titleBox, c);

		c.gridx = 0;
		c.gridy = 1;
		JLabel storyLabel = new JLabel("Write your Story: ");
		add(storyLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		JTextField storyBox = new JTextField("", 20);
		add(storyBox, c);

		c.gridx = 0;
		c.gridy = 2;
		JLabel imageLabel = new JLabel("Add an Image: ");
		add(imageLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		JButton imageChooserButton = new JButton("Open a File...");
		imageChooserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				//final FileNameExtensionFilter ff = new FileNameExtensionFilter(title, null);
				fc.setMultiSelectionEnabled(false);
				//fc.setFileFilter(ff);

				//Handle open button action.
				int returnVal = fc.showOpenDialog(FamStoryFrame.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					imageFile = fc.getSelectedFile();
				}
			}

		});
		add(imageChooserButton, c);

		
		c.gridx = 0;
		c.gridy = 3;
		JButton submitButton = new JButton("Submit");
		
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter w = new FileWriter("famStoriesDatabase.csv", true);
					StringBuilder sb = new StringBuilder();
					if (!titleBox.getText().isEmpty() && !storyBox.getText().isEmpty()) {
						//sb.append(nextNum);
						sb.append(',');
						sb.append(titleBox.getText());
						sb.append(',');
						sb.append(storyBox.getText());
						sb.append(',');
						sb.append("famStories/");
						sb.append(imageFile.getName());
						sb.append('\n');
						w.write(sb.toString());
						w.close();
					}
				} catch (FileNotFoundException e1) {
									//if cant find file, do this
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		
		add(submitButton, c);
		
		c.gridx = 1;
		c.gridy = 3;
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
		add(cancelButton, c);
	}
}
