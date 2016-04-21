package huffman;

	public class Node {
		

		/* This class represents a node in a binary tree data structure. 
		 * Each node has a character and a weight equal to the number of 
		 * times the character occurs. 
		 *
		 */

	    private Node leftchild_;
	    private Node rightsib_;
	    private Integer weight;
	    private char letter;


	    public Node(char element, Integer weight) {
		letter = element;
		this.weight = weight;
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

	    Integer weight() {
		return weight;
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

	    void setWeight(Integer element) {
		weight = element;
	    }
	    
	    void setLetter(char element) {
			letter = element;
		}
	}



