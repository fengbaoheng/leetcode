/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {
    // 动态规划
    public int findLongestChain(int[][] pairs) {
        // 创建对象并排序好
        List<Pair> pairList = Arrays.stream(pairs).map(Pair::new).sorted().collect(toList());

        // O(N^2)的时间复杂度尝试对每个Pair和它前方的所有Pair成链
        for (int i = 0; i < pairList.size(); i++) {
            Pair pair = pairList.get(i);
            for (int j = 0; j < i; j++) {
                pair.tryChain(pairList.get(j));
            }
        }

        return pairList.stream().mapToInt(Pair::getChain).max().orElse(0);
    }
}

class Pair implements Comparable<Pair> {
    private final int start;
    private final int end;

    // 链长，最短为1即仅包含自身
    private int chain = 1;

    public Pair(int[] pair) {
        this.start = pair[0];
        this.end = pair[1];
    }

    // 尝试和前方Pair成链
    public void tryChain(Pair prePair) {
        if (this.start > prePair.end) {
            // 如果符合成链条件，则链长+1并更新
            this.chain = Math.max(this.chain, prePair.chain + 1);
        }
    }

    public int getChain() {
        return chain;
    }

    // 按首位数字大小排序
    @Override
    public int compareTo(Pair o) {
        return this.start - o.start;
    }
}
// @lc code=end

