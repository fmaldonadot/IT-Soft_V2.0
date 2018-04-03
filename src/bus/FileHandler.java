package bus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler {

	public static final String filePath = "src/data/employees.ser";
	
	// 1- write to serialized file
		
	public static void writeData(DataHandler<?, ?> myCollection) throws IOException 
	{
		FileOutputStream outFile = new FileOutputStream(filePath);	
			
		@SuppressWarnings("resource")
		ObjectOutputStream outStream = new ObjectOutputStream(outFile);	
			
		outStream.writeObject(myCollection);			
			
	}

	// 2- read from serialized file
	public static DataHandler<?, ?> readData() throws IOException, FileNotFoundException,ClassNotFoundException
	{
		DataHandler<?, ?> collectionFromFile;
				
		FileInputStream inFile = new FileInputStream(filePath);	
		
		@SuppressWarnings("resource")
		ObjectInputStream inStream = new ObjectInputStream(inFile);
			
	    collectionFromFile =  (DataHandler<?, ?>) inStream.readObject();
				
		return collectionFromFile;
	}
}
