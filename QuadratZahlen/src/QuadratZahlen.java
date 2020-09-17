import flanagan.io.Db;

import java.math.BigInteger;

public class QuadratZahlen {

    private static BigInteger a;

    private static boolean fortSetzen = true;

    public static void main(String[] args) {
        while (fortSetzen) {
            a = Db.readBigInteger("Geben sie eine ganze Zahl ein um zu überprüfen ob die Aussage," +
                    "\ndass für jegliche ganze Zahl folgendes stimmt:\na^2 (mod 4) = 1 oder a^2 (mod 4) = 0");
            BigInteger[] sol = calculate();
            showResult(sol);

            BigInteger aSqrt = Db.readBigInteger("Geben sie eine ganze Quadratzahl ein,\n" +
                            "um sicher zustellen, dass sie nicht definitiv keine Quadratzahl ist");
            BigInteger[] sol2 = calculate(aSqrt);
            showResultQuadratInput(sol2);

            fortSetzen = Db.yesNo("Möchten Sie das Programm fortsetzen?");
        }
        System.exit(0);
    }

    private static void showResultQuadratInput(BigInteger[] sol) {
        int rest = sol[1].intValueExact();
        boolean isSqrNumber = rest == 0 || rest == 1;
        String message = "Rest war " + rest;
        if (isSqrNumber) {
            message = message + ", es war vielleicht eine Quadratzahl";
        } else {
            message = message + ", es war keine Quadratzahl!";
        }
        Db.show("a^2 = " + sol[0] + ", a^2 (mod 4) = " + rest + "\n" + message);
    }

    private static void showResult(BigInteger[] sol) {
        Db.show("a = " + a + ", a^2 = " + sol[0] + ", a^2 (mod 4) = " + sol[1]
                + ". Die Aussage stimmt!");
    }

    public static void setA(BigInteger a) {
        QuadratZahlen.a = a;
    }

    public static BigInteger[] calculate() {
        return calculate(a.multiply(a));
    }

    public static BigInteger[] calculate(BigInteger aSqr) {
        BigInteger rest = aSqr.mod(BigInteger.valueOf(4));
        return new BigInteger[]{
                aSqr, rest
        };
    }
}