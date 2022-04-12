package aufgabe1;
/**
 * HardcodedSin stellt die Funktion f(x) = sin(x) als Expression dar.
 */
public class HardcodedTan extends Expression {
    @Override
    public double eval(double x) {
        return Math.sin(x)/Math.cos(x);
    }
}
