package huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Huffman {
	
	
	
	public static void main(String[] args) throws IOException {
		

		
		// array for the a-z (97-122, based on ASCII table )

		try {
			
			int[] myArray = new int[26];
			
			// open the file
//			BufferedReader readerObject = new BufferedReader(new FileReader(inputFile));
			
			TextFile inputFile = new TextFile("sample,txt", 'r');
			
			
			String sCurrentLine = null;
//			sCurrentLine = readerObject.readLine();

			for(int i = 0; i<sCurrentLine.length(); i++)  // for each character in the readline                    from the input file, a-z will be counted.
		        {
		            if (Character.isLetter(sCurrentLine.charAt(i)) == true)     
		            {
		            	char singleLetter = sCurrentLine.charAt(i);
		            	 // Assigning frequency of a character. 97-122 represents a-z (ASCII table). e.g lowercase c = 97
		            	myArray[(int)(singleLetter)-97] = myArray[(int)(singleLetter)-97] + 1; 
		            }
		        }
			
		        readerObject.close();


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
		        System.out.printf("%8s%13f%n",singleLetter,(value/sumOfCharacters)*100);
		    }

		    } 
		
		catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		
	}
	
}
