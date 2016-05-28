package wordCount.visitors;

import wordCount.treesForStrings.BST;

import java.util.List;

public class WordCountVisitor implements TreeProcessingVisitorI {

	private String resultString;
	private List<String> outputList;

	/**
	 *
	 * @param outputFileIn
	 */
	public WordCountVisitor(List<String> outputFileIn) {
		outputList = outputFileIn;
	}

	/**
	 *visit method which count the word,
	 *character and maximum frequency of the word
	 * @param tree
	 */
	@Override
	public void visit(BST tree) {

		resultString = tree.getCountWord();
		String[] results = resultString.split(",");
		String frequentWords = "";

		outputList.add("The total number of words is: " + results[0]);
		for (int i = 3; i < results.length; i++) {
			frequentWords = frequentWords.concat(results[i] + "  ");
		}
		outputList.add("The most frequently used word is: " + frequentWords);
		outputList.add("The frequency of the most frequently used word is: " + results[2]);
		outputList.add("The number of characters (without whitespaces) is: " + results[1]);

	}

}