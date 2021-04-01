package concurrency;
/*
 * @lc app=leetcode.cn id=1195 lang=java
 *
 * [1195] 交替打印字符串
 */

import java.util.function.IntConsumer;

public class Problem1195 {
    static class FizzBuzz {
        private int n;

        private volatile int i = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (i <= n) {
                synchronized (this) {
                    if (i <= n && i % 3 == 0 && i % 5 != 0) {
                        printFizz.run();
                        i++;
                        notifyAll();
                    } else {
                        wait();
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (i <= n) {
                synchronized (this) {
                    if (i <= n && i % 5 == 0 && i % 3 != 0) {
                        printBuzz.run();
                        i++;
                        notifyAll();
                    } else {
                        wait();
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (i <= n) {
                synchronized (this) {
                    if (i <= n && i % 15 == 0) {
                        printFizzBuzz.run();
                        i++;
                        notifyAll();
                    } else {
                        wait();
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (i <= n) {
                synchronized (this) {
                    if (i <= n && i % 3 != 0 && i % 5 != 0) {
                        printNumber.accept(i);
                        i++;
                        notifyAll();
                    } else {
                        wait();
                    }
                }
            }
        }
    }
}


