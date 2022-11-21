package demoFile;

import java.io.File;
import java.io.IOException;

public class _2_Create_File {

	public static void main(String[] args) {

		// (1) creating a directory  
		File fileExeFolder = new File("F:/_CreateFolderByJAVA");

		// check if folder is exist
		if (fileExeFolder.exists()) {
			System.out.println("Folder allready exist");
		} else {
			fileExeFolder.mkdir();
			System.out.println("Folder created");
		}

		// (2) creating files in the
		File oneTxtFile = new File("F:/_CreateFolderByJAVA/one.txt");

		try {
			oneTxtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
