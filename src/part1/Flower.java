package part1;

/*
 * Name: Karu Skipper
 * Student ID:300417869
 */

/**
 * @author karu
 *
 */
public class Flower {
	
	/* There are four numeric attributes: sepal length in cm, sepal
	 * width in cm, petal length in cm, and petal width in cm.
	 * Therefore the flower class is created to store the attributes of the flower,
	 * which has been parsed in load method in the KNN class
	 */
	
	private double[] measure = new double[4];
	private String name;
	
	
	/* What I will do is create these flower objects and store them in an array with 
	 * the parsed information of the scanner in the KNN class
	 */
	
	/**
	 * @param sepalL
	 * @param sepalW
	 * @param petalL
	 * @param petalW
	 * @param name
	 */
	public Flower(double sepalL, double sepalW, double petalL,double petalW, String name) {
		this.measure[0] = sepalL;
		this.measure[1] = sepalW;
		this.measure[2] = petalL;
		this.measure[3] = petalW;
		this.setName(name);
	}
	
	/**
	 * @return measure
	 */
	public double[] getMeasure() {
		return this.measure;
		
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
