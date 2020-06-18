/*
 * @lc app=leetcode.cn id=1447 lang=java
 *
 * [1447] 最简分数
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.addAll(fractions(i));
        }
        return list;
    }

    private List<String> fractions(int d) {
        List<String> list = new ArrayList<>(d);

        boolean[] numerator = getNumerator(d);
        for (int i = 1; i < numerator.length; i++) {
            if (numerator[i]) {
                list.add(getFraction(i, d));
            }
        }
        return list;
    }

    private boolean[] getNumerator(int d) {
        boolean[] numerator = new boolean[d + 1];
        Arrays.fill(numerator, true);
        numerator[d] = false;
        for (int i = 2; i < d; i++) {
            if (numerator[i] && d % i == 0) {
                int j = i;
                while (j < d) {
                    numerator[j] = false;
                    j += i;
                }
            }
        }
        return numerator;
    }

    private String getFraction(int m, int d) {
        return String.format("%d/%d", m, d);
    }
}
// @lc code=end

