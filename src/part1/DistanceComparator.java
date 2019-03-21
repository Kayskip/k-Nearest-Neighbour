package part1;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Result>{

	@Override
	public int compare(Result o1, Result o2) {
		return o1.getDistance() < o2 .getDistance() ? -1 : o1.getDistance() == o2.getDistance() ? 0 : 1;
	}

}
