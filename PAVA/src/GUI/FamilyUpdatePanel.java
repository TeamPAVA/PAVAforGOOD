package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FamilyUpdatePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4261502008723939345L;
	private String title;
	private String story;
	private String pathToImage;
	private ImageIcon image;
	
	public FamilyUpdatePanel(int id) {
		super();
		setBackground(Color.GRAY);
		setLayout(new BorderLayout());
		
		if (loadIn(id)) {
			setUp();
		}
		//loadIn();
		//setUp();
	}
	
	public Boolean loadIn(int id) {
		Boolean lineFound = false;
		Scanner fileScanner;
		Scanner lineScanner;
	    try {
	    	fileScanner = new Scanner(new File("famStoriesDatabase.csv"));
	    	while (fileScanner.hasNextLine() && !lineFound) {
	    		lineScanner = new Scanner(fileScanner.nextLine());
	    		lineScanner.useDelimiter(",");
	    		String tempVar = lineScanner.next();
	    		if (tempVar.equals(String.valueOf(id))) {
	    			lineFound = true;
		    		title = lineScanner.next();
		    		story = lineScanner.next();
		    		pathToImage = lineScanner.next();
	    		}
	    	}
	    } catch (FileNotFoundException e1) {
	     e1.printStackTrace();
	   }
	return lineFound;
	}
	
	private void setUp() {
		Font titleFont = new Font("Arial", Font.BOLD,20);
		Font storyFont = new Font("Helvetica", Font.BOLD,14);
		JLabel famPic = new JLabel(new ImageIcon(pathToImage));
		
		JLabel titleLabel = new JLabel(title.toUpperCase());
		JLabel storyLabel = new JLabel("<html><body style='width: 250 px'>" + story);
		
		titleLabel.setFont(titleFont);
		storyLabel.setFont(storyFont);
		
		this.add(famPic, BorderLayout.NORTH);
		this.add(titleLabel, BorderLayout.CENTER);
		this.add(storyLabel, BorderLayout.SOUTH);
	}
}