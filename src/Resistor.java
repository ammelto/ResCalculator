/*========================================================================================
 * Resistor.Java
 * Alexander Melton
 * CS 1113 section 001
 * 
 * Description: This class extends the super class Circuit and is called when
 * a Resistor is found in the input file. Will return the value of the resistor by using scan.next();
 * after the resistor keyword is found. Will also print out each resistor recursively.
 * ========================================================================================
 */

import java.util.Scanner;

public class Resistor extends Circuit {
	
	private double resistor;
	
	public Resistor(double x){
		resistor = x;
	}
	
	@Override
	public double getResistance() {
		// TODO Auto-generated method stub
		return resistor;
	}
	
	@Override
	public void loadCircuit(Scanner scan){}

	@Override
	public void printHierarchical(String indent) {
		// TODO Auto-generated method stub
		System.out.printf(indent + "resistor %1.2f,\n", getResistance());
	}

}
