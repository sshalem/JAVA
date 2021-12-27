
# Create File/Directory ,Write/Read to File

## Table-of-contents

|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Create_Directory](#1_Create_Directory)    | 
|  2  |[Create_File](#2_Create_File)  |   
|  3  |[check_number_of_files_or_directories_in_folder](#3_check_number_of_files_or_directories_in_folder) |   
|  4  |[check_Subdirectories_In_Directory](#4_check_Subdirectories_In_Directory)   |   
|  5  |[show_only_txt_files](#5_show_only_txt_files) |
|  6  |[SortAndDisplayFilesBySize](#6_SortAndDisplayFilesBySize) |
|  7  |[SortAndDisplayFilesByName](#7_SortAndDisplayFilesByName) |
|  8  |[SortAndDisplayDirectoryFirst](#8_SortAndDisplayDirectoryFirst) |
|  9  |[Write_Read_Text_to_from_file](#9_Write_Read_Text_to_from_file) |




## 1_Create_Directory
[Back_to_top](#Table-of-contents)

```java
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
```
----------------------------------------------------------------------------------------------------------

## 2_Create_File

[Back_to_top](#Table-of-contents)

```java
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
```
----------------------------------------------------------------------------------------------------------


## 3_check_number_of_files_or_directories_in_folder

[Back_to_top](#Table-of-contents)

```java
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
```
----------------------------------------------------------------------------------------------------------


## 4_check_Subdirectories_In_Directory

[Back_to_top](#Table-of-contents)
```java
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

```
----------------------------------------------------------------------------------------------------------

## 5_show_only_txt_files

[Back_to_top](#Table-of-contents)
```java
import java.io.File;

public class _5_show_only_txt_files {

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

		// (5) Show only txt files
		for (File file : listFiles) {
			if (file.getName().endsWith(".txt")) {
				System.out.println(file.getName());
			}
		}
	}
}
```
----------------------------------------------------------------------------------------------------------

## 6_SortAndDisplayFilesBySize

[Back_to_top](#Table-of-contents)
```java
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortFilesBySize implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {
		return (int) (o1.length() - o2.length());
	}

}

public class _6_SortAndDisplayFilesBySize {

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

		// (4) sort & display fileBySize
		Collections.sort(arrayFiles, new SortFilesBySize());
		System.out.println(arrayFiles);

	}
}
```
----------------------------------------------------------------------------------------------------------

## 7_SortAndDisplayFilesByName

[Back_to_top](#Table-of-contents)
```java
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortAndDisplayDirectoryFirst implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {
		if (o1.isDirectory() && o2.isDirectory())
			return 0;
		if (o1.isFile() && o2.isFile())
			return 0;
		return -1;
	}

}

public class _7_SortAndDisplayFilesByName {

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

		// (4) sort & display Directory First
		Collections.sort(arrayFiles, new SortAndDisplayDirectoryFirst());
		System.out.println(arrayFiles);
	}
}
```
----------------------------------------------------------------------------------------------------------

## 8_SortAndDisplayDirectoryFirst

[Back_to_top](#Table-of-contents)
```java
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
```
----------------------------------------------------------------------------------------------------------

## 9_Write_Read_Text_to_from_file

For writing/reading from txt files we use FileReader/FileWriter

[Back_to_top](#Table-of-contents)
```java
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

```
----------------------------------------------------------------------------------------------------------
