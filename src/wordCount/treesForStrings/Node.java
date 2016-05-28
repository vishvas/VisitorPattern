package wordCount.treesForStrings;

public class Node {
	private Node left, right;
	private String mainString;
	private int count;  // no of time string appears
	
	

	/**
	 * Constructor to create a new Node
	 * @param stringHashCodeIn = word read from file
	 * @param countIn = count
	 */
	public Node(String main){
		mainString= main;
		count = 1;

	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	

	public void setCount(int countIn) {
		count = countIn;
	}

	/**
	 *
	 * @return
	 */
	public int getCount(){
		return count;
	}

	/**
	 *
	 */
	public void incrementCount(){
		count += 1;
	}

	/**
	 *
	 * @return
	 */
	public Node getLeft(){
		return left;
	}

	public String getMainString() {
		return mainString;
	}

	public void setMainString(String mainString) {
		this.mainString = mainString;
	}
	/**
	 *
	 * @return
	 */
	public Node getRight(){
		return right;
	}
	
	
}