

// fichero Circulo.java
 public class Circulo extends Geometria {
 static int numCirculos = 0;
 public static final double PI=3.14159265358979323846;
 public double x, y, r;
 public Circulo(double x, double y, double r) {
 this.x=x; this.y=y; this.r=r;
 numCirculos++;
 }
 public Circulo(double r) { this(0.0, 0.0, r); }
 public Circulo(Circulo c) { this(c.x, c.y, c.r); }
 public Circulo() { this(0.0, 0.0, 1.0); }
 public double perimetro() { return 2.0 * PI * r; }
 public double area() { return PI * r * r; }
 // método de objeto para comparar círculos
 public Circulo elMayor(Circulo c) {
 if (this.r>=c.r) return this; else return c;
 }
 // método de clase para comparar círculos
 public static Circulo elMayor(Circulo c, Circulo d) {
 if (c.r>=d.r) return c; else return d;
 }
 } // fin de la clase Circulo


// fichero CirculoGrafico.java
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
dw.drawOval((int)(x-r),(int)(y-r),(int)(2*r),(int)(2*r));
}
public void setPosicion(double x, double y) {
;
}
} // fin de la clase CirculoGrafico

 // fichero Dibujable.java
 import java.awt.Graphics;
 public interface Dibujable {
 public void setPosicion(double x, double y);
 public void dibujar(Graphics dw);
 }

// fichero Ejemplo1.java
import java.util.ArrayList;
import java.awt.*;

class Ejemplo1 {
public static void main(String arg[]) throws InterruptedException
{
 System.out.println("Comienza main()...");
 Circulo c = new Circulo(2.0, 2.0, 4.0);
 System.out.println("Radio = " + c.r + " unidades.");
 System.out.println("Centro = (" + c.x + "," + c.y + ") unidades.");
 Circulo c1 = new Circulo(1.0, 1.0, 2.0);
 Circulo c2 = new Circulo(0.0, 0.0, 3.0);
 c = c1.elMayor(c2);
 System.out.println("El mayor radio es " + c.r + ".");
 c = new Circulo(); // c.r = 0.0;
 c = Circulo.elMayor(c1, c2);
 System.out.println("El mayor radio es " + c.r + ".");
 VentanaCerrable ventana =
 new VentanaCerrable("Ventana abierta al mundo...");
 ArrayList v = new ArrayList();
 CirculoGrafico cg1 = new CirculoGrafico(200, 200, 100, Color.red);
 CirculoGrafico cg2 = new CirculoGrafico(300, 200, 100, Color.blue);
 RectanguloGrafico rg = new
 RectanguloGrafico(50, 50, 450, 350, Color.green);
 v.add(cg1);
 v.add(cg2);
 v.add(rg);
 PanelDibujo mipanel = new PanelDibujo(v);
 ventana.add(mipanel);
 ventana.setSize(500, 400);
 ventana.setVisible(true);
 System.out.println("Termina main()...");
 } // fin de main()
 } // fin de class Ejemplo1

// fichero Geometria.java
 public abstract class Geometria {
 // clase abstracta que no puede tener objetos
 public abstract double perimetro();
 public abstract double area();
 }

 // fichero PanelDibujo.java
 import java.awt.*;
 import java.util.ArrayList;
 import java.util.Iterator;
 public class PanelDibujo extends Panel {
 // variable miembro
 private ArrayList v;
 // constructor
 public PanelDibujo(ArrayList va) {
 super(new FlowLayout());
 this.v = va;
 }
 // redefinición del método paint()
 public void paint(Graphics g) {
 Dibujable dib;
 Iterator it;
 it = v.iterator();
 while(it.hasNext()) {
 dib = (Dibujable)it.next();
 dib.dibujar(g);
 }
 }
 } // Fin de la clase PanelDibujo


 // fichero Rectangulo.java
 public class Rectangulo extends Geometria {
 // definición de variables miembro de la claes
 private static int numRectangulos = 0;
 protected double x1, y1, x2, y2;
 // constructores de la clase
 public Rectangulo(double p1x, double p1y, double p2x, double p2y) {
 x1 = p1x;
 x2 = p2x;
 y1 = p1y;
 y2 = p2y;
 numRectangulos++;
 }
 public Rectangulo(){ this(0, 0, 1.0, 1.0); }
 // definición de métodos
 public double perimetro() { return 2.0 * ((x1-x2)+(y1-y2)); }
 public double area() { return (x1-x2)*(y1-y2); }
 } // fin de la clase Rectangulo

 // Fichero RectanguloGrafico.java
 import java.awt.Graphics;
 import java.awt.Color;
 class RectanguloGrafico extends Rectangulo implements Dibujable {
 // nueva variable miembro
 Color color;
 // constructor
 public RectanguloGrafico(double x1, double y1, double x2, double y2,
 Color unColor) {
 // llamada al constructor de Rectangulo
 super(x1, y1, x2, y2);
 this.color = unColor; // en este caso this es opcional
 }
 // métodos de la interface Dibujable
 public void dibujar(Graphics dw) {
 dw.setColor(color);
 dw.drawRect((int)x1, (int)y1, (int)(x2-x1), (int)(y2-y1));
 }
 public void setPosicion(double x, double y) {
 ; // método vacío, pero necesario de definir
 }
 } // fin de la clase RectanguloGrafico


// Fichero VentanaCerrable.java
 import java.awt.*;
 import java.awt.event.*;
 class VentanaCerrable extends Frame implements WindowListener {
 // constructores
 public VentanaCerrable() {
 super();
 }
 public VentanaCerrable(String title) {
 super(title);
 setSize(500,500);
 addWindowListener(this);
 }
 // métodos de la interface WindowsListener
 public void windowActivated(WindowEvent e) {;}
 public void windowClosed(WindowEvent e) {;}
 public void windowClosing(WindowEvent e) {System.exit(0);}
 public void windowDeactivated(WindowEvent e) {;}
 public void windowDeiconified(WindowEvent e) {;}
 public void windowIconified(WindowEvent e) {;}
 public void windowOpened(WindowEvent e) {;}
 } // fin de la clase VentanaCerrable