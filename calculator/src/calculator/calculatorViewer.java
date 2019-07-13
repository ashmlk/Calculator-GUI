package calculator;
import javax.swing.*;

public class calculatorViewer {
	public static void main(String[] args) {
		JFrame frame = new calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
