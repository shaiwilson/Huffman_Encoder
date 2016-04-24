package huffman;

import java.util.ArrayList;
import java.util.Arrays;

public class Huffman {
	
	// array to store node list
	public static ArrayList<Node> freqNode = new ArrayList<Node>();
	public static ArrayList<String> huffTable = new ArrayList<String>();
	public static ArrayList<Integer> freqSort = new ArrayList<Integer>();
	
	
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
//		int[] charList = new int[26];
		ArrayList<Integer> charList = new ArrayList<Integer>();
					 
		TextFile inputFile = new TextFile(filename, 'r');
		
		while (inputFile.EndOfFile() != true)
		{
			char singleLetter = inputFile.readChar();
		
	            if (Character.isLetter(singleLetter) == true)     
	            {
	            	 // Assigning frequency of a character. 97-122 represents a-z (ASCII table). e.g lowercase c = 97
//	            	charList[(int)(singleLetter)-97] = charList[(int)(singleLetter)-97] + 1; 
	            	charList.set((int)(singleLetter)-97, charList.get((int)(singleLetter)-97) + 1);
	            	
	            }
	       }
		
		// reset the file back to the beginning
	    inputFile.close();

	    // build a frequency table
	    //Calculate the total number of characters from the input file.
	    double sumOfCharacters = 0;
	    
	    for (int i = 0; i < charList.size(); i++) 
	    {
	        sumOfCharacters += charList.get(i);
	    }
	    
	    System.out.println("The total number of characters in this file is: " + sumOfCharacters);

	    // Calculating the relative frequency.  
	    // Divide each occurrence for each letter (a-z) by the sumOfCharacters.
	    
	    System.out.printf("%10s%6s%n", "Letter", "%");   //column labels "Letter" and "%"
	    System.out.println();
	    for (int i = 0; i < charList.size(); i++) 
	    {
	        char singleLetter = (char)(i + 97);         //converting the decimal ASCII annotation to letters for a-z
	        double value = charList.get(i);
	        
	        // Create a collection of n small, one-node trees
	        freqSort = mergeSort(charList);
	        Node temp = new Node(singleLetter, (int) value);
	        freqNode.add(temp);
	        
	        System.out.printf("%8s%13f%n",singleLetter,(value/sumOfCharacters)*100);
	    }	
	}

	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> charArray)
	{
		
		ArrayList<Integer> charList = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int mid;
		
		if (charList.size() == 1) {
			return charList;
		}
		else {
			mid = charList.size()/2;
			
			for (int i = 0; i < mid; i++) {
				left.add(charList.get(i));
			}
			
			for (int i = mid; i < charList.size(); i++) {
				right.add(charList.get(i));
			}
			
			left = mergeSort(left);
			right = mergeSort(right);
			
			// merge the results 
			merge(left, right, charList);
			
		}
		
		return charList;
					
	}
	

	public void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> list)
	{
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                list.set(listIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                list.set(listIndex, right.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }
 
        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            list.set(listIndex, rest.get(i));
            listIndex++;
        }
    }
 
	
	public boolean compress(int treesize){
		// TODO
		return false;
	}
	
	public void printTree() {
		// TODO 
	}
	
	public void writeToFile() {
		// TODO
	}
	
	public boolean uncompress(BinaryFile inputFile) {
		// TODO
		return false;
	}
	
	public Node readTree(BinaryFile inputFile) {
		// TODO
		return null;
	}
	
	public void readFile(BinaryFile inputFile, TextFile writeTo)
	{
		// TODO
	}
	
	public void readFilePrint(BinaryFile inputFile, TextFile writeTo) {
		// TODO
	}
	
	/**
	 * Decodes an encoded string.
	 * 
	 * @param input
	 *            a string made up of 0 and 1
	 */
	
	public static class HuffmanTree {
		
		/**
		 * Constructs a huffman tree from given character frequencies.
		 * Create a priority queue of huffman nodes, this method builds a huffman
		 * encoding tree, which can be used to encode the given string
		 * 
		 */
		
		 public int numNodes(Node tree) {
				if (tree == null)
				    return 0;
				return 1 + numNodes(tree.getLeftChild()) + 
				    numNodes(tree.getRightsib());
		 }
		
		 public void printTree(Node tree) 
		   {
		      if (tree != null) 
		      {
		         printTree(tree.getLeftChild());
		         System.out.println(tree.data());
		         printTree(tree.getRightsib());
		      }
		   }
		
		public static Node buildTree() {
			Node tree = new Node(0);
			
			while(freqNode.size() > 1)
			{
				tree = new Node(0);
				int i = 0;
				Node temp1 = freqNode.get(0);
				Node temp2 = freqNode.get(1);
				
				tree.setdata(temp1.data() + temp2.data());
				
				tree.setLeftchild(temp1);
				tree.setRightsib(temp2);
				
				while(i < freqNode.size())
				{
					if(tree.data() <= freqNode.get(i).data())
					{
						freqNode.add(i, tree);
						break;
					}
					
					if (i == freqNode.size() - 1 &&
							tree.data() >= freqNode.get(i).data())
					{
						freqNode.add(tree);
						break;
					}
					
					i++;
				}
				
				freqNode.remove(0);
				freqNode.remove(0);
			}
			
			return tree;
		}
		
		public void huffmanTable(Node root, String huffmanCode) {
			if (root == null){
				return;
			} 
			else {
				
			}
		}
		
	} // close Huffman class
	
	public static void main(String[] args) {
			
			Huffman inClass = new Huffman();
			inClass.countFreq("samp.txt");
//			Node root = HuffmanTree.buildTree();
					
				

				    
		    // print out the encoded tree
		    
		    // TODO 
		    // Build a lookup table, which contains the codes for all characters in the input file
		    // Check to see if the compressed file would be smaller than the original file. If not, stop -- don't do any compression. Print out a message instead that the file cannot be compressed
		    // If the compressed file will be smaller, create the encoded file:
		    	// Print out a "Magic Number", which will be used to guard against uncompressing files that we didn't compress
		    	// Print out the Huffman tree to the output file
		    	// Use the lookup table to encode the file
		    
		    
		  
		} // end main method 
	
	
} // end of entire class Huffman.java
