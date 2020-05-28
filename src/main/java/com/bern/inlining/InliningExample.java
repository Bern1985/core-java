package com.bern.inlining;

/**
 * vm args:
 * -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 */
public class InliningExample {
    public static final int NUMBERS_OF_ITERATIONS = 1500000;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 1; i < NUMBERS_OF_ITERATIONS; i++) {
            calculateSum(i);
        }
        System.out.println(System.currentTimeMillis() - time + " -- " + NUMBERS_OF_ITERATIONS);
    }

    private static long calculateSum(int n) {
        return new ConsecutiveNumbersSum(n).getTotalSum();
    }
}
