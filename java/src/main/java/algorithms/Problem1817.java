package algorithms;

import java.util.*;

/**
 * 1817.查找用户活跃分钟数
 */
public class Problem1817 {

    static class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> counts = new HashMap<>(logs.length);
            for (int[] log : logs) {
                final int id = log[0];
                final int time = log[1];
                counts.computeIfAbsent(id, key -> new HashSet<>()).add(time);
            }

            final int[] UAM = new int[k];
            counts.forEach((id, set) -> {
                UAM[set.size() - 1]++;
            });

            return UAM;
        }
    }


}