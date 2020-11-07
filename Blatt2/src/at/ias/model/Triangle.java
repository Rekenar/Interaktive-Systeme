package at.ias.model;

/*
 * Represents a triangle type
 */
public class Triangle extends Figure {

	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	@Override
	public double getArea() {
		// "Heron's Formula" to calculate a triangle's area with the length of all three sides given
		double s = (sideA + sideB + sideC) / 2;
		return Figure.roundTo2DecimalPlaces(Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)));
	}

	@Override
	public double getPerimeter() {
		return Figure.roundTo2DecimalPlaces(sideA + sideB + sideC);
	}

}
