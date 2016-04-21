package huffman;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Huffman {
	
	/**
	 * This program will compress a file using Huffman encoding.
	 * First count the amount of times each character appears. This is the frequency of each character.
	 * Then create a collection of n small, one-node trees 
 	 * Each of these n trees represent a distinct input character and have
 	 * a weight corresponding to their count tallied in the analysis step.
	 *
	 * @author Shai Wilson
	 */

	
	public static void main(String[] args) throws IOException {
			
			// array for the a-z (97-122, based on ASCII table )
			int[] myArray = new int[26];
			
			/* VERSION 1*/
			// array to store node list
			// List<Tree> nodeList = new ArrayList<Tree>();
			
			/* Version 2 */
			Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
			
			TextFile inputFile = new TextFile("samp.txt", 'r');
			
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

		    // Calculating the relative frequency.  
		    // Divide each occurrence for each letter (a-z) by the sumOfCharacters.
		    
		    System.out.printf("%10s%6s%n", "Letter", "%");   //column labels "Letter" and "%"
		    System.out.println();
		    for (int i = 0; i < myArray.length; i++) 
		    {
		        char singleLetter = (char)(i + 97);         //converting the decimal ASCII annotation to letters for a-z
		        double value = myArray[i];
		        frequencyMap.put('A', (int)value);

		        /* Version 1 */
		        // Create a collection of n small, one-node trees
		        // Node newNode = new Node(singleLetter, (int)value);
		        // Tree tree = new Tree();
	            // tree.setRoot(newNode);
	            // nodeList.add(tree);
	         
		        /* VERSION 2 */
		        frequencyMap.put(singleLetter, (int)value);
		        
		        System.out.printf("%8s%13f%n",singleLetter,(value/sumOfCharacters)*100);
		    }
		    
		    // create the huffman encoding tree
		    HuffmanTree tree = new HuffmanTree(frequencyMap);
		    
		    // print out the encoded treed
		    
		    // TODO 
		    // Build a lookup table, which contains the codes for all characters in the input file
		    // Check to see if the compressed file would be smaller than the original file. If not, stop -- don't do any compression. Print out a message instead that the file cannot be compressed
		    // If the compressed file will be smaller, create the encoded file:
		    	// Print out a "Magic Number", which will be used to guard against uncompressing files that we didn't compress
		    	// Print out the Huffman tree to the output file
		    	// Use the lookup table to encode the file
		    
		    
		  
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

	
	public static String encode(String toEncode,
			Map<Character, String> encodingMap) {
				return toEncode;
		
	}
	
} // end of class Huffman
