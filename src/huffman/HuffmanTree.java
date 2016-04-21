package huffman;

public class HuffmanTree{
	private Node root;

	/**
	 * Constructs a Huffman tree from given character frequencies.
	 * 
	 */
	
	public void setRoot(Node root) {
        this.root = root;
    }

    public void addToLeft(Node node) {
        root.setLeftchild(node);
    }

    public void addToRight(Node node) {
        root.setRightsib(node);
    }

    public Node getRoot() {
        return root;
    }
	
}
	
