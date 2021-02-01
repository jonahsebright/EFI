package main;

public class Aufgabe2 {

    //Loesung: gibt

    // "beta"
    // "beta"
    // "beta"

    // aus.

    public static void alpha() {
        System.out.println("alpha");
    }

    public static void beta() {
        alpha();
        alpha();
    }

    public static void main(String[] args) {
        beta();
        alpha();
    }

}
