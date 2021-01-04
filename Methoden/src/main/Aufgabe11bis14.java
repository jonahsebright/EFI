package main;

public class Aufgabe11bis14 {

    private double d1, d2, d3;

    public Aufgabe11bis14(double d1, double d2, double d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public double getD1() {
        return d1;
    }

    public double getD2() {
        return d2;
    }

    public double getD3() {
        return d3;
    }

    public static void main(String[] args) {
        Aufgabe11bis14 classWithDoubles = new Aufgabe11bis14(1.5, 2.5, 5.5);
        System.out.println("1.5 * 2.5 * 5.5 = " + multiply(
                classWithDoubles.getD1(),
                classWithDoubles.getD2(),
                classWithDoubles.getD3()
        )); //20.625
        classWithDoubles = new Aufgabe11bis14(1.2, 5, 0.125);
        System.out.println("1.5 * 2.5 * 5.5 = " + multiply(
                classWithDoubles.getD1(),
                classWithDoubles.getD2(),
                classWithDoubles.getD3()
        )); //0.75
    }

    public static double multiply(double d1, double d2, double d3) {
        return d1 * d2 * d3;
    }
}
