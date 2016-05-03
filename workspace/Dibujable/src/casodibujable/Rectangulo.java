package casodibujable;

public class Rectangulo extends Geometria {
	// definición de variables miembro de la claes
	private static int numRectangulos = 0;
	protected double x1;
	protected double x2;
	protected double y1;
	protected double y2;

	// constructores de la clase
	public Rectangulo(double p1x, double p1y, double p2x, double p2y) {
		x1 = p1x;
		x2 = p2x;
		y1 = p1y;
		y2 = p2y;
		numRectangulos++;
	}

	public Rectangulo() {
		this(0, 0, 1.0, 1.0);
	}

	public double perimetro() {
		return 2.0 * ((x1 - x2) + (y1 - y2));
	}

	public double area() {
		return (x1 - x2) * (y1 - y2);
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}
}