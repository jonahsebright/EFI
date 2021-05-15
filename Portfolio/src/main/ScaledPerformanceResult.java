package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ScaledPerformanceResult {
    private List<Pair<Integer, List<Long>>> depthsAndDurations = new ArrayList<>();

    public ScaledPerformanceResult() {
    }

    public void addSmallResult(Pair<Integer, List<Long>> depthWithDurations) {
        depthsAndDurations.add(depthWithDurations);
    }

    public ScaledPerformanceResult(List<Pair<Integer, List<Long>>> depthsAndDurations) {
        this.depthsAndDurations = depthsAndDurations;
    }

    public List<Pair<Integer, List<Long>>> getDepthsAndDurations() {
        return depthsAndDurations;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ScaledPerformanceResult{");
        for (Pair<Integer, List<Long>> depthsAndDuration : depthsAndDurations) {
            List<Long> durations = depthsAndDuration.getU();
            long averageDuration = durations.stream()
                    .reduce(0L, Long::sum) / durations.size();
            result.append("\ndepth ").append(depthsAndDuration.getT())
                    .append(": avg. duration for ")
                    .append(durations.size())
                    .append(" measurements = ")
                    .append(averageDuration);
        }
        result.append("\n }");
        return result.toString();
    }
}
