package aufgabe1;

import java.util.Random;

/**
 * HardcodedSin stellt die Funktion f(x) = sin(x) als Expression dar.
 */
public class Hardcodedirgendwas extends Expression {
    @Override
    public double eval(double x) {
    	
    	Random rand = new Random(); 
         
        double int_random = rand.nextDouble();
    	return int_random+x;
    }
}
