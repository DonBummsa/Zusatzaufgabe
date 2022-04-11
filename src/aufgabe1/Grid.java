package aufgabe1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.applet.*;

public class Grid extends JFrame {
	public static int width = 1024;
	public static int height = 786;
	public static int pixelratio = 10;

	/**
	 * Konstruktor aus der Übung
	 */
	public Grid() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setTitle("Plotter");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Grid();
	}

	int center_x = 1024;
	int center_y = 512;

	// TODO: implementiere ein Koordinatenkreuz
	/**
	 * coordinates zeichnet ein Koordinatenkreuz.
	 */
	public void coordinates(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(width / 2, height / 2);
		g2.setStroke(new BasicStroke(1));
		Color lighterGray = new Color(211, 211, 211); // Color white
		for (int i = -width / 2; i < width / 2; i++) {

			if (i % 16 == 0) {

				g2.setColor(lighterGray);
				g2.drawLine(i, -width, i, width);
				g2.drawLine(-height, i, height, i);

			}

			g2.setColor(Color.LIGHT_GRAY);
			if (i % 80 == 0) {
				g2.drawLine(i, -width, i, width);
				g2.drawLine(-height, i, height, i);

			}

		}
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.draw(new Line2D.Float(width / 2, 0, -width / 2, 0)); // achse 1
		g2.draw(new Line2D.Float(0, height / 2, 0, -height / 2)); // achse 2
	}

	// TODO: implementiere eine Achsenbeschriftung
	/**
	 * labels zeichnet Achsenbeschriftungen bei ganzen Zahlen.
	 */
	public void labels(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		for (int i = -width / 2; i < width / 2; i++) {

			String a = String.valueOf(-i / 80);
			if (i % 80 == 0) {
				g2d.drawString(a, i, -2);
			}
			if (i != 0 && i % 80 == 0) {
				g2d.drawString(a, 2, i);

			}

		}

	}

	// TODO: implementiere einen Funktionsplot.
	/**
	 * plot zeichnet die durch die Expression e angegebene Funktion in der
	 * angegebenen Farbe in g.
	 */
	public void plot(Graphics g, Expression e, Color c) {

		Graphics2D g1 = (Graphics2D) g;
		int[] xpoints = new int[width * 10];
		int[] ypoints = new int[width * 10];
		for (int i = -width / 2; i < width / 2; i = i + pixelratio) {
			int wert_1 = (int) Math.round(e.eval(i)) * pixelratio;
			xpoints[i + width / 2] = wert_1;
			ypoints[i + width / 2] = i;
			// g1.drawLine(i, wert_1, wert_2, i+pixelratio);
			// g1.drawLine(i+pixelratio, wert_2,i+3*pixelratio, wert_3);
		}
		g1.setColor(c);
		for (int n = 0; n < width / pixelratio; n++) {
			g1.drawLine(xpoints[n], ypoints[n], xpoints[n + 1], ypoints[n + 1])+1;
		}
	}
	//push

	/**
	 * paint-Methode wie in der Vorlesung
	 */
	public void paint(Graphics g) {
		coordinates(g);
		labels(g);
		// TODO: Hier weitere Beispiele einfügen
		// TODO: An diese Stelle sollst Du auch in den spÃ¤teren Aufgabenteilen jeweils
		// Funktionen in unterschiedlicher Syntax schreiben.
		plot(g, new HardcodedSin(), Color.RED);
	}
}
