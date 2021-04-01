/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
import java.util.*;


class Solution {
    private Set<Integer> track;
    private boolean hasFinished;
    private int n;
    private int size;

    public List<Integer> grayCode(int n) {
        this.n = n;
        size = (int) Math.pow(2, n);
        track = new LinkedHashSet<>(size);
        track.add(0);
        hasFinished = false;

        search(0);

        return new LinkedList<>(track);
    }

    private void search(int last) {
        if (track.size() == size) {
            hasFinished = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            int num = last ^ (1 << i);
            if (track.contains(num)) {
                continue;
            }

            track.add(num);
            search(num);

            if (hasFinished) {
                return;
            }

            track.remove(num);
        }
    }
}
// @lc code=end

