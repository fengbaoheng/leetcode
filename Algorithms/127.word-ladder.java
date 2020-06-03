/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> remainSet = new HashSet<>(wordList);
        remainSet.add(beginWord);

        // 字典中不包含结尾，永远也无法转换到
        if (!remainSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>(wordList.size());
        queue.add(endWord);

        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final String word = queue.poll();

                final Iterator<String> iterator = remainSet.iterator();
                while (iterator.hasNext()) {
                    String w = iterator.next();
                    if (canConvert(w, word)) {
                        if (w.equals(beginWord)) {
                            return count;
                        }
                        iterator.remove();
                        queue.add(w);
                    }
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String a, String b) {
        int size = a.length();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }
}
// @lc code=end

