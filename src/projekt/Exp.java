package projekt;

/**
 * Klasa która obsługuje funkcję eksponencjalną
 * @author Heniek
 */
public class Exp {
    static double a,b,c;
    Exp exp=new Exp();

    /**
     * Metoda licząca wartość funkcji eksponencjalnej w danym punkcie.
     * Postać funkcji: a*e^(b*x)*sin(c*x)
     * @param a współczynnik a
     * @param b współczynnik b
     * @param c współczynnik c
     * @param x punkt dla któego liczona jest wartość funkcji
     * @return wartość funkcji w punkcie "x"
     */
    public static double wartosc(double a, double b, double c, double x){
        return a*Math.exp(b*x)*Math.sin(c*x);
    }

    /**
     * Metoda licząca wartość pochodnej funkcji eksponencjalnej w danym punkcie.
     * Postać funkcji: a*e^(b*x)*sin(c*x)
     * @param a współczynnik a
     * @param b współczynnik b
     * @param c współczynnik c
     * @param x punkt dla któego liczona jest wartość pochodnej
     * @return wartość pochodneji w punkcie "x"
     */
    public static double pochodna(double a, double b, double c, double x){
        return a*Math.exp(b*x)*(b*Math.sin(c*x)+c*Math.cos(c*x));
    }
    
    /**
     * Metoda pobierająca wpisane dane
     */
    public static void pobierzWartości(){
        String[] tab=new String[3];
        tab=(Menu.ExpABC.getText()).split(";");
        a=Double.parseDouble(tab[0]);
        b=Double.parseDouble(tab[1]);
        c=Double.parseDouble(tab[2]);
    }
}
