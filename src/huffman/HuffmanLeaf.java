package huffman;

public class HuffmanLeaf {
	
    public static int MAX(int x, int y) {
	if (x > y)
	    return x;
	else
	    return y;
    }
    
    public static int height(Node tree) {
	if (tree == null)
	    return 0;
	return 1 + MAX(height(tree.getLeftChild()),
		       height(tree. getRightsib()));
    }
    
        
    public static int numNodes(Node tree) {
	if (tree == null)
	    return 0;
	return 1 + numNodes(tree.getLeftChild()) + 
	    numNodes(tree. getRightsib());
    }

    /* Input:  A binary tree, and an element
       Output: true if the element is in the tree, false otherwise */
    public static boolean find(Node tree, Comparable elem) {
        if (tree == null)
	    {
		return false;
	    }
        if (tree.element().equals(elem))
	    {
		return true;
	    }
	return find(tree.getLeftChild(), elem) || find(tree. getRightsib(),elem);

    }


    /* Input:  A binary tree  */
    /* Output: The number of leaves in the tree */
    public static int numLeaves(Node tree) {
        if (tree == null)
        {
            return 0;
        }
        else if (tree.getLeftChild() == null && tree. getRightsib() == null)
        {
            return 1;
        }
        else
        {
            return numLeaves(tree.getLeftChild()) + numLeaves(tree. getRightsib());
        }
    }

    /* Input: a Binary Tree 
       Output: The depth of the shallowest leaf in the tree,
               (or -1, if the tree is empty)

       shallowestLeaf on
             x
            / \
           x   x
          / \
         x   x
  
        would return 1, while shallowestLeaf on:
             x
              \
               x
              /
              x
               \
                x
		would return 3  */
    public static int shallowestLeaf(Node tree) {
        if (tree == null)
        {
            return -1;
        }
        else if (tree.getLeftChild() == null && tree. getRightsib() == null)
        {
            return 0;
        }
        else if (tree.getLeftChild() == null)
        {
            return 1 + shallowestLeaf(tree. getRightsib());
        }
        else if (tree. getRightsib() == null)
        {
            return 1 + shallowestLeaf(tree.getLeftChild());
        }
        else
        {
            return 1 + MAX(shallowestLeaf(tree.getLeftChild()), shallowestLeaf(tree. getRightsib()));
        }
    }
	

}
