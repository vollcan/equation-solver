package projekt;

import java.util.ArrayList;
/**
 * Klasa któa obsługuje funkcję wielomianową
 * @author Henryk Książek
 */

public class Wielomian {
    static int stopien;
    static ArrayList<Double> wspol=new ArrayList<Double>();

    /**
     * Metoda licząca wartość funkcji wielomianowej w danym punkcie
     * @param ar lista zawierająca współczynniki wielomianu
     * @param b stopień wielomianu
     * @param x punkt dla którego liczona jest wartość funkcji
     * @return wartość funkcji w punkcie "x"
     */
    public static double wartosc(ArrayList<Double> ar, int b, double x){
        double s=0;
        for(int i=0;i<=b;i++){
            s+=ar.get(i)*Math.pow(x, b-i);
        }
        return s;
    }

    /**
     * Metoda licząca wartość pochodnej funkcji wielomianowej w danym punkcie
     * @param ar lista zawierająca współczynniki wielomianu
     * @param b stopień wielomianu
     * @param x punkt dla którego liczona jest wartość pochodnej
     * @return wartość pochodnej w punkcie "x"
     */
    public static double pochodna(ArrayList<Double> ar, int b, double x){
        ArrayList<Double> wsp=new ArrayList<Double>();
        for(int i=0;i<b;i++){
            wsp.add(ar.get(i)*(b-i));
        }
        return wartosc(wsp,b-1,x);
    }
    
    /**
     * Metoda pobierająca wpisane dane
     */
    public static void pobierzWartosci(){
        stopien=Integer.parseInt(Menu.StopienText.getText());
        String[] tab=new String[Math.abs(stopien)+1]; 
        tab=(Menu.WspolText.getText()).split(";");
        for(int i=0;i<=Math.abs(stopien);i++)
            wspol.add(Double.parseDouble(tab[i]));
    }
}
