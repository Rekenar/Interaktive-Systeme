package at.ias.model;

/*
 * Represents a circle type
 */
public class Circle extends Figure {

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Figure.roundTo2DecimalPlaces(radius * radius * Math.PI);
	}

	@Override
	public double getPerimeter() {
		return Figure.roundTo2DecimalPlaces(2 * radius * Math.PI);
	}

}
