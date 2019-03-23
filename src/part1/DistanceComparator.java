package part1;
/**
 * @author karu
 * ID: 300417869
 */
public class DistanceComparator implements Comparable<DistanceComparator>{
	private Flower flower;
	private double number;

	DistanceComparator(Flower flower, double number) {
		this.setFlower(flower);
		this.setNumber(number);
	}
	public Flower getFlower() {
		return flower;
	}
	public void setFlower(Flower flower) {
		this.flower = flower;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	@Override
	public int compareTo(DistanceComparator o) {
		if (this.getNumber() <= o.getNumber())
			return -1;
		else
			return 1;
	}	
}
