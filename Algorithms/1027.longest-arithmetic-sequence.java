/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int longestArithSeqLength(int[] A) {
        List<Num> nums = Arrays.stream(A).mapToObj(Num::new).collect(Collectors.toList());

        int longest = 1;
        for (int i = 1; i < nums.size(); i++) {
            Num cur = nums.get(i);
            for (int j = 0; j < i; j++) {
                Num pre = nums.get(j);
                longest = Math.max(longest, cur.diff(pre));
            }
        }
        return longest;
    }
}

class Num {
    private final int num;
    
    // 记录差值和对应的长度
    private final Map<Integer, Integer> sequenceMap = new HashMap<>();

    public Num(int num) {
        this.num = num;
    }

    public int diff(Num pre) {
        int diff = this.num - pre.num;
        int sequence = pre.getSequence(diff) + 1;
        this.setSequence(diff, sequence);
        return sequence;
    }

    private int getSequence(int diff) {
        return sequenceMap.getOrDefault(diff, 1);
    }

    private void setSequence(int diff, int sequence) {
        sequenceMap.merge(diff, sequence, Math::max);
    }
}
// @lc code=end

