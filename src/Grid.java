import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.applet.*;
public class Grid extends JFrame {
    public static int width = 1024;
    public static int height = 786;

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
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Line2D.Float(512, 786, 512, 0));	// achse 1 
        g2.draw(new Line2D.Float(0,383,1023,383)); // achse 2
        g2.setStroke(new BasicStroke(1));
    	for(int i = 0;i<1024; i++ ) {
    		
    		g.setColor(Color.LIGHT_GRAY);
    		if(i==512) {
    			i++;
    		}
    		if(i % 8 == 0) {
    			g.drawLine(8*i , 0 , 8*i , 1024 );
    			g.drawLine(0, 8*i , 1024 , 8*i );
    			
    		}
    		
    		
    	}
    	
    }

    // TODO: implementiere eine Achsenbeschriftung
    /**
     * labels zeichnet Achsenbeschriftungen bei ganzen Zahlen.
     */
    public void labels(Graphics g) {

    }

    // TODO: implementiere einen Funktionsplot.
    /**
     * plot zeichnet die durch die Expression e angegebene Funktion in der angegebenen Farbe in g.
     */
    public void plot(Graphics g, Expression e, Color c) {

    }

    /**
     * paint-Methode wie in der Vorlesung
     */
    public void paint(Graphics g) {
        coordinates(g);
        labels(g);
        // TODO: Hier weitere Beispiele einfügen
        // TODO: An diese Stelle sollst Du auch in den spÃ¤teren Aufgabenteilen jeweils Funktionen in unterschiedlicher Syntax schreiben.
        plot(g, new HardcodedSin(), Color.RED);
    }
}
