package core;

import java.awt.EventQueue;

import GUI.Frame;

// TODO: Auto-generated Javadoc
/**
 * The Class PavaMain.
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
	      //fetch user record from the "database"
	      User model  = retrieveUserFromDatabase();

	      //Create a view : to write User details on console
	      UserView view = new UserView();

	      UserController controller = new UserController(model, view);

	      controller.updateView();

	      //update model data
	      controller.setUserName("John");

	      controller.updateView();
	      

		EventQueue.invokeLater(() -> {
            Frame ex = new Frame();
            ex.setVisible(true);
        });


	}
	
	private static User retrieveUserFromDatabase() {
		User user = new User();
		user.setName("Robert");
		user.setAnnualIncome(35000);
		return user;
	}

}
