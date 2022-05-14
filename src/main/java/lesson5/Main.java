package lesson5;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1:");
        System.out.println(pow(5, 6));
        System.out.println(pow(2, -3));
        int[] weights = new int[]{1, 4, 6, 8};
        int[] values = new int[]{2, 5, 1, 1};

        System.out.println("Задание 2:");
        System.out.println(backpackTask(weights, values, 4, 10));
    }

    private static double pow(double a, double b) {
        if (b == 0) {
            return 1;
        }
        if (b > 0) {
            return pow(a, b - 1) * a;
        }
        return pow(a, b + 1) / a;
    }

    public static int backpackTask(int[] weight, int[] value, int n, int W) {
        if (n <= 0) {
            return 0;
        } else if (weight[n - 1] > W) {
            return backpackTask(weight, value, n - 1, W);
        } else {
            return Math.max(backpackTask(weight, value, n - 1, W), value[n - 1] + backpackTask(weight, value, n - 1, W - weight[n - 1]));
        }
    }
}