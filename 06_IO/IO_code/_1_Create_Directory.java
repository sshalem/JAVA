package demoFile;

import java.io.File;

public class _1_Create_Directory {

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

	}

}
