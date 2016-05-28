package wordCount.util;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


// File reading code

public class FileProcessor {


    private String fileName;
    private RandomAccessFile aFile;
    private MappedByteBuffer buffer = null;
    private FileChannel inChannel;

    public FileProcessor(String fileNameIn) throws IOException{
       
        fileName = fileNameIn;
        aFile = new RandomAccessFile(fileName, "r");
        inChannel = aFile.getChannel();
        buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
         
    }

    /**
     * Read the file into the buffer
     * @return
     * @throws IOException
     */
    public String[] readLineFromFile() throws IOException{
    	buffer.load(); 
        byte[] b = new byte[buffer.remaining()];
        buffer.get(b);
        String line = new String(b);
        String[] stringArray = line.trim().split("\\s+");
        buffer.clear(); 
        inChannel.close();
        aFile.close();
       return stringArray;
    }

    

}
