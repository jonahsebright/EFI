package main.generate;

public class PerformanceResult {
    private final long durationMillis;
    private final int moveCount;

    public PerformanceResult(long durationMillis, int moveCount) {
        this.durationMillis = durationMillis;
        this.moveCount = moveCount;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public String toString() {
        return "PerformanceResult{" +
                "durationMillis=" + durationMillis +
                ", moveCount=" + moveCount +
                '}';
    }
}
