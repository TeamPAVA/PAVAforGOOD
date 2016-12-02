package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5151041547543472432L;
	public Frame() {
		super();
		setLocationRelativeTo(null);
		setSize(700,700);
		createMenuBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 private void createMenuBar() {

	        JMenuBar menubar = new JMenuBar();
	        JButton login = new JButton("Login");
	        JButton about = new JButton("About");
	        
	        menubar.add(login);
	        menubar.add(about);
	        login.setMnemonic(KeyEvent.VK_L);

	        menubar.add(Box.createHorizontalGlue());
	        login.setMnemonic(KeyEvent.VK_E);
	        login.setToolTipText("Exit application");
	 
	        
	        login.addActionListener((ActionEvent event) -> {
	            System.exit(0);
	        });

	        menubar.add(login);

	        setJMenuBar(menubar);
	        setVisible(true);
	    }
	

	
}