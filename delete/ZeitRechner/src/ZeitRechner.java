import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeitRechner {
    public static final BigInteger SIXTY = BigInteger.valueOf(60);

    public static class TIME {
        public static final BigInteger SECONDS_IN_MINUTE = SIXTY;
        public static final BigInteger MINUTES_IN_HOUR = SIXTY;
        public static final BigInteger HOURS_IN_DAY = BigInteger.valueOf(24);
        public static final BigInteger DAYS_IN_MONTH = BigInteger.valueOf(30);
        public static final BigInteger MONTHS_IN_YEAR = BigInteger.valueOf(12);

        public static final BigInteger SECOND = BigInteger.ONE;
        public static final BigInteger MINUTE = SECOND.multiply(SECONDS_IN_MINUTE);
        public static final BigInteger HOUR = MINUTE.multiply(MINUTES_IN_HOUR);
        public static final BigInteger DAY = HOUR.multiply(HOURS_IN_DAY);
        public static final BigInteger MONTH = DAY.multiply(DAYS_IN_MONTH);
        public static final BigInteger YEAR = MONTH.multiply(MONTHS_IN_YEAR);
        public static final BigInteger YEAR_10 = YEAR.multiply(BigInteger.TEN);
        public static final BigInteger YEAR_100 = YEAR_10.multiply(BigInteger.TEN);
        public static final BigInteger YEAR_1000 = YEAR_100.multiply(BigInteger.TEN);

        public static final BigInteger[] UNITS_DESCENDING_ORDER = {
                YEAR_1000,
                YEAR_100,
                YEAR_10,
                YEAR,
                MONTH,
                DAY,
                HOUR,
                MINUTE,
                SECOND
        };
    }

    private BigInteger totSeconds;

    public ZeitRechner(BigInteger totSeconds) {
        this.totSeconds = totSeconds;
    }

    public void setTotSeconds(BigInteger totSeconds) {
        this.totSeconds = totSeconds;
    }

    public BigInteger popSeconds() {
        return popTimeUnit(TIME.SECOND);
    }

    public BigInteger popTimeUnit(BigInteger timeUnitInSeconds) {
        BigInteger[] divideAndRemainder = totSeconds.divideAndRemainder(timeUnitInSeconds);
        totSeconds = divideAndRemainder[1];
        return divideAndRemainder[0];
    }

    public BigInteger popMinutes() {
        return popTimeUnit(TIME.MINUTE);
    }

    public BigInteger popHours() {
        return popTimeUnit(TIME.HOUR);
    }

    public BigInteger getRemaining() {
        return totSeconds;
    }

    public ArrayList<BigInteger> popAll() {
        return popAll(TIME.UNITS_DESCENDING_ORDER);
    }

    public ArrayList<BigInteger> popAll(List<BigInteger> timeUnits) {
        ArrayList<BigInteger> popped = new ArrayList<>();
        for (BigInteger timeUnit : timeUnits) {
            popped.add(popTimeUnit(timeUnit));
        }
        return popped;
    }

    public ArrayList<BigInteger> popAll(BigInteger... timeUnits) {
        return popAll(Arrays.asList(timeUnits));
    }
}
