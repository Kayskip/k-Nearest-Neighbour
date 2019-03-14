package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Name: Karu Skipper
 * Student ID:300417869
 */

/* k-Nearest Neighbour algorithm 'KNN'*/

public class KNN {
	
	/* This is where I parse through the information from text document
	 * for it to be stored within an array of flowers.
	 */
	private void load(File arg) throws FileNotFoundException {
		ArrayList<Flower> flowers = new ArrayList<Flower>();
		Scanner scanner = new Scanner(arg);
		while(scanner.hasNext()) {
			double sepalLength = scanner.nextDouble();
			double sepalWidth = scanner.nextDouble();
			double petalLength = scanner.nextDouble();
			double petalWidth = scanner.nextDouble();
			String name = scanner.next();
			flowers.add(new Flower(sepalLength,sepalWidth,petalLength,petalWidth,name));
		}
	}
	/*
	Your program should take two file names as command line arguments, 
	and classify each instance in the test set (the second file name) 
	according to the training set (the first file name).
	*/
	
	private void arguments(String training, String test) {
		
	}
	public static void main(String []args) {
		
	}
}
