/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static final int LENGTH = 8;

    public int minMutation(String start, String end, String[] bank) {
        Set<String> targets = Arrays.stream(bank).collect(Collectors.toSet());
        if (!targets.contains(end)) {
            return -1;
        }
        targets.remove(start);

        Queue<String> sources = new ArrayDeque<>(bank.length);
        sources.offer(start);

        int count = 0;
        while (!sources.isEmpty()) {
            count++;
            int size = sources.size();
            for (int i = 0; i < size; i++) {
                String source = sources.poll();

                Iterator<String> iterator = targets.iterator();
                while (iterator.hasNext()) {
                    String target = iterator.next();
                    if (canConvert(source, target)) {
                        if (target.equals(end)) {
                            return count;
                        }
                        iterator.remove();
                        sources.offer(target);
                    }
                }

            }
        }

        return -1;
    }

    private boolean canConvert(String source, String target) {
        int diff = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }

        return diff == 1;
    }
}
// @lc code=end

