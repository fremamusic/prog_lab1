import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 19;

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i + 2;
        }

        float[] x = new float[n];
        Random rnd = new Random();
        for (int j = 0; j < n; j++) {
            x[j] = -4.0f + rnd.nextFloat() * 8.0f;
        }

        double[][] m = new double[n][n];
        int[] specialSet = {2, 5, 6, 9, 10, 11, 14, 17, 20};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double xv = x[j];
                m[i][j] = computeElement(b[i], xv, specialSet);
            }
        }

        // 4. Печать b
        System.out.println("Массив b:");
        for (int v : b) {
            System.out.print(v + " ");
        }
        System.out.println("\n");

        // Печать x
        System.out.println("Массив x:");
        for (float v : x) {
            System.out.printf("%.4f ", v);
        }
        System.out.println("\n");

        // Печать m с 4 знаками после запятой
        System.out.println("Матрица m:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%10.4f ", m[i][j]);
            }
            System.out.println();
        }
    }

    private static double computeElement(int bi, double x, int[] specialSet) {
        if (bi == 8) {
            double v = Math.pow(2 * x, 2);
            return Math.exp(Math.tan(v));
        }

        if (contains(specialSet, bi)) {
            double inner = 2 * Math.atan(Math.exp(-Math.abs(x)));
            return Math.pow(inner, 3);
        }

        double acosX = Math.acos(x); // NaN, если x вне [-1, 1]
        double innerExpArg = 2 * Math.PI - Math.pow(5 + acosX, 2);
        double innerExp = Math.exp(innerExpArg);
        double atanInner = Math.atan(1.0 / innerExp);
        double cosSq = Math.pow(Math.cos(atanInner), 2);
        double outerExp = Math.exp(cosSq);
        return Math.atan(1.0 / outerExp);
    }

    private static boolean contains(int[] arr, int val) {
        for (int v : arr) {
            if (v == val) return true;
        }
        return false;
    }
}
