package aufgabe1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.applet.*;

public class Grid extends JFrame {
	public static int width = 1024;
	public static int height = 786;
	public static int largetick = 80; // entspricht 1
	public static int smalltick = 16; // entspricht 0,2

	/**
	 * Konstruktor aus der ‹bung
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

	// TODO: implementiere ein Koordinatenkreuz
	/**
	 * coordinates zeichnet ein Koordinatenkreuz.
	 */
	public void coordinates(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE); // weiﬂer hintergrund
		g2.fillRect(0, 0, width, height);
		g2.translate(width / 2, height / 2); // koordinaten auf den mittelpunkt verschieben

		g2.setStroke(new BasicStroke(1));
		Color lighterGray = new Color(211, 211, 211); // Color white.grey
		for (int i = -width / 2; i < width / 2; i++) {

			if (i % smalltick == 0) {

				g2.setColor(lighterGray);
				g2.drawLine(i, -width, i, width);
				g2.drawLine(-height, i, height, i);

			}

			g2.setColor(Color.LIGHT_GRAY);
			if (i % largetick == 0) {
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

		g2d.setColor(Color.BLACK);
		for (int i = -width / 2; i < width / 2; i++) {

			String a = String.valueOf(-i / largetick);

			FontMetrics babada = g2d.getFontMetrics();
			Rectangle2D rec2d = babada.getStringBounds(a, g2d);

			if (i % largetick == 0 && i != 0) {

				g2d.setColor(Color.WHITE);
				g2d.fillRect(-i, -6 - (int) rec2d.getHeight(), (int) rec2d.getWidth(), (int) rec2d.getHeight());
				g2d.setColor(Color.BLACK);
				g2d.drawString(a, -i, -6);
			}
			if (i != 0 && i % largetick == 0) {
				g2d.setColor(Color.WHITE);
				g2d.fillRect(6, i - (int) rec2d.getHeight(), (int) rec2d.getWidth(), (int) rec2d.getHeight());
				g2d.setColor(Color.BLACK);
				g2d.drawString(a, 6, i);

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
		int[] xpoints = new int[width];
		int[] ypoints = new int[width];

		for (int i = -width / 2; i < width / 2; i++) {
			if (Double.isNaN(e.eval((double) i))) {
				continue;
			}
			if (Double.isInfinite(-e.eval((double) i))) {
				continue;
			}
//			if ((double) Math.round(e.eval((double) i / largetick) * largetick)>6000){
//				continue;
//			}
//			if ((int) Math.round(e.eval((double) i / largetick) * largetick) > 0
//					&& (int) Math.round(e.eval((double) i + 1 / largetick) * largetick) < 0) {
//
//				continue;
//
//			}

			int wert_1 = (int) Math.round(e.eval((double) i / largetick) * largetick); // x werte der funktion in f

			ypoints[i + width / 2] = -wert_1;
			xpoints[i + width / 2] = i;

		}
		g1.setColor(c);

		for (int n = 0; n < width - 1; n++) {

			System.out.println(ypoints[n]); // debug
			g1.drawLine(xpoints[n], ypoints[n], xpoints[n + 1], ypoints[n + 1]); // der malt linien

		}

	}

	/**
	 * paint-Methode wie in der Vorlesung
	 */
	public void paint(Graphics g) {
		coordinates(g);
//		plot(g, new HardcodedSin(), Color.RED);
//		plot(g, new HardcodedTan(), Color.GREEN);
	//	plot(g, new Hardcodedirgendwas(), Color.BLUE);
		plot(g, new Hardcodedirgendwas2(), Color.MAGENTA);
		labels(g);
		// TODO: Hier weitere Beispiele einf¸gen
		// TODO: An diese Stelle sollst Du auch in den sp√§teren Aufgabenteilen jeweils
		// Funktionen in unterschiedlicher Syntax schreiben.

	}
}
