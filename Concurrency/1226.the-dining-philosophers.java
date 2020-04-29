import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1226 lang=java
 *
 * [1226] 哲学家进餐
 */

// @lc code=start
class DiningPhilosophers {

    Semaphore[] forks;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

        Semaphore leftFork = forks[philosopher];
        Semaphore rightFork = forks[(philosopher + 1) % 5];

        while (true) {
            if (leftFork.tryAcquire()) {
                if (rightFork.tryAcquire()) {
                    // 左右叉子同时到手，开吃
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();

                    // 释放左右叉子结束函数
                    rightFork.release();
                    leftFork.release();
                    return;
                }

                // 若没有同时获得右叉子则也释放左叉子
                leftFork.release();
            }

            // 本次没有成功吃到则让出CPU
            Thread.yield();
        }
    }
}
// @lc code=end
