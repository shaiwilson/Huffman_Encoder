package huffman;

class BinarySearchTree {

	   private class Node {
		   /* This class represents a node in a binary tree data structure. 
			 * Each node has a character and a weight equal to the number of 
			 * times the character occurs. 
			 *
			 */

		    public Node left;
		    public Node right;
		    public char letter;
		    public Integer data;

	       Node(char letter, int newdata) {
	    	  this.letter = letter;
	          data = newdata;
	       }
	   	    
	   }

	   private Node root;

	   public void insert(int elem) 
	   {
	      root = insert(root, elem);
	   }

	   public boolean find(int elem) 
	   {
	      return find(root,elem);
	   }

	   void delete(int elem) 
	   {
	      root = delete(root, elem);
	   }


	   public void print() 
	   {
	      print(root);
	   }

	   boolean find(Node tree, int elem) 
	   {
	      if (tree == null)
	         return false;
	      if (elem.compareTo(tree.data) == 0) 
	         return true;
	      if (elem.compareTo(tree.data) < 0)
	         return find(tree.left, elem);
	      else
	         return find(tree.right, elem);
	   }

	   int minimum(Node tree) 
	   {
	      if (tree == null)
	         return null;
	      if (tree.left == null)
	         return tree.data;
	      else
	         return minimum(tree.left);
	   }

	   void print(Node tree) 
	   {
	      if (tree != null) 
	      {
	         print(tree.left);
	         System.out.println(tree.data);
	         print(tree.right);
	      }
	   }

	   Node insert(Node tree, int elem) 
	   {
	      if (tree == null) 
	      {
	         return new Node(elem);
	      }
	      if (elem.compareTo(tree.data) < 0) 
	      {
		  tree.left = insert(tree.left, elem);
		  return tree;
	      } 
	      else 
	      {
		  tree.right = insert(tree.right, elem);
		  return tree;
	      }
	   }


	   Node delete(Node tree, int elem) 
	   {
	     if (tree == null) 
	        return null;
	     if (tree.data.compareTo(elem) == 0) 
	     {
	        if (tree.left == null)
		   return tree.right;
	        else if (tree.right == null)
		   return tree.left;
	        else 
	        {
		   if (tree.right.left == null) 
	           {
	             tree.data = tree.right.data;
	             tree.right = tree.right.right;
	             return tree;
	           } 
	           else 
	           {         
	             tree.data = removeSmallest(tree.right);
	             return tree;
	            }
	         }
	      } 
	      else  if (elem.compareTo(tree.data) < 0) 
	      {
	         tree.left = delete(tree.left, elem);
	         return tree;
	      } 
	      else 
	      {
	         tree.right = delete(tree.right, elem);
	         return tree;
	      }
	   }  
	 
	   int removeSmallest(Node tree) {
	      if (tree.left.left == null) {
	         int smallest = tree.left.data;
	         tree.left = tree.left.right;
	         return smallest;
	      } 
	      else 
	      {
	         return removeSmallest(tree.left);
	      }
	   }
	}



