package wordCount.driver;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.visitors.GrepVisitor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class Driver {

	public static void main(String[] args){

		if(args.length == 0 || args.length < 4 || args.length>4){
			System.out.println("No of argument should be 4. <Input_File> <Output_File> <No_Iteration> <Search_String>");
			System.exit(0);
		}

		String input_file = args[0];
		String output_file = args[1];
		String grepString = args[3];
		int no_iteration = 0;

		/**
		 * Convert number of iterations input as string to integer
		 */
		try{
			no_iteration = Integer.parseInt(args[2]);
		} catch(NumberFormatException e) {
			System.out.println("Invalid Entry for No of Iteration, should be an Integer");
			e.printStackTrace();
			System.exit(0);
		} catch(Exception e) {
			System.out.println("Format of No of Iteration is incorrect");
			e.printStackTrace();
			System.exit(0);
		}

		

		
		
		Path file = Paths.get(output_file);
		File f = new File(output_file);
		
		
		try {
			if (f.exists()) {
				FileWriter writer = new FileWriter(f);
				writer.write("");
				writer.close();
			} else {
				f.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("Error creating output file");
			e.printStackTrace();
			System.exit(0);
		} finally {
			
		}

		long startTime = System.currentTimeMillis();
		/**
		 * created Instance of Classes
		 */
		List<String> outputList;
		FileProcessor fp = null;
		BST bst;
		TreeProcessingVisitorI populate;
		TreeProcessingVisitorI count;
		TreeProcessingVisitorI grep;
		
		
		
		for (int i = 0; i < no_iteration; i++) {
			outputList = new ArrayList<>();
			bst = new BST();
			
			try {
				fp = new FileProcessor(input_file);
			}catch(FileNotFoundException e){
				System.out.println("File: "+input_file + " is not found");
				System.exit(0);
			}
			catch (IOException e) {
				System.out.println("Error In File");
				e.printStackTrace();
				System.exit(0);
			}
			
			
			
			populate = new PopulateTreeVisitor(fp); //creating the tree
			count = new WordCountVisitor(outputList); // getting a count of word, character and maximum freq
			grep = new GrepVisitor(grepString, outputList); // Get the count of grep string
			
			
			bst.accept(populate);
			bst.accept(count);
			bst.accept(grep);
			try {
				Files.write(file, outputList, Charset.forName("ASCII"), StandardOpenOption.APPEND);
				
			} catch (IOException e) {
				System.out.println("Error writing to output file.");
				e.printStackTrace();
				System.exit(0);
			}
		}


		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime - startTime) / no_iteration;
		System.out.println("Total time for " + no_iteration + " iteration is: " + total_time + " ms.");


	}
}
