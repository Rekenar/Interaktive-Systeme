package at.ias.model;

/*
 * Represents a rectangle type
 */
public class Rectangle extends Figure {

	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;

	}

	@Override
	public double getArea() {
		return Figure.roundTo2DecimalPlaces(length * width);
	}

	@Override
	public double getPerimeter() {
		return Figure.roundTo2DecimalPlaces(2 * length + 2 * width);
	}

}
