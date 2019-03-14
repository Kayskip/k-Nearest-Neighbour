package part1;

/*
 * Name: Karu Skipper
 * Student ID:300417869
 */

public class Flower {
	
	/* There are four numeric attributes: sepal length in cm, sepal
	 * width in cm, petal length in cm, and petal width in cm.
	 * Therefore the flower class is created to store the attributes of the flower,
	 * which has been parsed in load method in the KNN class
	 */
	
	private double sepalLength;
	private double sepalWidth;
	private double petalLength;
	private double petalWidth;
	private String name;
	
	/* What I will do is create these flower objects and store them in an array with 
	 * the parsed information of the scanner in the KNN class
	 */
	
	public Flower(double sepalL, double sepalW, double petalL,double petalW, String name) {
		this.sepalLength = sepalL;
		this.sepalWidth = sepalW;
		this.petalLength = petalL;
		this.petalWidth = petalW;
		this.name = name;
	}

}
