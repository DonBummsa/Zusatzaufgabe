/**
 * Expression stellt einen Ausdruck dar, der mit der eval()-Methode evaluiert/ausgewertet werden kann. Der Ausdruck
 * kann eine Variable x enthalten, die als Argument an eval übergeben wird.
 */
public class Expression {
    protected Expression() {
    }

    /**
     * eval wertet den Ausdruck aus. Dabei wird der übergebene Wert für die Variable x eingesetzt.
     *
     * @param x Der für x einzusetzende Wert. Der Parameter x muss nicht benutzt werden, falls der dargestellte
     *          Ausdruck kein x enthält.
     * @return Das Ergebnis des Ausdrucks mit dem ggf. eingesetzten x.
     */
    public double eval(double x) {
        return 0;
    }
}
