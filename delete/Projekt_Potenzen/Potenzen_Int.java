import javax.swing.JOptionPane;

/**
 * Write a description of class Potenzen here.
 * 
 * @author (Jonah Sebright)
 * @version (2.0, 14.11.2019)
 */
public class Potenzen_Int
{
    public static void main(int B,int N)

    {
     
        int n = 0;

        /**
         * Check übe groesse der Basis, wenn Basis kleier als 2 ist Prgramm
         * abbrechen und Nutzer informieren
         */   

        if( B < 2 )
        {
            JOptionPane.showMessageDialog(null,
                "The base is smaller than 2",
                "ERORR",
                JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        /**
         * Check über groesse des Exponenten, wenn kleiner als 2 oder
         * grösser als 40 Programm abbrechen und Nutzer informieren
         */

        if(N > 40 || N < 2)
        {
            JOptionPane.showMessageDialog(null,
                "The exponent is smaller than 1 or larger than 40",    
                "ERORR",
                JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // Ausgabe der eingegebenen Zahlen
        JOptionPane.showMessageDialog(null,
            "Die eingegebenen Zahlen sind :" +
            "\nB = " + B + ", N = " + N,    
            "ERORR",
            JOptionPane.INFORMATION_MESSAGE);

        /**
         * Brechnung 
         */
        System.out.format("Basis = " + B + "\t" + "Exponent = " + N);

        while (N+1 > n) //ueberpruefen ob genügen mal multipliziert
        {
            System.out.format("\n%d \t %-20d", n, (int)Math.pow(B, n));
            n++;
         }
        System.exit(0);
    }
}

