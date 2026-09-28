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

        for (int i = 0; i < n; i++) {
            x[i] = -4.0f + rnd.nextFloat() * 8.0f;
        }

        int[] specialSet = {2, 5, 6, 9, 10, 11, 14, 17, 20};

        double[][] m = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = calculateElement(b[i], x[j], specialSet);
            }
        }

        System.out.println("Массив b:");
        for (int value : b) {
            System.out.print(value + " ");
        }

        System.out.println("\n");

        System.out.println("Массив x:");
        for (float value : x) {
            System.out.printf("%.4f ", value);
        }

        System.out.println("\n");

        printMatrix(m);
    }
    
    private static double calculateElement(int bi, double x, int[] specialSet) {

        if (bi == 8) {
            double value = Math.pow(2 * x, 2);
            return Math.exp(Math.tan(value));
        }

        if (contains(specialSet, bi)) {
            double inner = 2 * Math.atan(Math.exp(-Math.abs(x)));
            return Math.pow(inner, 3);
        }

        double acosX = Math.acos(x);
        double innerExpArg = 2 * Math.PI - Math.pow(5 + acosX, 2);
        double innerExp = Math.exp(innerExpArg);
        double atanInner = Math.atan(1.0 / innerExp);
        double cosSq = Math.pow(Math.cos(atanInner), 2);
        double outerExp = Math.exp(cosSq);

        return Math.atan(1.0 / outerExp);
    }
    
    private static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }
    
    private static void printMatrix(double[][] matrix) {
        System.out.println("Матрица m:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%10.4f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
