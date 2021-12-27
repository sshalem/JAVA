package demoFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class BinaryFileInputOutputStream {

	public int[] goRead(File file, String readPath) throws IOException {

		FileInputStream in = null;
		try {

			long size = file.length();
			int[] storeData = new int[(int) size];
			in = new FileInputStream(readPath);
			int b = in.read();
			int i = 0;
			while (b != -1) {
				storeData[i] = b;
				b = in.read();
				i++;
			}
			return storeData;
		} finally {
			if (in != null)
				in.close();
		}
	}

	public void goWrite(int[] data, String writePath) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(writePath);
			for (int i = 0; i < data.length; i++) {
				out.write(data[i]);
			}
		} finally {
			if (out != null)
				out.close();
		}
	}

}

public class _10_Write_Read_Binary_to_from_file {

	public static void main(String[] args) {
		
		/**
		 * We will read the Capture.PNG file
		 * and write it to a new file that will be created once we perform the write operation 
		 * the file name that will be created is picture.PNG
		 */
		String readPath = "F:/_filesExercise/Capture.PNG";
		String writePath = "F:/_filesExercise/picture.PNG";

		File file = new File(readPath);

		int[] readDataFromFile = new int[(int) file.length()];
		int[] writeDataToFile = null;

		BinaryFileInputOutputStream binaryStream = new BinaryFileInputOutputStream();

		// (1) read data Binary data (the PNG type) from file
		try {
			readDataFromFile = binaryStream.goRead(file, readPath);
			writeDataToFile = readDataFromFile;
		} catch (IOException e) {
			e.printStackTrace();
		}

		// (2) write data to file
		try {
			binaryStream.goWrite(writeDataToFile, writePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
