package main;

public class Aufgabe4 {

    //Loesung: gibt

    // "....................." für immer bis der Computer crashed

    // aus.

    public static void main(String[] args) {
        alpha();
    }

    public static void alpha() {
        System.out.print(".");
        alpha();
    }

}
