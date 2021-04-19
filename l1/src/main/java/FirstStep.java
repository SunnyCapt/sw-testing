public class FirstStep {
    private static final double epsilon = 0.000000001;

    public static void main(String[] args) {
        System.out.println(FirstStep.cos(-1 * Math.PI));
    }

    public static double cos(double x) {
        if (x < -1 * Math.PI || x > Math.PI)
            return Double.NaN;

        int k = 1;
        double y = 1, t = 1;

        while (Math.abs(t) > FirstStep.epsilon) {
            t *= ((-1 * x * x / 2) / k) / (2 * k - 1);
            y += t;
            k = k + 1;
        }

        return y;
    }
}

