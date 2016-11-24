package core;

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
	      //fetch student record based on his roll no from the database
	      UserAccount model  = retrieve___FromDatabase();

	      //Create a view : to write student details on console
	      LoginView view = new LoginView();

	      StudentController controller = new StudentController(model, view);

	      controller.updateView();

	      //update model data
	      controller.setStudentName("John");

	      controller.updateView();
	}
	
	   private static Student retrieveStudentFromDatabase(){
		      Student student = new Student();
		      student.setName("Robert");
		      student.setRollNo("10");
		      return student;
		   }

}
