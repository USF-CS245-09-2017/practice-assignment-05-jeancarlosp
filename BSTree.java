package edu.usfca.cs.cs245;
import java.lang.StringBuilder;

public class BSTree {


	private BSTNode root;

	public void insert (Comparable value){
		root = insert(root, value);

	}
	public boolean find (Comparable value){
		return find(root,value);


	}
	void delete(Comparable elem) 
	{
		root = delete(root, elem);
	}

	private class BSTNode{


		Comparable data;
		BSTNode left;
		BSTNode right;

		BSTNode(Comparable newdata) {
			data = newdata;
		}

	}


	BSTNode insert(BSTNode tree, Comparable elem) 
	{
		if (tree == null) 
		{
			return new BSTNode(elem);
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

	BSTNode delete(BSTNode node, Comparable value){
		if (node == null)
			return null;
		if (node.data.compareTo(value) == 0)
		{
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			else
			{
				if(node.right.left == null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else
				{
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}
		else if (value.compareTo(node.data) < 0){
			node.left = delete(node.left, value);
			return node;
		} 
		else 
		{
			node.right = delete(node.right, value);
			return node;
		}
	}  
	Comparable removeSmallest(BSTNode node){
		if(node.left.left == null){
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else{
			return removeSmallest(node.left);
		}
	}
	boolean find(BSTNode node, Comparable elem) 
	{
		if (node == null)
			return false;
		if (elem.compareTo(node.data) == 0) 
			return true;
		if (elem.compareTo(node.data) < 0)
			return find(node.left, elem);
		else
			return find(node.right, elem);
	}

	String toStringInOrder() {
		final StringBuilder sb = new StringBuilder();

		toStringInOrder(root, sb);
		return sb.toString().trim();
	}

	private void toStringInOrder(BSTNode root, StringBuilder sb) {


		if (root != null) 
		{
			toStringInOrder(root.left, sb);
			sb.append(root.data);
			sb.append(" ");


			toStringInOrder(root.right, sb);

		}

	}	   
	String toStringPreOrder() {
		final StringBuilder string = new StringBuilder();
		string.append("");
		string.append(root.data);
		toStringPreOrder(root, string);
		string.append("");
		return string.toString();
	}

	private void toStringPreOrder(BSTNode node, StringBuilder sb) {
		if (node.left != null) {
			sb.append(" ");
			sb = sb.append(node.left.data);
			toStringPreOrder(node.left, sb); 
		}

		if (node.right != null) {
			sb.append(" ");
			sb = sb.append(node.right.data + "");
			toStringPreOrder(node.right, sb); 
			sb.append("");
		}
	}


}



