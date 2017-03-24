package projekt;

/**
 * Klasa zawierająca metody służące do wyznaczenia niejsca zerowego
 * @author Heniek
 */
public class Metoda {
    static int iter;
    static double epsilon=0.000001;
    static double x0,x1,x2;
    static int funkcja;
    
    /**
     * Metoda obliczająca miejsce zerowe metodą stycznych
     * @param funkcja   zmienna decydująca czy wybraliśmy funkcję wielomianową czy eksponencjalną
     * @return      miejsce zerowe funkcji
     */
    public static double stycznych(int funkcja){
        iter=0;
        if(funkcja==0){
            do{
                iter++;
                if(Wielomian.pochodna(Wielomian.wspol, Wielomian.stopien, x0)==0)
                    return x0;
                else{
                    x1=x0-Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, x0)/
                            Wielomian.pochodna(Wielomian.wspol, Wielomian.stopien, x0);
                    x0=x1;
                }
            }
            while(Math.abs(Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, x0))>epsilon);
        }
        else{
            do{
                iter++;
                if(Exp.pochodna(Exp.a, Exp.b, Exp.c, x0)==0)
                    return x0;
                else{
                    x1=x0-Exp.wartosc(Exp.a, Exp.b, Exp.c, x0)/Exp.pochodna(Exp.a, Exp.b, Exp.c, x0);
                    x0=x1;
                }
            }
            while(Math.abs(Exp.wartosc(Exp.a, Exp.b, Exp.c, x0))>epsilon);
        }
        return x0;
    }

    /**
     * Metoda obliczająca miejse zerowe metodą siecznych
     * @param funkcja zmienna decydująca czy wybraliśmy funkcję wielomianową czy eksponencjalną
     * @return miejsce zerowe funkcji
     */
    public static double siecznych(int funkcja){
        iter=0;
        if(funkcja==0){
            do{
                iter++;
                x2=x1-Wielomian.wartosc(Wielomian.wspol,Wielomian.stopien,x1)*(x1-x0)/
                        (Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, x1)-
                        Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, x0));
                x0=x1;
                x1=x2;
            }
            while(Math.abs(Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, x2))>epsilon);
        }
        else{
            do{
                iter++;
                x2=x1-Exp.wartosc(Exp.a, Exp.b, Exp.c, x1)*(x1-x0)/
                        (Exp.wartosc(Exp.a, Exp.b, Exp.c, x1)-Exp.wartosc(Exp.a, Exp.b, Exp.c, x0));
                x0=x1;
                x1=x2;
            }
            while(Math.abs(Exp.wartosc(Exp.a, Exp.b, Exp.c, x1))>epsilon);
        }
        return x2;
    }

    /**
     * Metoda pobierająca przybliżenia miejsca zerowego
     */
    public static void pobierzPunkty(){
        String[] zakres=new String[2];
        zakres=(Menu.ZakresM.getText()).split(";");
        int rozmiar=zakres.length;
        x0=Double.parseDouble(zakres[0]);
        if(rozmiar==2)
        x1=Double.parseDouble(zakres[1]);
    }

    /**
     * Metoda zwracająca liczbę iteracji po której otrzynaliśmy wynik z żądaną dokładnością
     * @return liczba iteracji
     */
    public static int liczbaIteracji(){
        return iter;
    }
}
