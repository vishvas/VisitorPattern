package wordCount.treesForStrings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.TreeVisitorI;

public class BST implements TreeVisitorI{
	private Node root;
	private int totalWords;
	private int totalNoChars;
	private int maxFrequency;
	private List<String> frequentWords = null;
	/**
	 * BST Constructor
	 */
	public BST(){
		this.root=null;
		totalWords = 0;
		totalNoChars = 0;
		maxFrequency = 0;
	}
	/**
	 * Insert into the tree
	 * @param main
	 * @param stringIn
	 */
	public void insert(String main){
		if(root==null){
			root=new Node(main);
			return;
		}
		
		root = put(this.root,main);
	}
	private Node put(Node node,String main) {
		
		if(node==null){
			return new Node(main);
			
		}
		int compare = main.compareTo(node.getMainString());
		if(compare<0){
			node.setLeft(put(node.getLeft(),main));
		}else if(compare>0){
			node.setRight(put(node.getRight(),main));
		}else {
			node.incrementCount();
		}
		return node;
	}
	
	
	
	/**
	 * Searches the input string and returns the count of occurrence
	 * in the existing RedBlack Tree
	 * @param stringIn = string to be searched
	 * @return returns the count of occurrence of the input string
	 */
	public int grep(String stringIn) {
		if (stringIn == null) throw new NullPointerException("Input String is null");
		return grepCount(this.root, stringIn);
	}

	

	/**
	 * Helper method to count occurrence of input string
	 * @param x = root node
	 * @param stringIn = string to be searched
	 * @return returns the count of occurrence of the input string
	 */
	private int grepCount(Node x, String stringIn) {
		while (x != null) {
			int cmp = stringIn.compareTo(x.getMainString());
			if      (cmp < 0) x = x.getLeft();
			else if (cmp > 0) x = x.getRight();
			else              return x.getCount();
		}
		return 0;
	}


	/**
	 *
	 * @return total words present in the tree
	 */
	public String getCountWord() {
		String resultString;

		getFrequentWordHelper(root);

		resultString = Integer.toString(totalWords) + "," + Integer.toString(totalNoChars) + "," + Integer.toString(maxFrequency) + ',';

		if (frequentWords != null) {
			for (Iterator<String> iterator = frequentWords.iterator(); iterator.hasNext(); ) {
				resultString = resultString.concat(iterator.next() + ",");
			}
		}
		return resultString;
	}

	/**
	 *
	 * @param node
	 */
	private void getFrequentWordHelper(Node node) {

		if (node != null) {
			getFrequentWordHelper(node.getLeft());

			totalWords=totalWords+node.getCount();
			int count = node.getCount();
			totalNoChars = totalNoChars + (count * node.getMainString().trim().length());
			if (count > maxFrequency) {
				maxFrequency = node.getCount();
				frequentWords = new ArrayList<>();
				frequentWords.add(node.getMainString());
			} else if (count == maxFrequency) {
				frequentWords.add(node.getMainString());
			}

			getFrequentWordHelper(node.getRight());
		}
	}

	/**
	 *
	 * @param visitor
	 */
	@Override
	public void accept(TreeProcessingVisitorI visitor) {
		visitor.visit(this);
	}

	/**
	 * Inorder Traversal
	 */
	public void inorderTraversal() {
		inorderTraversalHelper(this.root);
	}

	/**
	 * Helper method for inorder traversal
	 * @param node = root
	 */
	private void inorderTraversalHelper(Node node) {
		if (node != null) {
			inorderTraversalHelper(node.getLeft());
			
			inorderTraversalHelper(node.getRight());
		}
	}
	
	

}	

