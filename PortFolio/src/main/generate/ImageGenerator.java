package main.generate;

import main.monsterkurve.Monsterkurve;
import main.monsterkurve.drache.DrachenKurve;
import main.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageGenerator {
    public static final String TAG = "ImageGenerator";

    public static void main(String[] args) {
       // ScaledPerformanceResult scaledPerformanceResult = generateImages(new Schneeflocke(), "Schneeflocke", 3, until(7, 8, 1));//1, 3, 7);
        //ScaledPerformanceResult scaledPerformanceResult = generateImages(new Pfeilspitze(), "Pfeilspitze",6,  until(6, 8, 1));//1, 4, 9);
        ScaledPerformanceResult scaledPerformanceResult = generateImages(new DrachenKurve(), "DrachenKurve", 6, until(12, 14, 2));//1, 5, 14);
        System.out.println("scaledPerformanceResult DrachenKurve= " + scaledPerformanceResult);
    }

    private static int[] until(int start, int until, int d) {
        int num = (until - start + 1);
        int length = num % d == 0 ? num / d : num / d + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = start + i * d;
        }
        return result;
    }

    private static ScaledPerformanceResult generateImages(Monsterkurve monsterkurve, String name, int times, int... depths) {
        System.out.println("ImageGenerator.generateImages");
        ScaledPerformanceResult result = new ScaledPerformanceResult();
        System.out.println("fractal = " + monsterkurve + ", name = " + name + ", depths = " + Arrays.toString(depths));
        for (int depth : depths) {
            System.out.println("depth = " + depth);
            List<Long> durations = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                PerformanceResult performanceResult = monsterkurve.draw(depth);
                durations.add(performanceResult.getDurationMillis());
                System.out.println("performanceResult = " + performanceResult);
                monsterkurve.savePng(TAG + "_" + name + "_" + depth);
                monsterkurve.clear();
            }
            result.addSmallResult(new Pair<>(depth, durations));
        }
        return result;
    }
}
