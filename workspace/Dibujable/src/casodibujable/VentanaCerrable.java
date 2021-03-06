package casodibujable;

import java.awt.*;
import java.awt.event.*;

class VentanaCerrable extends Frame implements WindowListener {
	// constructores
	public VentanaCerrable() {
		super();
	}

	public VentanaCerrable(String title) {
		super(title);
		setSize(500, 500);
		addWindowListener(this);
	}

	// m�todos de la interface WindowsListener
	@Override
	public void windowActivated(WindowEvent e) {
		;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		;
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		;
	}

	@Override
	public void windowIconified(WindowEvent e) {
		;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		;
	}
}