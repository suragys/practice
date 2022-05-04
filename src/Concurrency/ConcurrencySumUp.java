package Concurrency;

public class ConcurrencySumUp {
    static long MAX_NUM = Integer.MAX_VALUE;

    public static void main(String[] args) {
        long startRange;
        long endRange;
        long counter = 0;

        System.out.println();
        oneThread();
        twoThreads();
    }

    private static void twoThreads() {
        final long[] count = new long[2];
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
          count[0] =  sumUp(0, MAX_NUM/2);
        });
        Thread t2 = new Thread(() -> {
            count[1] =  sumUp(MAX_NUM/2 + 1, MAX_NUM);
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + (count[0] + count[1]) + " took " + (end - start));
    }

    private static void oneThread() {
        long start = System.currentTimeMillis();
        long count = sumUp(0, MAX_NUM);
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + count + " took " + (end - start));
    }

    private static long sumUp(long start, long  end) {
        long i = start;
        long count = 0;
        while(i <= end) {
            count += i++;
        }
        return count;
    }


}
