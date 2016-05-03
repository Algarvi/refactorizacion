package casodibujable;

public class Circulo extends Geometria {
	static int numCirculos = 0;
	public static final double PI = 3.14159265358979323846;
	private double x;
	private double y;
	private double r;

	public Circulo(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		numCirculos++;
	}

	public Circulo(double r) {
		this(0.0, 0.0, r);
	}

	public Circulo(Circulo c) {
		this(c.x, c.y, c.r);
	}

	public Circulo() {
		this(0.0, 0.0, 1.0);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double perimetro() {
		return 2.0 * PI * r;
	}

	public double area() {
		return PI * r * r;
	}

	public Circulo elMayor(Circulo c) {
		if (this.r >= c.r)
			return this;
		else
			return c;
	}

	public static Circulo elMayor(Circulo c, Circulo d) {
		if (c.r >= d.r)
			return c;
		else
			return d;
	}
}