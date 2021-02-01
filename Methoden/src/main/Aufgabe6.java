package main;

public class Aufgabe6 {
    public static void main(String[] args) {
        beta();
        alpha();
    }

    public static void beta() {
        alpha();
        alpha();
    }

    public static void alpha() {
        System.out.println("Hallo!");
    }
}
