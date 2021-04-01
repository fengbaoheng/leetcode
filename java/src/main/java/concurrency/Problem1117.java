package concurrency;

import java.util.concurrent.Semaphore;

/*
 * [1117] H2O 生成
 */
public class Problem1117 {
    static class H2O {

        private final Semaphore hydrogenSemaphore = new Semaphore(0);
        private final Semaphore oxygenSemaphore = new Semaphore(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hydrogenSemaphore.acquire();

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();

            oxygenSemaphore.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oxygenSemaphore.acquire(2);

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();

            hydrogenSemaphore.release(2);
        }
    }
}

