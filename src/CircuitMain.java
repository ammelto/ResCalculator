/*========================================================================================
 * Resistor.Java
 * Alexander Melton
 * CS 1113 section 001
 * 
 * Description: This is the main class that will call each abstract class recursively depending
 * on the value that it finds. It will then call each print method.
 * ========================================================================================
 */

import java.util.*;
import java.io.*;
	
public class CircuitMain {

		public static void main(String[] args) 
		{
			Scanner scan = null;
			try 
			{
				scan = new Scanner(new File(args[0]));
				ArrayList<Circuit> ars = new ArrayList<>();
				
				while(scan.hasNext()){
					String token = scan.next();
					if(token.equals("Parallel") || token.equals("parallel")){
						Circuit paraChan = new ParallelCircuit();
						paraChan.loadCircuit(scan);
						ars.add(paraChan);
					}else if(token.equals("Series") || token.equals("series")){
						Circuit serichan = new SerialCircuit();
						serichan.loadCircuit(scan);
						ars.add(serichan);
					}else if(token.equals("#")){
						scan.nextLine();
					}else if(token.equals("}")){
						return;
					}
				}
				for(Circuit x: ars){
					x.printHierarchical("");
				}
				
				
				scan.close();
			}
			catch (IOException ex)
			{
				System.out.println("Usage: java CircuitMain <file>");
			}
		}
}
