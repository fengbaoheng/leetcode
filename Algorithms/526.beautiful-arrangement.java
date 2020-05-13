/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

// @lc code=start
import java.util.LinkedHashSet;
import java.util.Set;


class Solution {
    private int result;

    public int countArrangement(int N) {
        this.result = 0;
        Set<Integer> track = new LinkedHashSet<>();
        search(N, track);

        return result;
    }

    public void search(int N, Set<Integer> track) {
        // 结束条件
        if (track.size() == N) {
            result++;
        }

        // 对每个数字进行尝试
        for (int num = 1; num <= N; num++) {
            int index = track.size() + 1;
            if (track.contains(num) || !isValid(index, num)) {
                continue;
            }

            track.add(num);
            search(N, track);
            track.remove(num);
        }
    }

    private boolean isValid(int index, int num) {
        return index % num == 0 || num % index == 0;
    }
}
// @lc code=end

