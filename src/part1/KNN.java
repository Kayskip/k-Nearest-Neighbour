package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Name: Karu Skipper
 * Student ID:300417869
 */

/* k-Nearest Neighbour algorithm 'KNN'*/

public class KNN {
	
	private int k = 1; // nearest 1 neighbours (for now)
	private ArrayList<Flower> trainingList = new ArrayList<Flower>();
	private ArrayList<Flower> testingList = new ArrayList<Flower>();
	
	/* This is where I parse through the information from text document
	 * for it to be stored within an array of flowers.
	 */
	private ArrayList<Flower> load(File arg) throws FileNotFoundException {
		
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
		
		return flowers;
	}
	/*
	Your program should take two file names as command line arguments, 
	and classify each instance in the test set (the second file name) 
	according to the training set (the first file name).
	*/
	
	private void arguments(String training, String test) throws FileNotFoundException {
		
		this.testingList = load(new File(test));
		this.trainingList = load(new File(training));
		
	}
	/*
	 * This finds the distance between 2 points, so we can compare them
	 * Returns the euclideanDistance from first flower to second
	 * 
	 * 
	 */
	private double EuclideanDistance(Flower first, Flower second) {
		double dist = 0;
		// use euclidean alg
		return Math.sqrt(dist);
		
	}
	public static class Result {
		public double distance;
		public Flower flower;
		public Result(double distance, Flower flower) {
			this.distance = distance;
			this.flower = flower;
		}
		public double getDistance() {
			return distance;
		}
	}
	public static class DistanceComparator<Result> implements Comparator<Result>{
		public double distance;
		public Flower flower;
		
		public DistanceComparator(double distance, Flower flower) {
			this.distance = distance;
			this.flower = flower;
		}
		@Override
		public int compare(Result o1, Result b) {
			return 1;
		}
	}
	
	public static void main(String []args) {
		new KNN();
	}
}
