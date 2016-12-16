package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5958726568815914406L;

	private class FamilyUpdatePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4261502008723939345L;
		private int userStoryID;
		private String title;
		private String story;
		private String pathToImage;
		private ImageIcon image;
		
		public FamilyUpdatePanel(int id) {
			super();
			userStoryID = id;
			setBackground(Color.GRAY);
			setLayout(new BorderLayout());
			
			if (loadIn()) {
				setUp();
			}
			//loadIn();
			//setUp();
		}
		
		public Boolean loadIn() {
			Boolean lineFound = false;
			Scanner fileScanner;
			Scanner lineScanner;
		    try {
		    	fileScanner = new Scanner(new File("famStoriesDatabase.csv"));
		    	while (fileScanner.hasNextLine() && !lineFound) {
		    		lineScanner = new Scanner(fileScanner.nextLine());
		    		lineScanner.useDelimiter(",");
		    		String tempVar = lineScanner.next();
		    		if (tempVar.equals(String.valueOf(userStoryID))) {
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

	public HomePanel() {
		super();
		this.setPreferredSize(new Dimension(1024,768));
		setBackground(Color.GRAY);
		setLayout(new BorderLayout());
		
		setUp();
	}

	public void setUp() {
		
		FamilyUpdatePanel west = new FamilyUpdatePanel(1);
		FamilyUpdatePanel center = new FamilyUpdatePanel(2);
		FamilyUpdatePanel east = new FamilyUpdatePanel(3);
		west.setBorder(BorderFactory.createEmptyBorder(100,25,170,0));
		center.setBorder(BorderFactory.createEmptyBorder(100,0,170,0));
		east.setBorder(BorderFactory.createEmptyBorder(100,0,170,25));
		this.add(west, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(east, BorderLayout.EAST);
	}

}
