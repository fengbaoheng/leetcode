/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
import java.util.*;

class Solution {

    private List<Integer> numbers;

    public int nthSuperUglyNumber(int n, int[] primes) {
        numbers = new ArrayList<>(n);
        numbers.add(1);

        PriorityQueue<Ugly> queue = new PriorityQueue<>(primes.length);
        for (int prime : primes) {
            queue.add(new Ugly(prime));
        }

        while (numbers.size() < n) {
            int value = queue.peek().value;
            numbers.add(value);

            while (queue.peek().value == value) {
                Ugly peek = queue.poll();
                peek.update();
                queue.offer(peek);
            }
        }

        return numbers.get(n - 1);
    }


    private class Ugly implements Comparable<Ugly> {
        final int prime;
        int index;
        int value;

        public Ugly(int prime) {
            this.prime = prime;
            this.value = prime;
        }

        private void update() {
            index++;
            value = prime * numbers.get(index);
        }

        @Override
        public int compareTo(Ugly o) {
            return this.value - o.value;
        }
    }
}
// @lc code=end

