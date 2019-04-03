package rmi_calculator_server;

import java.rmi.*;

import java.rmi.Naming.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.net.UnknownHostException;
import java.util.*;
import javax.swing.JFrame;

import rmi_calculator_interface.Interface;

import java.awt.*;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

// William Wall @ williamwall.ie

public class Server extends UnicastRemoteObject implements Interface {

	// instantiate JFrame for GUI
	public JFrame serverGUI = new JFrame("RMI Server GUI");

	// instantiate TextArea for GUI display
	public TextArea serverDisplay = new TextArea();

	public Server() throws RemoteException {

		// set JFrame visible
		serverGUI.setVisible(true);

		// set size of GUI
		serverGUI.setSize(400, 400);

		// set exact x / y coordinates location and width and height
		serverDisplay.setBounds(30, 240, 250, 110);

		// set editable to false for null user interaction
		serverDisplay.setEditable(false);

		// add the text area to the window jframe
		serverGUI.add(serverDisplay);

		// show message when successfully started
		serverDisplay.append("Server Started ...");
		serverDisplay.append("\n================================================");

	}

	// method to add, take in two numbers and the client number instance
	public int addition(int num1, int num2, int clientNo) {
		try {
			// append details of request coming in
			serverDisplay.append("\nRequest Coming in...");
			// the client number and IP address
			serverDisplay.append("\nClient: " + clientNo + " connected at IP: " + InetAddress.getLocalHost().getHostAddress());
			// client instance number
			serverDisplay.append("\nRequest from Client: " + clientNo);
			// number 1 entered by client
			serverDisplay.append("\nOperand 1: " + num1);
			// number 2 entered by client
			serverDisplay.append("\nOperand 2: " + num2);
			// the chosen operator
			serverDisplay.append("\nOperator: +");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// append calculating
		serverDisplay.append("\nCalculating...");
		// append what the result is
		serverDisplay.append("\nData to Client " + clientNo + ":  " + (num1 + num2));
		// display answer
		serverDisplay.append("\nAnswer :" + (num1 + num2));
		// append sending back to the client
		serverDisplay.append("\nSending result back to the client...");
		serverDisplay.append("\n================================================");
		// return the two numbers added
		return (num1 + num2);
	}

	// method to subtract, take in two numbers and the client number instance
	public int subtraction(int num1, int num2, int clientNo) {
		try {
			// append details of request coming in
			serverDisplay.append("\nRequest Coming in...");
			// the client number and IP address
			serverDisplay.append("\nClient: " + clientNo + " connected at IP: " + InetAddress.getLocalHost().getHostAddress());
			// client instance number
			serverDisplay.append("\nRequest from Client: " + clientNo);
			// number 1 entered by client
			serverDisplay.append("\nOperand 1: " + num1);
			// number 2 entered by client
			serverDisplay.append("\nOperand 2: " + num2);
			// the chosen operator
			serverDisplay.append("\nOperator: -");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// append calculating
		serverDisplay.append("\nCalculating...");
		// append what the result is
		serverDisplay.append("\nData to Client " + clientNo + ":  " + (num1 - num2));
		// display answer
		serverDisplay.append("\nAnswer :" + (num1 - num2));
		// append sending back to the client
		serverDisplay.append("\nSending result back to the client...");
		serverDisplay.append("\n================================================");
		// return the two numbers subtracted
		return (num1 - num2);
	}

	// method to multiply, take in two numbers and the client number instance
	public int multiplication(int num1, int num2, int clientNo) {
		try {
			// append details of request coming in
			serverDisplay.append("\nRequest Coming in...");
			// the client number and IP address
			serverDisplay.append("\nClient: " + clientNo + " connected at IP: " + InetAddress.getLocalHost().getHostAddress());
			// client instance number
			serverDisplay.append("\nRequest from Client: " + clientNo);
			// number 1 entered by client
			serverDisplay.append("\nOperand 1: " + num1);
			// number 2 entered by client
			serverDisplay.append("\nOperand 2: " + num2);
			// the chosen operator
			serverDisplay.append("\nOperator: *");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// append calculating
		serverDisplay.append("\nCalculating...");
		// append what the result is
		serverDisplay.append("\nData to Client " + clientNo + ":  " + (num1 * num2));
		// display answer
		serverDisplay.append("\nAnswer :" + (num1 * num2));
		// append sending back to the client
		serverDisplay.append("\nSending result back to the client...");
		serverDisplay.append("\n================================================");
		// return the two numbers multiplied
		return (num1 * num2);
	}

	// method to divide, take in two numbers and the client number instance
	public int division(int num1, int num2, int clientNo) {
		try {
			// append details of request coming in
			serverDisplay.append("\nRequest Coming in...");
			// the client number and IP address
			serverDisplay.append("\nClient: " + clientNo + " connected at IP: " + InetAddress.getLocalHost().getHostAddress());
			// client instance number
			serverDisplay.append("\nRequest from Client: " + clientNo);
			// number 1 entered by client
			serverDisplay.append("\nOperand 1: " + num1);
			// number 2 entered by client
			serverDisplay.append("\nOperand 2: " + num2);
			// the chosen operator
			serverDisplay.append("\nOperator: /");
			// display to server coming in from client
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// append calculating
		serverDisplay.append("\nCalculating...");
		// append what the result is
		serverDisplay.append("\nData to Client " + clientNo + ":  " + (num1 / num2));
		// display answer
		serverDisplay.append("\nAnswer :" + (num1 / num2));
		// append sending back to the client
		serverDisplay.append("\nSending result back to the client...");
		serverDisplay.append("\n================================================");
		// return the two numbers divided
		return (num1 / num2);
	}

	public static void main(String args[]) {
		try {
			// server instance
			Server serverInstance = new Server();
			// registry, register services for clients to query for those services
			java.rmi.registry.Registry registry = LocateRegistry.createRegistry(1099);
			// rebind, name to associate with the remote reference
			registry.rebind("rmiCalculatorServer", serverInstance);
			// print to console successful start
			System.out.println("RMI Calculator Server Ready");
		} catch (RemoteException remoteEx) {
			System.out.println("Remote Server Error:" + remoteEx.getMessage());
			System.exit(0);
		}
	}
}