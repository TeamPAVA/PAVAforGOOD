package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Panel class for the Donor Panel
 * 
 * @author Patrick Stevens
 */
public class DonorPanel extends JPanel {

	private static final long serialVersionUID = 4761523114634863561L;
	public JTextField name;
	public JTextField cNum = new JTextField("", 10);
	public JTextField expDate;
	public JTextField cvc;
	public JTextField zip;
	private String username;
	private boolean hasBeenPushed;;
	String[] users;
	File donors;
	FileWriter w; 
	List<String[]> csvBody;
	StringBuilder sb = new StringBuilder();

	public DonorPanel(String username) {
		super();
		hasBeenPushed = false;
		setBackground(Color.GRAY);
		this.username = username;
		donors = new File("donorDatabase.csv");
		try {
			w = new FileWriter(donors, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUp();
	}

	private void setUp() {
		JPanel initial = new JPanel();
		JPanel initial2 = new JPanel();
		initial.setLayout(new BorderLayout());
		initial2.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();

		JLabel helpText = new JLabel("How much can you help today?");

		Font labelFont = helpText.getFont();
		helpText.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));

		JTextField donateAmount = new JTextField("$", 10);
		donateAmount.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));

		JButton newCard = new JButton("New Card");
		newCard.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		newCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hasBeenPushed = true;
				name = new JTextField("", 7);
				cNum = new JTextField("", 10);
				expDate = new JTextField("", 6);
				cvc = new JTextField("");
				zip = new JTextField("");

				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(0, 2));
				panel.add(new JLabel("Name on card:"));
				panel.add(name);
				panel.add(new JLabel("Card number:"));
				panel.add(cNum);
				panel.add(new JLabel("Exp. Date:"));
				panel.add(expDate);
				panel.add(new JLabel("Security Code:"));
				panel.add(cvc);
				panel.add(new JLabel("Zip Code:"));
				panel.add(zip);

				String database;
				
				try {
					
					BufferedReader fileScanner = new BufferedReader(new FileReader(donors));
					while ((database = fileScanner.readLine()) != null) {
						users = database.split(",");
			
						if (users[0].equals(username)) {
							users[1] = users[1];
							users[2] = users[2];
							break;
						}
					}
					fileScanner.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				JOptionPane.showMessageDialog(null, panel, "New Card Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton currCard = new JButton("Card on File");
		currCard.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		currCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(hasBeenPushed == false) {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(0, 2));
					//READ FROM CSV
					JLabel name1;
					JLabel cNum1;
					JLabel expDate1;
					JLabel cvc1;
					JLabel zip1;
					name1 = new JLabel();
					cNum1 = new JLabel();
					expDate1 = new JLabel();
					cvc1 = new JLabel();
					zip1 = new JLabel();

					panel.setLayout(new GridLayout(0, 2));
					panel.add(new JLabel("Name on card:"));
					panel.add(name1);
					panel.add(new JLabel("Card number:"));
					panel.add(cNum1);
					panel.add(new JLabel("Exp. Date:"));
					panel.add(expDate1);
					panel.add(new JLabel("Security Code:"));
					panel.add(cvc1);
					panel.add(new JLabel("Zip Code:"));
					panel.add(zip1);

					String database;
					try {
						BufferedReader fileScanner = new BufferedReader(new FileReader(donors));
						
						while ((database = fileScanner.readLine()) != null) {
							String[] users = database.split(",");
							if (users[0].equals(username)) {
								
								name1.setText(users[3]);
								cNum1.setText(users[4]);
								expDate1.setText(users[5]);
								cvc1.setText(users[6]);
								zip1.setText(users[7]);

							}
						}
						fileScanner.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					JOptionPane.showMessageDialog(null, panel, "Card Information", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(0, 2));
					// panel.add(new JButton("Click"));
					panel.add(new JLabel("Name on card:"));
					panel.add(new JLabel(name.getText()));
					panel.add(new JLabel("Card number:"));
					panel.add(new JLabel(cNum.getText()));
					panel.add(new JLabel("Exp. Date:"));
					panel.add(new JLabel(expDate.getText()));
					panel.add(new JLabel("Security Code:"));
					panel.add(new JLabel(cvc.getText()));
					panel.add(new JLabel("Zip Code:"));
					panel.add(new JLabel(zip.getText()));
					
					JOptionPane.showMessageDialog(null, panel, "Card Information", JOptionPane.INFORMATION_MESSAGE);
				}
				
			
			}
		});

		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

		submit.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				String amount = donateAmount.getText().substring(1);
				double donAmount = Integer.parseInt(amount);
				recipientData(donAmount);
				try {
			    	BufferedReader donorScanner = new BufferedReader(new FileReader(donors));
			        String donorData;
			        String donorInfo = "";
			        while((donorData = donorScanner.readLine()) != null) {
			        	String[] donors = donorData.split(",");
			        		double donation = Double.parseDouble(donors[2]);
				        	if (donors[0].equals(username)) {
				        		donation += donAmount;
				        		donorInfo = donorInfo + donors[0] + "," + donors[1] + "," +  donation + "," + donors[3] + "," +  donors[4] 
				        				+ "," +  donors[5] + "," + donors[6] + "," +  donors[7];
				        	} else {
				        		donorInfo = donorInfo + donors[0] + "," + donors[1] + "," +  donation + "," + donors[3] + "," +  donors[4] 
			        				+ "," +  donors[5] + "," + donors[6] + "," +  donors[7];
				        	}
			        	donorInfo = donorInfo + "\n";
			        }
			        FileWriter donorWriter = new FileWriter("donorDatabase.csv", false);
					donorWriter.write(donorInfo);		
					donorWriter.close();			
			        donorScanner.close();
			   } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			   }		
				JOptionPane.showMessageDialog(initial2, "Thank you for your donation!");
			}
		});

		north.add(helpText, BorderLayout.NORTH);

		center.add(donateAmount, BorderLayout.WEST);
		south.add(newCard, BorderLayout.CENTER);
		south.add(currCard, BorderLayout.NORTH);

		initial2.add(submit, BorderLayout.SOUTH);

		initial.add(north, BorderLayout.NORTH);
		initial.add(center, BorderLayout.CENTER);
		initial.add(south, BorderLayout.SOUTH);

		initial2.add(initial, BorderLayout.NORTH);

		initial.setPreferredSize(new Dimension(475, 200));

		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		add(initial2, BorderLayout.CENTER);
	}
	
	public void recipientData(Double donation) {
		int recCount = 0;
		try {
	    	BufferedReader fileScanner = new BufferedReader(new FileReader("recipientDatabase.csv"));	
	        String database;
	        while((database = fileScanner.readLine()) != null){
	        	recCount++;
	        }
	        fileScanner.close();
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		double amountPerRec = donation / recCount;
		//parse through recipieient and add amount per rec to their total amount
		try {
	    	BufferedReader fileScanner = new BufferedReader(new FileReader("recipientDatabase.csv"));	
	        String database = "";
	        String line;      
	        while((line = fileScanner.readLine()) != null) {
	        	String[] users = line.split(",");
	        	double amt = Double.parseDouble(users[2]) + amountPerRec;
	        	database = database + users[0] + "," + users[1] + "," +  amt + "\n";			        	
	        }
	        FileWriter writeRecipient = new FileWriter("recipientDatabase.csv", false);
	        writeRecipient.write(database);		
			writeRecipient.close();
			 fileScanner.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	   }
	}
}
