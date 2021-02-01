package main;

public class BisAufgabe8 {
    public static void alpha() {
        System.out.println("Hallo!");
    }

    public static void beta() {
        alpha();
        alpha();
    }

    public static void main(String[] args) {
        beta();
        alpha();
    }

    public static void println() {
        System.out.println();
    }

    public static void dumpStack() {
        Thread.dumpStack();
    }

}
