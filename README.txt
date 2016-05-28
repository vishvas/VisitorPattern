PURPOSE: Implement Visitor pattern on File and through tree data structure counted the number of words, characters,max frequency, and frequency of the given word.

FILES: Driver.java, BST.java, FileProcessor.java, Node.java, TreeProcessingVisitorI.java, WordCountVisitor.java, GrepVisitor.java, PopulateTreeVisitor.java, TreeVisitorI.java

SAMPLE OUTPUT: Depends upon Input, However for input file:
				The total number of words is: 6749
				The most frequently used word is: of  
				The frequency of the most frequently used word is: 248
				The number of characters (without whitespaces) is: 36522
				The word 'The' occurs the following times: 32



Arguments:
	1.InputFile
	2.OutputFile
	3.No_Of_Iteration
	4.Grep_String

COMPILE THE CODE: ant -buildfile build.xml all

RUN THE CODE: ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=The

CHOICE OF DATA STRUCTURE: Binary Search Tree
->Complexity of Data Structure:
		
Space	O(n)
Search	O(log n)
Insert	O(log n) 
Delete	O(log n)
In worst case all Search, Insert and Delete is (n)of objects.

CODE REFERENCE:
https://docs.oracle.com/javase/tutorial/essential/io/file.html
https://docs.oracle.com/javase/7/docs/api/java/nio/file/package-summary.html
http://howtodoinjava.com/java-7/nio/3-ways-to-read-files-using-java-nio/
http://tutorials.jenkov.com/java-nio/buffers.html


EXTRA CREDIT: N/A