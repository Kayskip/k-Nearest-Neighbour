package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * @author Karu Skipper
 * Student ID:300417869
 *
 */

public class KNN {
	
	private int k = 3; 
	private ArrayList<Flower> trainingList = new ArrayList<Flower>();
	private ArrayList<Flower> testingList = new ArrayList<Flower>();
	private ArrayList<String> predictionList = new ArrayList<String>();

	
	/**
	 * This is where I parse through the information from text document
	 * for it to be stored within an array of flowers.
	 * @param file to be scanned
	 * @return list of flowers
	 * @throws FileNotFoundException
	 */
	
	@SuppressWarnings("resource")
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
	
	/**
	 * Your program should take two file names as command line arguments, 
	 * and classify each instance in the test set (the second file name) 
	 * according to the training set (the first file name).
	 * @param training
	 * @param test
	 * @throws FileNotFoundException
	 */
	
	private void arguments(String training, String test) throws FileNotFoundException {
		double correct = 0;
		this.testingList = load(new File(test));
		this.trainingList = load(new File(training));
		
		for (int i = 0; i < testingList.size(); i++) {
			Flower[] neighbours = getNeighbours(testingList.get(i), k);
			String result = getResponses(neighbours);
			this.predictionList.add(result);
			if(result.equals(((Flower) testingList.get(i)).getName()))
				correct++;
			System.out.println("predicted: " + result + " | actual: " + ((Flower) testingList.get(i)).getName());
		}
		System.out.print("Accuracy: " + 100*correct/testingList.size() + "%");
	}

	private String getResponses(Flower[] neighbours) {
		int setosa = 0;
		int versicolor = 0;
		int virginica = 0;

		for (int i = 0; i < neighbours.length; i++) {
			if (neighbours[i].getName().equals("Iris-setosa"))
				setosa++;
			if (neighbours[i].getName().equals("Iris-virginica"))
				virginica++;
			if (neighbours[i].getName().equals("Iris-versicolor"))
				versicolor++;
		}

		if (setosa > versicolor && setosa > virginica) {
			return "Iris-setosa";
		} else if (versicolor > setosa && versicolor > virginica) {
			return "Iris-versicolor";
		}
		return "Iris-virginica";
	}

	private Flower[] getNeighbours(Flower flower, int k) {
		List<DistanceComparator> distances = new ArrayList<>();
		double dist;
		int length = flower.getMeasure().length - 1;

		for (int i = 0; i < trainingList.size(); i++) {
			dist = EuclideanDistance(flower, (Flower) trainingList.get(i), length);
			distances.add(new DistanceComparator((Flower) trainingList.get(i), dist));
		}
		
		Collections.sort(distances);
		Flower[] neighbours = new Flower[k];

		for (int i = 0; i < k; i++) 
			neighbours[i] = distances.get(i).getFlower();
		

		return neighbours;
	}

	/**
	 * This finds the distance between 2 points, so we can compare them
	 * @param first flower
	 * @param second flower
	 * @param range
	 * @return euclideanDistance from first flower to second
	 * 
	 */
	private double EuclideanDistance(Flower first, Flower second, double range) {
		double dist = 0;
		for (int i = 0; i < range; i++) {
			dist += Math.pow((first.getMeasure()[i] - second.getMeasure()[i]), 2) / this.getRange(i);
		}
		return Math.sqrt(dist);
	}

	/**
	 * @param i
	 * @return range to be used in euclidean alg
	 */
	
	private double getRange(int i) {
		double max = 0;
		double min = 1000;
		
		for (Flower flower : trainingList) {
			if (max < flower.getMeasure()[i]) {
				max = flower.getMeasure()[i];
			}
			else if (min > flower.getMeasure()[i]) {
				min = flower.getMeasure()[i];
			}
		}
		return max - min;
	}
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String []args) throws FileNotFoundException {
		new KNN().arguments(args[0], args[1]);
	}
}
