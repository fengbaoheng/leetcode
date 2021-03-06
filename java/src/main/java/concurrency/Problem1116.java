package concurrency;

/*
 * [1116] 打印零与奇偶数
 */

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Problem1116 {
    static class ZeroEvenOdd {
        private int n;

        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore oddSemaphore = new Semaphore(1);
        private Semaphore evenSemaphore = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSemaphore.acquire();

                printNumber.accept(0);

                oddSemaphore.release();
                evenSemaphore.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire(2);

                printNumber.accept(i);

                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire(2);

                printNumber.accept(i);

                zeroSemaphore.release();
            }
        }
    }
}


