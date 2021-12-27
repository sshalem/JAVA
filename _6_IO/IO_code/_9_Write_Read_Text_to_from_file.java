package demoFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class ReadWrite {

	public String goRead(File file, String path) throws IOException {
		FileReader in = null;
		try {
			in = new FileReader(path);
			long size = file.length();
			char[] data = new char[(int) size];
			in.read(data);
			return new String(data);
		} finally {
			if (in != null)
				in.close();
		}
	}

	public void goWrite(String path, String data) throws IOException {
		FileWriter out = null;
		try {
			out = new FileWriter(path);
			out.write(data);
		} finally {
			if (out != null)
				out.close();
		}
	}
}

public class _9_Write_Read_Text_to_from_file {

	public static void main(String[] args) {

		/**
		 * In this example create file one.txt 
		 * in the directory of F:/_filesExercise/one.txt
		 * And I fill it with DATA
		 * 
		 * I will read the data from file one.txt
		 * 
		 * I will write the read data from one.txt and write it to file two.txt
		 */
		
		// path of file to read from
		String readPath = "F:/_filesExercise/one.txt";
		File readFromFile = new File(readPath);

		String readDataFromFile = null;
		String writeDataToFile = null;

		ReadWrite rw = new ReadWrite();

		// (1) read data from file
		try {
			readDataFromFile = rw.goRead(readFromFile, readPath);
			System.out.println(readDataFromFile);
			writeDataToFile = readDataFromFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// (2)write data to file
		String writePath = "F:/_filesExercise/two.txt";
		try {
			rw.goWrite(writePath, writeDataToFile);
		}catch (IOException e) {
			e.printStackTrace();
		}

	}
}
