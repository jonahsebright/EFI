package main;

/**
 * Jonah Sebright 20201207
 *
 * @version 18.12.2020
 */
public class BitweiseOperatoren {

    public static void main(String[] args) {

        task1();
        task2();
    }

    private static void task1() {
        int[] numbers = new int[]{1130, 16, -64, 128, -5000, 30000};
        for (int numberInt : numbers) {
            displayInBinary8_16_32(numberInt);
            System.out.println(); //for esthetics
        }
    }

    private static void displayInBinary8_16_32(int numberInt) {
        String num = Integer.toBinaryString(numberInt);
        String binaryLength8 = getStrBinaryLength_num_with0(num, 8);
        String binaryLength16 = getStrBinaryLength_num_with0(num, 16);
        String binaryLength32 = getStrBinaryLength_num_with0(num, 32);

        System.out.format("a = %5d_10 = %s_2(8 bit) = %s_2(16 bit) = %s_2(32 bit)", numberInt,
                binaryLength8, binaryLength16, binaryLength32);
    }

    private static String getStrBinaryLength_num_with0(String num, int binaryLength) {
        String strBinaryLength_without0 = String.format("%" + binaryLength + "s", num);
        return strBinaryLength_without0.replace(" ", "0");
    }

    private static void task2() {
        System.out.println("\n2)");
        doOperationAndPrintIn32BitLength("a)", "16 + 200", 16 + 200);
        doOperationAndPrintIn32BitLength("b)", "16 - 200", 16 - 200);
        doOperationAndPrintIn32BitLength("c)", "130 >> 3", 130 >> 3);
        doOperationAndPrintIn32BitLength("d)", "130 << 7", 130 << 7);
        doOperationAndPrintIn32BitLength("e)", "250 >>> 3", 250 >>> 3);
        doOperationAndPrintIn32BitLength("f)", "−3000 << 4",-3000 << 4);
        doOperationAndPrintIn32BitLength("g)", "˜450", ~450);
        doOperationAndPrintIn32BitLength("h)", "80 & 190", 80 & 190);
        doOperationAndPrintIn32BitLength("i)", "100 |(−390)", 100 |(-390));
        doOperationAndPrintIn32BitLength("j)", "(−1350) ∧ (−4990)", (-1350) ^ (-4990));
        doOperationAndPrintIn32BitLength("k)", "(3000 & ~(10 << 4))|(1 << 4)", (3000 & ~(10 << 4))|(1 << 4));
        doOperationAndPrintIn32BitLength("l)", "(-3000&~(50>>2))|(-10<<4)", (-3000&~(50>>2))|(-10<<4));
        doOperationAndPrintIn32BitLength("m)", "(~300&~(20<<4))|(100>>4)", (~300&~(20<<4))|(100>>4));
    }

    private static void doOperationAndPrintIn32BitLength(String subTaskName, String operationStr, int operation) {
        String num = Integer.toBinaryString(operation);
        System.out.format("\n" + subTaskName + " %s = %d_10 = %s_2(32 bit)",
                operationStr, operation, getStrBinaryLength_num_with0(num, 32));
    }
}
