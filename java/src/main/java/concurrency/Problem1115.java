package concurrency;

import java.util.concurrent.Semaphore;

/*
 * [1115] 交替打印FooBar
 */
public class Problem1115 {
    class FooBar {
        private int n;
        private final Semaphore fooSemaphore = new Semaphore(1);
        private final Semaphore barSemaphore = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                barSemaphore.acquire();

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                fooSemaphore.release();
            }
        }
    }
}

