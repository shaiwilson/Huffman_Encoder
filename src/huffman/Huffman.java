package huffman;

import java.util.ArrayList;

public class Huffman {
	
	// array to store node list
	ArrayList<Node> freqNode = new ArrayList<Node>();
	ArrayList<String> huffTable = new ArrayList<String>();
	
	/**
	 * This method will count the amount of times each character appears and add the
	 * is frequency of each character to the array charList \.
	 * By using the characters contained within the frequency list,
	 * we build a collection of one-node trees.  
 	 * Each of these n trees represent a distinct input character and have
 	 * a weight(data) corresponding to their count tallied in the frequency step.
	 *
	 * 
	 */
	
	public void countFreq(String filename){
		
		// array for the a-z (97-122, based on ASCII table )
		int[] charList = new int[26];
					 
		TextFile inputFile = new TextFile(filename, 'r');
		
		while (inputFile.EndOfFile() != true)
		{
			char singleLetter = inputFile.readChar();
		
	            if (Character.isLetter(singleLetter) == true)     
	            {
	            	 // Assigning frequency of a character. 97-122 represents a-z (ASCII table). e.g lowercase c = 97
	            	charList[(int)(singleLetter)-97] = charList[(int)(singleLetter)-97] + 1; 
	            	
	            }
	       }
		
		// reset the file back to the beginning
	    inputFile.close();

	    // build a frequency table
	    //Calculate the total number of characters from the input file.
	    double sumOfCharacters = 0;
	    
	    for (int i = 0; i < charList.length; i++) 
	    {
	        sumOfCharacters += charList[i];
	    }
	    
	    System.out.println("The total number of characters in this file is: " + sumOfCharacters);

	    // Calculating the relative frequency.  
	    // Divide each occurrence for each letter (a-z) by the sumOfCharacters.
	    
	    System.out.printf("%10s%6s%n", "Letter", "%");   //column labels "Letter" and "%"
	    System.out.println();
	    for (int i = 0; i < charList.length; i++) 
	    {
	        char singleLetter = (char)(i + 97);         //converting the decimal ASCII annotation to letters for a-z
	        double value = charList[i];
	        
	        // Create a collection of n small, one-node trees
	        Node temp = new Node(singleLetter, (int) value);
	        freqNode.add(temp);
	        
	        System.out.printf("%8s%13f%n",singleLetter,(value/sumOfCharacters)*100);
	    }	
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> listSort){
		
	}
	
	public static void main(String[] args) throws IOException {
			
			
				    
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
