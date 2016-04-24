package huffman;

	public class Node {
		

		/** 
		 * 
		 * This class represents a node in a binary tree. 
		 * Each node has a character and data equal to it's frequency.
		 *
		 *	@author Shai Wilson
		 */

	    private Node leftchild_;
	    private Node rightsib_;
	    private int data;
	    private char letter;

	    public Node()
	    {
	    	this.data = 0;
	    }
	    
	    public Node(int value)
	    {
	    	this.data = value;
	    }

	    public Node(char element) {
	    	letter = element;
	    }
	    
	    public Node(char element, int data) {
	    	letter = element;
	    	this.data = data;
	    }

	    public Node(char element, Node leftchild, Node rightsib) {
	    	letter = element;
	    	leftchild_ = leftchild;
	    	rightsib_ = rightsib;
	    }

	    Node getLeftChild() {
	    	return leftchild_;
	    }

	    Node getRightsib() {
	    	return rightsib_;
	    }

	    Integer data() {
	    	return data;
	    }
	    
	    char letter() {
			return letter;
		}

	    void setLeftchild(Node leftchild) {
	    	leftchild_ = leftchild;
	    }

	    void setRightsib(Node rightsib) {
	    	rightsib_ = rightsib;
	    }

	    void setdata(int element) {
	    	data = element;
	    }
	    
	    void setLetter(char element) {
			letter = element;
		}
	    
		public boolean isLeaf()
		{
			return((leftchild_ == null) && (rightsib_ == null));
		}
	}



