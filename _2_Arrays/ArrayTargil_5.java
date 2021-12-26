package sort;

import java.util.Random;

public class ArrayTargil_5 {

	public static void main(String[] args) {
		
		/**
		 * create a class that calculates student average year grade.
		 * create a matrix according to the following:
		 * there are 20 students in the class.
		 * there are 10 different grades per student (randomize values between 0-100 as input)
		 * print each student avg grade
		 * print the class avg grade
		 */
		
		float calcAvarage;
		float classAvarageGrade = 0;
		
		String studentName[] = {"Avraham", "Itschack", "Jacob",
								"Reuevn", "Shimon", "Levi",
								"Juda", "Isachar", "Zvulun",
								"Dan", "Asher" , "Gad",
								"Naftali", "Yosef", "Ninyamin",
								"Moshe", "Aharon" , "David",
								"Shlomo", "Shmuel"};
		
		int studentGrades[][] = new int[20][10];
		
		Random r = new Random();
		
		for (int i = 0; i < studentGrades.length; i++) {
			calcAvarage = 0;
			System.out.println("Grades of " + studentName[i] + " : ");
			for (int j = 0; j < studentGrades[j].length; j++) {
				studentGrades[i][j] = 1 + r.nextInt(100);
				System.out.print(" " + studentGrades[i][j] + ", ");
				calcAvarage = calcAvarage + studentGrades[i][j];
			}
			System.out.println(" \n Average grade of " + studentName[i] + " is : " + (calcAvarage/10) + " \n");
			classAvarageGrade = classAvarageGrade + (calcAvarage/10);
		}
		
		System.out.println("\n " + " class average grade is : " + (classAvarageGrade/20));
	}

}


