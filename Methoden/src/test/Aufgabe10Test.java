package test;

import main.Aufgabe10;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Aufgabe10Test {

    @org.junit.jupiter.api.Test
    void wuerfel() {
        ArrayList<Double> gewuerfelt = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gewuerfelt.add(Aufgabe10.wuerfel());
        }
        for (Double wuerfel : gewuerfelt) {
            assertBetween1and7(wuerfel);
        }
    }

    private void assertBetween1and7(double wuerfel) {
        assertTrue(wuerfel >= 1d && wuerfel<7);
    }
}