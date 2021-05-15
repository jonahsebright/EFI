package main;

import main.fractal.Fractal;
import main.fractal.PerformanceResult;
import main.fractal.drache.DrachenKurve;
import main.fractal.pfeilspitze.Pfeilspitze;
import main.fractal.schneeflocke.Schneeflocke;

import java.util.Arrays;

public class ImageGenerator {
    public static final String TAG = "ImageGenerator";

    public static void main(String[] args) {
        //generateImages(new Schneeflocke(), "Schneeflocke", until(0, 8, 1));//1, 3, 7);
        generateImages(new Pfeilspitze(), "Pfeilspitze", until(0, 8, 1));//1, 4, 9);
        //generateImages(new DrachenKurve(), "DrachenKurve", until(0, 14, 2));//1, 5, 14);
    }

    private static int[] until(int start, int until, int d) {
        int length = (until - start + 1)/d+1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = start + i * d;
        }
        return result;
    }

    private static void generateImages(Fractal fractal, String name, int... depths) {
        System.out.println("ImageGenerator.generateImages");
        System.out.println("fractal = " + fractal + ", name = " + name + ", depths = " + Arrays.toString(depths));
        for (int depth : depths) {
            System.out.println("depth = " + depth);
            PerformanceResult performanceResult = fractal.draw(depth);
            System.out.println("performanceResult = " + performanceResult);
            fractal.savePng(TAG + "_" + name + "_" + depth);
            fractal.clear();
        }
    }
}
