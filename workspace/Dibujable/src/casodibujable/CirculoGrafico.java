package casodibujable;

import java.awt.Graphics;
import java.awt.Color;

public class CirculoGrafico extends Circulo implements Dibujable {
	// se heredan las variables y métodos de la clase Circulo
	Color color;

	// constructor
	public CirculoGrafico(double x, double y, double r, Color unColor) {
		// llamada al constructor de Circulo
		super(x, y, r);
		this.color = unColor;
	}

	// métodos de la interface Dibujable
	public void dibujar(Graphics dw) {
		dw.setColor(color);
		dw.drawOval((int) (getX() - getR()), (int) (getY() - getR()), (int) (2 * getR()), (int) (2 * getR()));
	}

	public void setPosicion(double x, double y) {
		setX(x);
		setY(y);
	}
}