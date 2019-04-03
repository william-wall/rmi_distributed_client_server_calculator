package rmi_calculator_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

// William Wall @ williamwall.ie

public interface Interface extends Remote{
	
	// addition method taking two numbers and the client GUI instance number
	public int addition(int num1, int num2, int clientNum) throws RemoteException;
	
	// subtraction method taking two numbers and the client GUI instance number
	public int subtraction(int num1, int num2, int clientNum) throws RemoteException;
	
	// multiplication method taking two numbers and the client GUI instance number
	public int multiplication(int num1, int num2, int clientNum) throws RemoteException;
	
	// division method taking two numbers and the client GUI instance number
	public int division(int num1, int num2, int clientNum) throws RemoteException;
	
}
