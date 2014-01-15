/*========================================================================================
 * SerialCircuits.Java
 * Alexander Melton
 * CS 1113 section 001
 * 
 * Description: This class extends the super class Circuit and is called when
 * a Serial Circuit is found in the input file. Will add the inner circuits to the
 * arraylist which is called recursively to get the correct format and resistance values 
 * ========================================================================================
*/

import java.util.ArrayList;
import java.util.Scanner;


public class SerialCircuit extends Circuit{
	ArrayList<Circuit> seri = new ArrayList<>();
	
	@Override
	public double getResistance() {
		double resistance = 0.0;
		for (Circuit val : seri){
			resistance += val.getResistance();
		}
		return resistance;
	}

	@Override
	public void loadCircuit(Scanner scan) {
		
		while(scan.hasNext()){
			String token = scan.next();
			if(token.equals("Resistor") || token.equals("resistor")){
				String value = scan.next();
				value = value.replace(',','\0');
				Resistor resis = new Resistor(Double.parseDouble(value));
				seri.add(resis);
			}else if(token.equals("Parallel") || token.equals("parallel")){
				Circuit paraChan = new ParallelCircuit();
				paraChan.loadCircuit(scan);
				seri.add(paraChan);
			}else if(token.equals("Series") || token.equals("series")){
				Circuit serichan = new SerialCircuit();
				serichan.loadCircuit(scan);
				seri.add(serichan);
			}else if(token.equals("#")){
				scan.nextLine();
			}else if(token.equals("}")){
				return;
			}
		}
	}

	@Override
	public void printHierarchical(String indent) {
		// TODO Auto-generated method stub
		System.out.printf(indent + "Series # %1.2f\n" + indent +"{\n", getResistance());
		
		for(Circuit printMe : seri){
			printMe.printHierarchical(indent + "\t");
		}
		System.out.printf(indent + "}\n", 3.0);
	}

}
