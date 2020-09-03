package com.sebright;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;

public class MitternachtsFormula {

    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;

    public MitternachtsFormula(double a, double b, double c) {
        if (a == 0) throw new MitternachtsFormula.A_isZeroException();
        this.a = valueOf(a);
        this.b = valueOf(b);
        this.c = valueOf(c);
    }

    public BigDecimal getDeterminant() {
        //B^2 - 4ac
        return b.pow(2).subtract((valueOf(4).multiply(a).multiply(c)));
    }

    public BigDecimal[] solve() {
        BigDecimal[] solutions;
        BigDecimal D = getDeterminant();
        if (BigDecimalUtil.isNegative(D)) {
            //no solutions
            solutions = new BigDecimal[0];
        } else {
            BigDecimal firstSol = calculateSolution(D, false);
            if (BigDecimalUtil.isZero(D)) {
                solutions = new BigDecimal[1];
                solutions[0] = firstSol;
            } else {
                solutions = new BigDecimal[2];
                solutions[0] = firstSol;
                solutions[1] = calculateSolution(D, true);
            }
        }
        return solutions;
    }

    private BigDecimal calculateSolution(BigDecimal D, boolean negativeDeterminant) {
        //(-b +- sqrt(D)) / (2a)
        BigDecimal sqrt_D = D.sqrt(MathContext.DECIMAL128);
        if (negativeDeterminant) sqrt_D = sqrt_D.negate();
        return b.negate().add(sqrt_D).divide((valueOf(2).multiply(a)), RoundingMode.HALF_UP);
    }

    public static class A_isZeroException extends RuntimeException {
    }

    public String formula() {
        return "f(x) = " +
                a.stripTrailingZeros() + "x² + " +
                b.stripTrailingZeros() + "x + " +
                c.stripTrailingZeros();

    }

    public String binomial(BigDecimal[] solutions) {
        BigDecimal sol1 = solutions[0];
        BigDecimal sol2;
        if (solutions.length >= 2) sol2 = solutions[1];
        else sol2 = sol1;
        String aInfrontOfBraces = "";
        if(!BigDecimalUtil.isEqualValue(a, BigDecimal.valueOf(1)))
            aInfrontOfBraces += a.stripTrailingZeros();
        return aInfrontOfBraces + inBraces(sol1) + inBraces(sol2);
    }

    public String inBraces(BigDecimal sol) {
        String inBraces = "(x ";
        if (BigDecimalUtil.isPositive(sol)) inBraces += sol.negate().stripTrailingZeros();
        else inBraces += "+ " + sol.negate().stripTrailingZeros();
        inBraces += ")";
        return inBraces;
    }
}
