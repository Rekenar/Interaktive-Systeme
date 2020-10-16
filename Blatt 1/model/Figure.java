package at.ias.model;

/*
 * Root class (type) for the geometric figures we use
 */
public abstract class Figure {

	/*
	 * Quick and (somehow) dirty solution to limit the number of decimal places to 2
	 */
	public static double roundTo2DecimalPlaces(double toRound) {
		return Math.round(toRound * 100.00) / 100.00;
	}

	public abstract double getArea();

	public abstract double getPerimeter();

}
