package com.sebright;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MitternachtsFormulaTest {

    @Test
    public void calculatesCorrectDeterminant() {
        MitternachtsFormula mitternachtsFormula = new MitternachtsFormula(4, 6, 3);
        //36 - 4 * 4 * 3 = -12
        assertEquals(-12, mitternachtsFormula.getDeterminant().doubleValue());
    }

    @Test
    public void calculatesCorrectSolutions() {
        MitternachtsFormula mitternachtsFormula = new MitternachtsFormula(1, 6, 5);
        assertEquals(16, mitternachtsFormula.getDeterminant().doubleValue());

        //D = 36 - 20 = 16
        //-6 +- sqrt(16) / 2 -> x1 = -1, x2 = -5
        BigDecimal[] solutions = mitternachtsFormula.solve();
        assertEquals(-1, solutions[0].doubleValue());
        assertEquals(-5, solutions[1].doubleValue());
    }

    @Test
    public void throws_A_isZeroException_ifA_is_0() {
        assertThrows(MitternachtsFormula.A_isZeroException.class, () -> {
            new MitternachtsFormula(0, 1, 2);
        });
    }

}