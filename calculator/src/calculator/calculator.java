/**
* @author Arshia Malekahmadi 2019
*
*/

package calculator;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 

@SuppressWarnings("serial")
public class calculator extends JFrame {
	
	final static int FRAME_WIDTH = 300;
	final static int FRAME_LENGTH = 500;
	
	private JButton b0 = new JButton("0");
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton bAdd = new JButton("+");
	private JButton bSub = new JButton("-");
	private JButton bMul = new JButton("x");
	private JButton bDiv = new JButton("/");
	private JButton bSqrt = new JButton("sqrt");
	private JButton bPow = new JButton("^");
	private JButton bEq = new JButton("=");
	private JButton bDec = new JButton(".");
	private JButton bClr = new JButton("C");
	private JButton bDel = new JButton("Del");
	
	private char operator;
	
	private JTextArea resultField = new JTextArea(2,28);
	
	public calculator() {
		resultField.setEditable(false);
		start();
		setSize(FRAME_WIDTH, FRAME_LENGTH);
		}
	
	public void start() {
	JPanel resultPanel = new JPanel();
	JPanel calculatorPanel = new JPanel();
	
	b0.setPreferredSize(new Dimension(25,25));
	b1.setPreferredSize(new Dimension(25,25));
	b2.setPreferredSize(new Dimension(25,25));
	b3.setPreferredSize(new Dimension(25,25));
	b4.setPreferredSize(new Dimension(25,25));
	b5.setPreferredSize(new Dimension(25,25));
	b6.setPreferredSize(new Dimension(25,25));
	b7.setPreferredSize(new Dimension(25,25));
	b8.setPreferredSize(new Dimension(25,25));
	b9.setPreferredSize(new Dimension(25,25));
	bAdd.setPreferredSize(new Dimension(25,25));
	bSub.setPreferredSize(new Dimension(25,25));
	bMul.setPreferredSize(new Dimension(25,25));
	bDiv.setPreferredSize(new Dimension(25,25));
	bSqrt.setPreferredSize(new Dimension(25,25));
	bPow.setPreferredSize(new Dimension(25,25));
	bEq.setPreferredSize(new Dimension(25,25));
	bDec.setPreferredSize(new Dimension(25,25));
	bClr.setPreferredSize(new Dimension(25,25));
	bDel.setPreferredSize(new Dimension(25,25));
	
	resultPanel.setBackground(Color.GRAY);
	calculatorPanel.setLayout(new GridLayout(5,4,5,5));
	
	resultPanel.add(resultField);
	calculatorPanel.add(b7);
	calculatorPanel.add(b8);
	calculatorPanel.add(b9);
	calculatorPanel.add(bMul);
	calculatorPanel.add(b4);
	calculatorPanel.add(b5);
	calculatorPanel.add(b6);
	calculatorPanel.add(bDiv);
	calculatorPanel.add(b1);
	calculatorPanel.add(b2);
	calculatorPanel.add(b3);
	calculatorPanel.add(bAdd);
	calculatorPanel.add(bClr);
	calculatorPanel.add(b0);
	calculatorPanel.add(bEq);
	calculatorPanel.add(bSub);
	calculatorPanel.add(bDel);
	calculatorPanel.add(bDec);
	calculatorPanel.add(bPow);
	calculatorPanel.add(bSqrt);
	
	
	getContentPane().add(BorderLayout.NORTH,resultPanel);
	getContentPane().add(BorderLayout.CENTER,calculatorPanel);

	b0.addActionListener(new NumberActionListener("0"));
	b1.addActionListener(new NumberActionListener("1"));
	b2.addActionListener(new NumberActionListener("2"));
	b3.addActionListener(new NumberActionListener("3"));
	b4.addActionListener(new NumberActionListener("4"));
	b5.addActionListener(new NumberActionListener("5"));
	b6.addActionListener(new NumberActionListener("6"));
	b7.addActionListener(new NumberActionListener("7"));
	b8.addActionListener(new NumberActionListener("8"));
	b9.addActionListener(new NumberActionListener("9"));
	bAdd.addActionListener(new CalculatorActionListener('+'));
	bSub.addActionListener(new CalculatorActionListener('-'));
	bMul.addActionListener(new CalculatorActionListener('x'));
	bDiv.addActionListener(new CalculatorActionListener('/'));
	bSqrt.addActionListener(new SqrtActionListener());
	bPow.addActionListener(new CalculatorActionListener('^'));
	bEq.addActionListener(new EqualActionListener());
	bDec.addActionListener(new NumberActionListener("."));
	bClr.addActionListener(new ClearActionListener());
	bDel.addActionListener(new DeleteActionListener());
	}		
	
	class NumberActionListener implements ActionListener {
		private String value;
		
		public NumberActionListener(String b) {
		 this.value = b;
		}
		
		public void actionPerformed(ActionEvent event) {
			resultField.append(value.toString());
		}
	}
	class CalculatorActionListener implements ActionListener {
		private char optr;
			
		public CalculatorActionListener(char o) {
			this.optr = o;
		}
			
		public void actionPerformed(ActionEvent event) {
			resultField.append(optr+"".toString());
			operator = optr;
		}	
	}
	class SqrtActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String num1;
			try {
				num1 = resultField.getText().substring(0,resultField.getText().indexOf(operator+""));
				resultField.setText("");
				resultField.append(sqrt(Double.parseDouble(num1))+"".toString());
			}catch (Exception e) {
		}	
	  }
	}
	class ClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				resultField.setText("");				
		}
	}
	class DeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				resultField.setText(resultField.getText().substring(0,resultField.getText().length()-1));				
		}
	}
	class EqualActionListener implements ActionListener {
		String num1;
		String num2;
		
		public void actionPerformed(ActionEvent event) {
			try {
			num1 = resultField.getText().substring(0,resultField.getText().indexOf(operator+""));
			num2 = resultField.getText().substring(resultField.getText().indexOf(operator+"")+1,resultField.getText().length());
			switch(operator) {
			case '+':
				resultField.setText("");
				resultField.append((addNum(Double.parseDouble(num1), Double.parseDouble(num2))+"".toString()));
				break;
			case '-':
				resultField.setText("");
				resultField.append((subtract(Double.parseDouble(num1), Double.parseDouble(num2))+"".toString()));
				break;
			case 'x':
				resultField.setText("");
				resultField.append((multiply(Double.parseDouble(num1), Double.parseDouble(num2))+"".toString()));
				break;
			case '/':
				resultField.setText("");
				resultField.append((divide(Double.parseDouble(num1), Double.parseDouble(num2))+"".toString()));
				break;
			case '^':
				resultField.setText("");
				resultField.append((power(Double.parseDouble(num1), Double.parseDouble(num2))+"".toString()));
				break;
			default:
				resultField.setText("");
				resultField.setText("Err");
			}	
		}catch (Exception e) {	
		}
	}
}
	public double addNum(double n1, double n2) {
		return n1+n2;
	}
	public double subtract(double n1, double n2) {
		return n1-n2;
	}
	public double divide(double n1, double n2) {
		return n1/n2;
	}
	public double multiply(double n1, double n2) {
		return n1*n2;
	}
	public double power(double n1, double n2) {
		return Math.pow(n1, n2);
	}
	public double sqrt(double n1) {
		return Math.sqrt(n1);
	}
	
}


