package demoFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortFilesByName implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

public class _8_SortAndDisplayDirectoryFirst {

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

		// (3) Add to ArrayList the content of an directory
		List<File> arrayFiles = new ArrayList<>();

		File[] listFiles = fileExeFolder.listFiles();

		for (File file : listFiles) {
			arrayFiles.add(file);
		}
		System.out.println(arrayFiles);

		// After we add all files and placed them in an ArrayList
		// We can sort the files by : size, name

		// (4) sort & display fileByName
		Collections.sort(arrayFiles, new SortFilesByName());
		System.out.println(arrayFiles);

	}

}
