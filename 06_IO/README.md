# Subjects Covered in this repository
1. Create File/Directory 
2. Write/Read Text to/from files,
3. Write/Read Binary Type (Such JPG) to/from files,
4. Write/Read Objects to/from file

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
|     |[9.1. BufferedWriter to write List of array to a file](#9_1_buffered_writer_to_write_list_of_data) |
|  10  |[Write_Read_Binary_to_from_file](#10_Write_Read_Binary_to_from_file) |
|  11  |[Write_Read_Objects_to_from_file](#11_Write_Read_Objects_to_from_file) |
|  12  |[Read file from resources Spring boot](https://howtodoinjava.com/spring-boot2/read-file-from-resources/) |





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

## 9_1_buffered_writer_to_write_list_of_data

See example from link: 
* https://www.digitalocean.com/community/tutorials/java-append-to-file

When I write data List of data to txt file , it deletes the previous data. </br>
Thus ,  In order to write to a file , w/o deleting the prev line
* So that each insert will be in the next line,
* We use `FileWriter` along with `BufferedWriter`.
* `BufferedWriter` allows us to go to the next line

Example I want to read the data from DB and copy it to an sql file. </br>
I use :
1. `FileWriter` to create a file
2. I define `BufferedWriter` and pass as argument the `FileWriter`
3. I iterate over the List
4. On each iteration I `bufferedWriter.write(sqlQuestion)`
5. And `bufferedWriter.newLine()` got to next line
6. at the end of the iteration , I close the writer `bufferedWriter.close()`

```java
    public void writeToFile() throws IOException {
        List<String> str = questionRepository.findAll();

	FileWriter fileWriter = new FileWriter(WRITE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	for (String s : str) {
   	    // convert the string to sql statement format
            String sqlQuestion = "INSERT INTO QUESTION_TB (id ,subject ,question, answers, correct_answer) VALUES ("
                    + question.getId() + ","
                    + "'" + question.getSubject() + "',"
                    + "'" + question.getQuestion() + "',"
                    + "'" + question.getAnswers() + "',"
                    + "'" + question.getCorrectAnswer() + ");";
            bufferedWriter.write(sqlQuestion);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
```


----------------------------------------------------------------------------------------------------------

## 10_Write_Read_Binary_to_from_file

FileInputStream / FileOutputStream can read and write from binary files </br>
such as jpg files and also from txt files </br>
(Every file type is actually a binary file)


[Back_to_top](#Table-of-contents)
```java
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


```

----------------------------------------------------------------------------------------------------------

## 11_Write_Read_Objects_to_from_file

[Back_to_top](#Table-of-contents)
```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class ObjectReadWriteStream {

	public void writeTeam(Object obj) throws IOException {

		// (2) now lets write this team into the file
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("F:/_filesExercise/chicago.dat")));
			out.writeObject(obj);
		} finally {
			if (out != null)
				out.close();
		}

	}

	public BasketBallTeam readTeam() throws IOException, ClassNotFoundException {

		// lets read the team from the file
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("F:/_filesExercise/chicago.dat")));
			BasketBallTeam result = (BasketBallTeam) in.readObject();
			return result;
		} finally {
			if (in != null)
				in.close();
		}
	}

}

// this class will be written into the file 
// and afterwards be read from the file...
// (5) we must make it serializable

//into the one below with implementation. 
class BasketBallTeam implements Serializable {

	private static final long serialVersionUID = 6318583645366351675L;

	private long budget;
	private String name;
	private String[] listOfPlayers;

	public BasketBallTeam(long budget, String name, String[] listOfPlayers) {
		super();
		this.budget = budget;
		this.name = name;
		this.listOfPlayers = listOfPlayers;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(String[] listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	@Override
	public String toString() {
		return "BasketBallTeam [budget=" + budget + ", name=" + name + ", listOfPlayers="
				+ Arrays.toString(listOfPlayers) + "]";
	}

}

public class _11_Write_Read_Objects_to_from_file {

	public static void main(String[] args) {

		// (1) here we will create a team and write it into the file
		BasketBallTeam bulls = new BasketBallTeam(30_000_000, "Chicago bulls",
				new String[] { "MJ", "Karim", "Shaquil" });

		ObjectReadWriteStream rw = new ObjectReadWriteStream();

		// Write Object to a file
		try {
			rw.writeTeam(bulls);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Write Object from a file
		try {
			BasketBallTeam result = rw.readTeam();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

```
