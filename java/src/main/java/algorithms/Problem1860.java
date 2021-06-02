package algorithms;

/**
 * 1860.增长的内存泄露
 */
public class Problem1860 {

    class Solution {
        public int[] memLeak(int memory1, int memory2) {
            // 模拟
            int crashTime = 0;
            while (memory1 >= crashTime || memory2 >= crashTime) {
                if (memory1 >= memory2) {
                    memory1 -= crashTime;
                } else {
                    memory2 -= crashTime;
                }

                crashTime++;
            }

            return new int[]{crashTime, memory1, memory2};
        }
    }

}