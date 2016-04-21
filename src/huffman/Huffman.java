package huffman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Huffman {
	
	/**
	 * This program will compress a file using Huffman encoding.
	 *
	 * @author Shai Wilson
	 */

	
	public static void main(String[] args) throws IOException {
			
			// array for the a-z (97-122, based on ASCII table )
			int[] myArray = new int[26];
			
			// array to store node list
			List<Tree> nodeList = new ArrayList<Tree>();
			
			TextFile inputFile = new TextFile("samp.txt", 'r');
			String inputLine = null;
			while (inputFile.EndOfFile() != true)
			{
				char singleLetter = inputFile.readChar();
			
		            if (Character.isLetter(singleLetter) == true)     
		            {
		            	 // Assigning frequency of a character. 97-122 represents a-z (ASCII table). e.g lowercase c = 97
		            	myArray[(int)(singleLetter)-97] = myArray[(int)(singleLetter)-97] + 1; 
		            	
		            }
		       }
			
			// reset the file back to the beginning
		    inputFile.close();


		    // build a frequency table
		    //Calculate the total number of characters from the input file.
		    double sumOfCharacters = 0;
		    
		    for (int i = 0; i < myArray.length; i++) 
		    {
		        sumOfCharacters += myArray[i];
		    }
		    
		    System.out.println("The total number of characters in this file is: " + sumOfCharacters);

		    //Calculating the relative frequency.  
		    // Divide each occurrence for each letter (a-z) by the sumOfCharacters.
		    
		    System.out.printf("%10s%6s%n", "Letter", "%");   //column labels "Letter" and "%"
		    System.out.println();
		    for (int i = 0; i < myArray.length; i++) 
		    {
		        char singleLetter = (char)(i + 97);         //converting the decimal ASCII annotation to letters for a-z
		        double value = myArray[i];
		        System.out.println(singleLetter);
		        System.out.println((int)value);
		        Node newNode = new Node(singleLetter, (int)value);
		        Tree tree = new Tree();
	            tree.setRoot(newNode);
	            nodeList.add(tree);
		        
		        
		        System.out.printf("%8s%13f%n",singleLetter,(value/sumOfCharacters)*100);
		    }
		    
		  
		} // end main method 
	
	/**
	 * Decodes an encoded string.
	 * 
	 * @param input
	 *            a string made up of 0 and 1
	 */
	public String decode(String input) {
		return input;
		
	}

	
} // end of class Huffman
