package algorithms;

import java.util.Arrays;

/**
 * 1833.雪糕的最大数量
 */
public class Problem1833 {

    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);

            int count = 0;
            for (int cost : costs) {
                if (coins < cost) {
                    break;
                }

                coins -= cost;
                count++;
            }

            return count;
        }
    }


}