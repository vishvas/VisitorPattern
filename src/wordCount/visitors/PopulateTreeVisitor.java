package wordCount.visitors;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;

import java.io.IOException;



public class PopulateTreeVisitor implements TreeProcessingVisitorI {

	private FileProcessor fp=null;
	
	/**
     *
     * @param inputListIn
     */
    public PopulateTreeVisitor(FileProcessor fpIn) {
        fp = fpIn;
    }

    /**
     * Visit method of Populate
     * creates the tree using string	
     */
    @Override
    public void visit(BST tree) {
    		String[] stringArray=null;
    		try {
				stringArray = fp.readLineFromFile();
				
			} catch (IOException e) {
				System.err.println("Error In Reading File");
				e.printStackTrace();
				System.exit(0);
			}
        	for(String word : stringArray){
                if (!(word.trim().matches("")))
                	tree.insert(word);
            }
    }
}