package rmi_calculator_client;

import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import rmi_calculator_interface.Interface;

// William Wall @ williamwall.ie

public class Client extends JFrame implements Interface {

	// declare scroll pane for the output and answer field to sit into
	private JScrollPane scroll;

	// declare private variable for the font style
	private Font answerFont;

	// declare private jlable for GUI title
	private JLabel titleLabel;

	// declare private jpanel
	private JPanel clientPane;

	// declare private jtextfield for answer output
	private JTextField answerField;

	// declare private jtextarea area for server communication view
	private JTextArea consoleArea;

	// declare private integer for client number identification
	private int clientInstanceNumber;

	public Client() {

		// refactoring / call unique client number method
		uniqueClientInstatiation();

		// refactoring / call component instantiation method
		componentInstantiation();

		// refactoring / call button instantiation method with all button functionality
		buttonsInstantiation();

	}

	private void uniqueClientInstatiation() {
		// instantiate a private number variable
		Random randomNumber = new Random();

		// equal the random number to the instance number declared above
		clientInstanceNumber = randomNumber.nextInt(1000);
	}

	private void componentInstantiation() {
		// instantiate the jpanel
		clientPane = new JPanel();

		// set the border for the pane
		clientPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// set the pane
		setContentPane(clientPane);

		// set the layout to null
		clientPane.setLayout(null);

		// instantiate the jlabel and set the title
		titleLabel = new JLabel("RMI Calculator");

		// style the font and size it
		titleLabel.setFont(new Font("Verdana", 1, 25));

		// set the the position through x / y coordinates and the height and width of
		// the component
		titleLabel.setBounds(20, 10, 400, 20);

		// center the label
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// add the label to the pane
		clientPane.add(titleLabel);

		// instantiate the answer field
		answerField = new JTextField();

		// instantiate the font for the answer field and set size, type and bold style
		answerFont = new Font("SansSerif", Font.BOLD, 20);

		// set the font to the answer field
		answerField.setFont(answerFont);

		// set a border for the answer field
		answerField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));

		// set the the position through x / y coordinates and the height and width of
		// the component
		answerField.setBounds(30, 40, 340, 81);

		// center the answer field in the gui
		answerField.setHorizontalAlignment(SwingConstants.CENTER);

		// turn on editing the answer field
		answerField.setEditable(false);

		// add the answer field to the pane
		clientPane.add(answerField);

		// set the number of columns for the answer field
		answerField.setColumns(10);

		// instantiate the console text area
		consoleArea = new JTextArea();

		// set a border to the console area
		consoleArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

		// set editable to false
		consoleArea.setEditable(false);

		// set the columns size
		consoleArea.setColumns(10);

		// instantiate the scroll pane and insert the console area into it for display
		// of output in a scrolling fashion
		scroll = new JScrollPane(consoleArea);

		// set the the position through x / y coordinates and the height and width of
		// the component
		scroll.setBounds(29, 580, 340, 100);

		// add the scroll pane with the answer field embedded to the main pane
		clientPane.add(scroll);

		// set to dispose over exit for single client exit assurance
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// hits the addition method from the server through the interface and pass in
	// the variables into the server
	public int addition(int num1, int num2, int clientNo) {
		int value = 0;
		try {
			// create lookup variable
			String ServerURL = "rmiCalculatorServer";
			// instantiate the interface and pass lookup variable declared above
			Interface CI = (Interface) Naming.lookup(ServerURL);
			// the value is equal to the response from server
			value = CI.addition(num1, num2, clientNo);
			// return the value
			return value;
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
		return value;
	}

	// hits the subtraction method from the server through the interface and pass in
	// the variables into the server
	public int subtraction(int num1, int num2, int clientNo) {
		int value = 0;
		try {
			// create lookup variable
			String ServerURL = "rmiCalculatorServer";
			// instantiate the interface and pass lookup variable declared above
			Interface CI = (Interface) Naming.lookup(ServerURL);
			// the value is equal to the response from server
			value = CI.subtraction(num1, num2, clientNo);
			// return the value
			return value;
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
		return value;

	}

	// hits the multiplication method from the server through the interface and pass
	// in the variables into the server
	public int multiplication(int num1, int num2, int clientNo) {
		int value = 0;
		try {
			// create lookup variable
			String ServerURL = "rmiCalculatorServer";
			// instantiate the interface and pass lookup variable declared above
			Interface CI = (Interface) Naming.lookup(ServerURL);
			// the value is equal to the response from server
			value = CI.multiplication(num1, num2, clientNo);
			// return the value
			return value;
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
		return value;

	}

	// hits the division method from the server through the interface and pass in
	// the variables into the server
	public int division(int num1, int num2, int clientNo) {
		int value = 0;
		try {
			// create lookup variable
			String ServerURL = "rmiCalculatorServer";
			// instantiate the interface and pass lookup variable declared above
			Interface CI = (Interface) Naming.lookup(ServerURL);
			// the value is equal to the response from server
			value = CI.division(num1, num2, clientNo);
			// return the value
			return value;
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
		return value;

	}

	private void buttonsInstantiation() {

		// button instance for the number seven
		JButton button_7 = new JButton("7");
		// set black border
		button_7.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_7.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 7
				answer = answer + "7";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_7.setBounds(116, 130, 80, 80);
		// add button to the pane
		clientPane.add(button_7);

		// ----------------------------------------------------------------------------------------

		// button instance for the number four
		JButton button_4 = new JButton("4");
		// set black border
		button_4.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_4.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 4
				answer = answer + "4";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_4.setBounds(116, 220, 80, 80);
		// add button four to the pane
		clientPane.add(button_4);

		// ----------------------------------------------------------------------------------------

		// button instance for the number one
		JButton button_1 = new JButton("1");
		// set black border
		button_1.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_1.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 1
				answer = answer + "1";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_1.setBounds(116, 310, 80, 80);
		// add button one to the pane
		clientPane.add(button_1);

		// ----------------------------------------------------------------------------------------

		// button instance for the number zero
		JButton button_0 = new JButton("0");
		// set black border
		button_0.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_0.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 0
				answer = answer + "0";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_0.setBounds(116, 400, 80, 80);
		// add button zero to the pane
		clientPane.add(button_0);

		// ----------------------------------------------------------------------------------------

		// button instance for the number eight
		JButton button_8 = new JButton("8");
		// set black border
		button_8.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_8.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 8
				answer = answer + "8";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_8.setBounds(203, 130, 80, 80);
		// add button eight to the pane
		clientPane.add(button_8);

		// ----------------------------------------------------------------------------------------

		// button instance for the number five
		JButton button_5 = new JButton("5");
		// set black border
		button_5.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_5.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 5
				answer = answer + "5";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_5.setBounds(203, 220, 80, 80);
		// add button five to the pane
		clientPane.add(button_5);

		// ----------------------------------------------------------------------------------------

		// button instance for the number two
		JButton button_2 = new JButton("2");
		// set black border
		button_2.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_2.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 2
				answer = answer + "2";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_2.setBounds(203, 310, 80, 80);
		// add button two to the pane
		clientPane.add(button_2);

		// ----------------------------------------------------------------------------------------

		// button instance for the number nine
		JButton button_9 = new JButton("9");
		// set black border
		button_9.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_9.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 9
				answer = answer + "9";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_9.setBounds(290, 130, 80, 80);
		// add button nine to the pane
		clientPane.add(button_9);

		// ----------------------------------------------------------------------------------------

		// button instance for the number six
		JButton button_6 = new JButton("6");
		// set black border
		button_6.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_6.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 9
				answer = answer + "6";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_6.setBounds(290, 220, 80, 80);
		// add button six to the pane
		clientPane.add(button_6);

		// ----------------------------------------------------------------------------------------

		// button instance for the number three
		JButton button_3 = new JButton("3");
		// set black border
		button_3.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		button_3.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of 3
				answer = answer + "3";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		button_3.setBounds(290, 310, 80, 80);
		// add button three to the pane
		clientPane.add(button_3);

		// ----------------------------------------------------------------------------------------

		// button instance for the divide operand
		JButton buttonDivide = new JButton("/");
		// set black border
		buttonDivide.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		buttonDivide.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		buttonDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of /
				answer = answer + "/";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonDivide.setBounds(29, 130, 80, 80);
		// add button divide to the pane
		clientPane.add(buttonDivide);

		// ----------------------------------------------------------------------------------------

		// button instance for the multiply operand
		JButton buttonMultiply = new JButton("*");
		// set black border
		buttonMultiply.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		buttonMultiply.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		buttonMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of *
				answer = answer + "*";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonMultiply.setBounds(29, 220, 80, 80);
		// add button multiply to the pane
		clientPane.add(buttonMultiply);

		// ----------------------------------------------------------------------------------------

		// button instance for the minus operand
		JButton buttonMinus = new JButton("-");
		// set black border
		buttonMinus.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		buttonMinus.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		buttonMinus.addActionListener(new ActionListener() {
			// add action listener for the button
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of -
				answer = answer + "-";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonMinus.setBounds(29, 310, 80, 80);
		// add button minus to the pane
		clientPane.add(buttonMinus);

		// ----------------------------------------------------------------------------------------

		// button instance for the plus operand
		JButton buttonPlus = new JButton("+");
		// set black border
		buttonPlus.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		buttonPlus.setFont(new Font("Arial", Font.PLAIN, 35));
		// add action listener for the button
		buttonPlus.addActionListener(new ActionListener() {
			// add action listener for the button
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer is equal what the user enters and button value of +
				answer = answer + "+";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonPlus.setBounds(29, 400, 80, 80);
		// add button plus to the pane
		clientPane.add(buttonPlus);

		// ----------------------------------------------------------------------------------------

		// button instance for clear field
		JButton buttonClear = new JButton("Clear");
		// set black border
		buttonClear.setBorder(new LineBorder(Color.BLACK));
		// set the font size and font type of the button
		buttonClear.setFont(new Font("Arial", Font.PLAIN, 25));
		// add action listener for the button
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// variable for gotten from user entered
				String answer = answerField.getText();
				// answer field is now null
				answer = "";
				// set answer to the text field
				answerField.setText(answer);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonClear.setBounds(29, 490, 340, 80);
		// add button clear to the pane
		clientPane.add(buttonClear);

		// ----------------------------------------------------------------------------------------

		// button instance for new client
		JButton buttonNewClient = new JButton("New Client");
		// set red border
		buttonNewClient.setBorder(new LineBorder(Color.RED));
		// set the font size and font type of the button
		buttonNewClient.setFont(new Font("Arial", Font.PLAIN, 25));
		// add action listener for the button
		buttonNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instantiate client
				Client calcClient = new Client();
				// give it a title
				calcClient.setTitle("RMI Client GUI");
				// set it visible
				calcClient.setVisible(true);
				// set its size
				calcClient.setSize(410, 810);
				// turn off application resize
				calcClient.setResizable(false);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonNewClient.setBounds(200, 690, 165, 50);
		// add button new client to the pane
		clientPane.add(buttonNewClient);

		// ----------------------------------------------------------------------------------------

		// button instance for exit window
		JButton buttonExit = new JButton("Exit");
		// set red border
		buttonExit.setBorder(new LineBorder(Color.RED));
		// set the font size and font type of the button
		buttonExit.setFont(new Font("Arial", Font.PLAIN, 25));
		// add action listener for the button
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// end client by setting visible to false
				setVisible(false);
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		buttonExit.setBounds(29, 690, 165, 50);
		// add button new client to the pane
		clientPane.add(buttonExit);

		// ----------------------------------------------------------------------------------------

		// button instance for exit window
		JButton btnSubmit = new JButton("Submit");
		// set red border
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 25));
		// add action listener for the button
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instantiate answer string from what is entered by the user
				String answer = answerField.getText();
				// loop through the answer string
				for (int x = 0; x < answer.length(); x++) {
					// instantiate operator char which gets operand for check on if statements from
					// loop
					char operator = answer.charAt(x);
					// if the operator is plus, run this conditional
					if (operator == '+') {
						// gets the first element of the answer string which is the first number entered
						// by user
						int num1 = Integer.parseInt(answer.substring(0, x));
						// gets the second element of the answer string which is the second number
						// entered by user
						int num2 = Integer.parseInt(answer.substring(x + 1, answer.length()));
						// display output to be sent to the server
						String outputText = "Sending " + num1 + " + " + num2 + " to the server!";
						// append the output to console area
						consoleArea.append("\n" + outputText);
						// pass in both numbers to the addition method with the client instance number
						int value = addition(num1, num2, clientInstanceNumber);
						// now set the output text to the new string with the value got back from server
						outputText = "Recieved " + num1 + " + " + num2 + " = " + value + " back from the server!";
						// append the output to the console
						consoleArea.append("\n" + outputText);
						// now set the number text area to the new value
						answerField.setText("" + value);
					}
					// if the operator is minus, run this conditional
					if (operator == '-') {
						// gets the first element of the answer string which is the first number entered
						// by user
						int num1 = Integer.parseInt(answer.substring(0, x));
						// gets the second element of the answer string which is the second number
						// entered by user
						int num2 = Integer.parseInt(answer.substring(x + 1, answer.length()));
						// display output to be sent to the server
						String outputString = "Sending " + num1 + " - " + num2 + " to the server!";
						// append the output to console area
						consoleArea.append("\n" + outputString);
						// pass in both numbers to the subtraction method with the client instance
						// number
						int value = subtraction(num1, num2, clientInstanceNumber);
						// now set the output text to the new string with the value got back from server
						outputString = "Recieved " + num1 + " - " + num2 + " = " + value + " back from the server!";
						// append the output to the console
						consoleArea.append("\n" + outputString);
						// now set the number text area to the new value
						answerField.setText("" + value);
					}
					// if the operator is multiply, run this conditional
					if (operator == '*') {
						// gets the first element of the answer string which is the first number entered
						// by user
						int num1 = Integer.parseInt(answer.substring(0, x));
						// gets the second element of the answer string which is the second number
						// entered by user
						int num2 = Integer.parseInt(answer.substring(x + 1, answer.length()));
						// display output to be sent to the server
						String outputString = "Sending " + num1 + " * " + num2 + " to the server!";
						// append the output to console area
						consoleArea.append("\n" + outputString);
						// pass in both numbers to the multiplication method with the client instance
						// number
						int value = multiplication(num1, num2, clientInstanceNumber);
						// now set the output text to the new string with the value got back from server
						outputString = "Recieved " + num1 + " * " + num2 + " = " + value + " back from the server!";
						// append the output to the console
						consoleArea.append("\n" + outputString);
						// now set the number text area to the new value
						answerField.setText("" + value);
					}
					// if the operator is divide, run this conditional
					if (operator == '/') {
						// gets the first element of the answer string which is the first number entered
						// by user
						int num1 = Integer.parseInt(answer.substring(0, x));
						// gets the second element of the answer string which is the second number
						// entered by user
						int num2 = Integer.parseInt(answer.substring(x + 1, answer.length()));
						// instantiate and assign variable to zero for divide by zero check
						int value = 0;
						// display output to be sent to the server
						String outputString = "Sending " + num1 + " / " + num2 + " to the server!";
						// append the output to console area
						consoleArea.append("\n" + outputString);
						// check to see if any of the two values entered are zero,
						// NOTE: conditional works because if any of the values are zero they are not
						// allowed when using / divide operand
						if (num1 == 0 || num2 == 0) {
							// append that cannot divide by zero
							consoleArea.append("\nCannot divide by zero!");
							// set answer field that you cannot divide by zero
							answerField.setText("Cannot divide by zero!");
						} else {
							// pass in both numbers to the division method with the client instance number
							value = division(num1, num2, clientInstanceNumber);
							// now set the number text area to the new value
							answerField.setText("" + value);
							// now set the output text to the new string with the value got back from server
							outputString = "Recieved " + num1 + " / " + num2 + " = " + value + " back from the server!";
							// append the output to the console
							consoleArea.append("\n" + outputString);
						}
					}

				}
			}
		});
		// set the the position through x / y coordinates and the height and width of
		// the component
		btnSubmit.setBounds(204, 400, 165, 80);
		// set color of the button
		btnSubmit.setBorder(new LineBorder(Color.BLACK));
		// add button submit to the pane
		clientPane.add(btnSubmit);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// instantiate new client
					Client clientInstance = new Client();
					// set title of the client
					clientInstance.setTitle("RMI Client GUI");
					// set client visible
					clientInstance.setVisible(true);
					// turn off resizing window
					clientInstance.setResizable(false);
					// set the size of the window
					clientInstance.setSize(410, 810);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}