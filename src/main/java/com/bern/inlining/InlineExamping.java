package com.bern.inlining;

import java.util.Random;

public class InlineExamping {
    private static final int COUNT = 2000000000;

    public static void main(String[] args) {
        System.out.println(arrayCompute() + " " + virtualCompute() + " " + interfaceCompute());
    }

    static long arrayCompute() {
        InliningInterface[] array = new InliningInterface[4];

        array[0] = (x,y) -> x + y;
        array[1] = (x,y) -> x + x + y;
        array[2] = (x,y) -> x + y + y;
        array[3] = (x,y) -> x - y;

        long start = System.currentTimeMillis();
        Random r = new Random(start);

        int x = r.nextInt(10);
        int y = r.nextInt(10);

        for (int i = 0; i < COUNT; i++) {
            for (InliningInterface item : array) {
                item.compute(x, y);
            }
        }

        return System.currentTimeMillis() - start;
    }

    static long virtualCompute() {
        InliningInterface A = (x,y) -> x + y;
        InliningInterface B = (x,y) -> x + x + y;
        InliningInterface C = (x,y) -> x + y + y;
        InliningInterface D = (x,y) -> x - y;

        long start = System.currentTimeMillis();
        Random r = new Random(start);

        int x = r.nextInt(10);
        int y = r.nextInt(10);

        for (int i = 0; i < COUNT; i++) {
            A.compute(x, y);
            B.compute(x, y);
            C.compute(x, y);
            D.compute(x, y);
        }

        return System.currentTimeMillis() - start;
    }

    static long interfaceCompute() {
        InliningInterface[] array = new InliningInterface[4];

        array[0] = (x,y) -> x + y;
        array[1] = (x,y) -> x + x + y;
        array[2] = (x,y) -> x + y + y;
        array[3] = (x,y) -> x - y;

        long start = System.currentTimeMillis();
        Random r = new Random(start);

        int x = r.nextInt(10);
        int y = r.nextInt(10);

        for (int i = 0; i < COUNT; i++) {
            array[0].compute(x, y);
            array[1].compute(x, y);
            array[2].compute(x, y);
            array[3].compute(x, y);
        }

        return System.currentTimeMillis() - start;
    }

    interface InliningInterface {
        int compute(int x, int y);
    }
}


