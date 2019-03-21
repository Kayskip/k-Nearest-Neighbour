package part1;

public class Result {
	
	private double distance;
	private String flowerName;
	
	public Result(double distance, String flowerName) {
		this.setDistance(distance);
		this.setFlowerName(flowerName);
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
