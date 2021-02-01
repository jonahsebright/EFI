package test;

import org.junit.jupiter.api.Test;

public class Aufg1 {
    @Test
    public void a() throws Exception {
        byte a = 90, b = 40, c = -100, d = -30;
        byte ab = (byte) (a + b);
        byte cd = (byte) (c + d);
        System.out.println("ab = " + ab + ", cd = " + cd);
    }

    @Test
    public void b() throws Exception {
        int x = 1357;
        System.out.println("x = " + x);
        int y = x >> 2;
        System.out.println("y = " + y);
        x = -1357;
        System.out.println("x = " + x);
        y = x >> 3;
        System.out.println("y = " + y);
    }


    @Test
    public void aufg2() throws Exception {
        System.out.println("100 << 1 = " + (100 << 1));
        System.out.println("100 << 7 = " + (100 << 7));
    }

    @Test
    public void carrierTest() throws Exception {
        byte byte1 = (byte) 01000000; //-128
        byte byte2 = (byte) 01000000; //-128
        byte newByte = (byte) (byte1 + byte2);
        System.out.println("newByte = " + newByte);
        System.out.println((byte) (byte1 + byte2));
    }
}
