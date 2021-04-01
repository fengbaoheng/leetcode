/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */
import java.util.*;

class Solution {
    // 统计每张纸牌数字出现的次数 count[]
    // 寻找这些次数的最大公约数 maxCommonDivisor
    // return 最大公约数>=2
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> count = new ArrayList<>(map.values());

        int d = count.get(0);
        for (int i = 1; i < count.size(); i++) {
            d = getCommonDivisor(d, count.get(i));

            if (d < 2) {
                return false;
            }
        }

        return d >= 2;
    }

    // 计算两个数字的公约数
    private int getCommonDivisor(int m, int n) {
        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }

        return m;
    }
}
