import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ZeitRechnerTest {

    @Test
    public void remainingAre0IfSecondsPopped() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(7645));
        zeitRechner.popSeconds();
        assertEquals(0, zeitRechner.getRemaining().intValueExact());
    }

    @Test
    public void calculateRemainingSeconds() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(1234));
        assertEquals(1234, zeitRechner.popSeconds().intValueExact());
    }

    @Test
    public void calculateRemainingMinutesAndSeconds() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(125));
        assertEquals(2, zeitRechner.popMinutes().intValueExact());
        assertEquals(5, zeitRechner.popSeconds().intValueExact());
    }

    @Test
    public void calculateRemainingHours_MinutesAndSeconds() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(18 + 3 * 60 + 4 * 60 * 60));
        assertEquals(4, zeitRechner.popHours().intValueExact());
        assertEquals(3, zeitRechner.popMinutes().intValueExact());
        assertEquals(18, zeitRechner.popSeconds().intValueExact());
    }

    @Test
    public void ifAllPoppedRemainderIs0() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(8758275893278L));
        zeitRechner.popAll();
        assertEquals(0, zeitRechner.getRemaining().intValueExact());
    }

    @Test
    public void popAllTest() {
        ZeitRechner zeitRechner = new ZeitRechner(BigInteger.valueOf(
                18 + 3 * 60 //18min
                        + 4 * 60 * 60 //4h
                        + 17 * 60 * 60 * 24 //17d
                        + 8 * 60 * 60 * 24 * 30 //8m
                        + 7 * 60 * 60 * 24 * 30 * 12 //7years
        ));
        ArrayList<BigInteger> popped = zeitRechner.popAll();
        assertEquals(ZeitRechner.TIME.UNITS_DESCENDING_ORDER.length, popped.size());
        assertEquals(0, popped.get(0).intValueExact());
        assertEquals(0, popped.get(1).intValueExact());
        assertEquals(0, popped.get(2).intValueExact());
        assertEquals(7, popped.get(3).intValueExact());
        assertEquals(8, popped.get(4).intValueExact());
        assertEquals(17, popped.get(5).intValueExact());
        assertEquals(4, popped.get(6).intValueExact());
        assertEquals(3, popped.get(7).intValueExact());
        assertEquals(18, popped.get(8).intValueExact());
    }

}