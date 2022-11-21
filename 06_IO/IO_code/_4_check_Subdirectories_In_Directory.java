package demoFile;

import java.io.File;

public class _4_check_Subdirectories_In_Directory {

	public static void main(String[] args) {

		// (1) creating a directory        
		File fileExeFolder = new File("F:/_CreateFolderByJAVA");
		fileExeFolder.mkdir();

		// check if folder is exist
		if (fileExeFolder.exists()) {
			System.out.println("Folder allready exist");
		} else {
			fileExeFolder.mkdir();
			System.out.println("Folder created");
		}

		// (2) creating 3 more directories inside the folder _CreateFolderByJAVA
		File subDir_1 = new File("F:/_CreateFolderByJAVA/subDir_1");
		subDir_1.mkdir();

		File subDir_2 = new File("F:/_CreateFolderByJAVA/subDir_2");
		subDir_2.mkdir();

		File subDir_3 = new File("F:/_CreateFolderByJAVA/subDir_3");
		subDir_3.mkdir();

		File[] listFiles = fileExeFolder.listFiles();

		// (3) How many Files/Folders in a directory
		if (fileExeFolder.isDirectory()) {
			System.out.println(listFiles.length);
		}

		// (4) How many SubDirectories in a directory
		int numberOfSubDirectories = 0;

		for (File file : listFiles) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
				numberOfSubDirectories++;
			}
		}

		System.out.println(numberOfSubDirectories);
	}

}
