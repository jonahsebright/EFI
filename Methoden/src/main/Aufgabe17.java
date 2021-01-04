package main;

public class Aufgabe17 {
    public static void main(String[] args) {
        String verkettet = verketten("Hallo,", "Welt!");
        System.out.println("verkettet = " + verkettet);
    }

    public static String verketten(String s1, String s2){
        return s1 + s2;
    }
}
