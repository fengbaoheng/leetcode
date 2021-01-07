package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711.大餐计数
 */
class CountGoodMeals {
    private static final int MOD = 1_000_000_000 + 7;

    private static final int MAX_POWER = 22;
    private static final int[] POWER = new int[MAX_POWER];

    // 计算所有2的幂
    static {
        for (int i = 0; i < MAX_POWER; i++) {
            POWER[i] = 1 << i;
        }
    }

    public int countPairs(int[] deliciousness) {
        int goodCount = 0;
        Map<Integer, Integer> deliciousCount = new HashMap<>(deliciousness.length);

        for (int delicious : deliciousness) {
            // 依次遍历能够组成2的幂的互补delicious
            for (int power : POWER) {
                int otherDelicious = power - delicious;
                int otherCount = deliciousCount.getOrDefault(otherDelicious, 0);
                goodCount += (otherCount) % MOD;
                goodCount %= MOD;
            }

            deliciousCount.merge(delicious, 1, Integer::sum);
        }

        return goodCount;
    }
}
