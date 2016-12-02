package GUI;
import java.awt.EventQueue;

public class FrameMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            Frame ex = new Frame();
            ex.setVisible(true);
        });
		
	}
}
