package demoFile;

import java.io.File;
import java.io.IOException;

public class _3_check_number_of_files_or_directories_in_folder {

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

		// (2) creating 6 files in the folder
		File oneTxtFile = new File("F:/_CreateFolderByJAVA/one.txt");
		File twoTxtFile = new File("F:/_CreateFolderByJAVA/two.txt");
		File threeTxtFile = new File("F:/_CreateFolderByJAVA/three.txt");
		File fourTxtFile = new File("F:/_CreateFolderByJAVA/four.txt");
		File fiveTxtFile = new File("F:/_CreateFolderByJAVA/five.txt");
		File sixTxtFile = new File("F:/_CreateFolderByJAVA/six.txt");

		try {
			oneTxtFile.createNewFile();
			twoTxtFile.createNewFile();
			threeTxtFile.createNewFile();
			fourTxtFile.createNewFile();
			fiveTxtFile.createNewFile();
			sixTxtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// (3) How many Files/Folders in a directory
		if (fileExeFolder.isDirectory()) {
			File[] listFiles = fileExeFolder.listFiles();
			System.out.println(listFiles.length);
		}
	}

}
