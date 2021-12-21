package sort;

public class MainTwoDimmensionArray {

	public static void main(String[] args) {

		/*
		 * In this Array 3 - number of rows 7 - number of columns
		 */
		int[][] arr = new int[3][7];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(" A ");
			}
			System.out.println();
		}
	}
	
	/* This is how the output would look:
	 * 3 - rows
	 * 7- columns
	 * 
 	 *		A  A  A  A  A  A  A 
 	 *		A  A  A  A  A  A  A 
 	 *		A  A  A  A  A  A  A 
	 */

}
