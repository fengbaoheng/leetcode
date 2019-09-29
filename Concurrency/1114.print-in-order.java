/*
 * @lc app=leetcode.cn id=1114 lang=java
 *
 * [1114] 按序打印
 */

class Foo {
    private volatile int step = 1;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        step = 2;
        notifyAll();

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (step != 2) {
            wait();
        }

        step = 3;
        notifyAll();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        while (step != 3) {
            wait();
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
