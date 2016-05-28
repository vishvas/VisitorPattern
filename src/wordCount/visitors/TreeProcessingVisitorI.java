package wordCount.visitors;

import wordCount.treesForStrings.BST;

public interface TreeProcessingVisitorI{
	/**
	 * Visit method of visitor pattern
	 * @param tree
	 */
    public void visit(BST tree);

}