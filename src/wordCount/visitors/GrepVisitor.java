package wordCount.visitors;

import wordCount.treesForStrings.BST;

import java.util.List;

public class GrepVisitor implements TreeProcessingVisitorI {

	private String grepString;
	private List<String> outputList;

	/**
	 *
	 * @param grepStringIn
	 * @param outputListIn
	 */
	public GrepVisitor(String grepStringIn, List<String> outputListIn) {
		grepString = grepStringIn;
		outputList = outputListIn;
	}

	/**
	 *
	 * @param tree
	 */
	@Override
	public void visit(BST tree) {
		outputList.add("The word '" + grepString + "' occurs the following times: " + Integer.toString(tree.grep(grepString)) + '\n');
	}

}