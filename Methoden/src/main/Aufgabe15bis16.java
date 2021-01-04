package main;

public class Aufgabe15bis16 {
    public static void main(String[] args) {
        System.out.println("5.3 + 1.22 = " + add(5.3, 1.22)); //6.52
        System.out.println("5.3 - 1.22 = " + subtract(5.3, 1.22)); //4.08
        System.out.println("3.2 * 7.1 = " + multiply(3.2, 7.1)); //22.72
        System.out.println("8.4 / 2.1 = " + divide(8.4, 2.1)); //4
        System.out.println("- (-7) = " + switchSignature(-7)); //7

        int zwischenResultat = (int) divide(175, subtract(add(multiply(5, 10), 30), 45));
        System.out.println("- (175 / (5 * 10 + 30 - 45) = " + switchSignature(zwischenResultat)); //-5
    }

    public static double add(double d1, double d2) {
        return d1 + d2;
    }

    public static double subtract(double d1, double d2) {
        return d1 - d2;
    }

    public static double multiply(double d1, double d2) {
        return d1 * d2;
    }

    public static double divide(double d1, double d2) {
        return d1 / d2;
    }

    public static double switchSignature(int val) {
        return -val;
    }
}
