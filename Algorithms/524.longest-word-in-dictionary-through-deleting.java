/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new TreeSet<>());
            map.get(c).add(i);
        }

        List<String> results = new ArrayList<>(d.size());


        for (String word : d) {
            int len = word.length();
            if (len >= s.length()) {
                if (len == s.length() && s.equals(word)) {
                    results.add(word);
                }
                continue;
            }

            int index = -1;
            boolean addFlag = true;
            for (char c : word.toCharArray()) {
                TreeSet<Integer> treeSet = map.get(c);
                if (treeSet == null) {
                    addFlag = false;
                    break;
                }

                Integer nextIndex = treeSet.higher(index);
                if (nextIndex == null) {
                    addFlag = false;
                    break;
                }

                index = nextIndex;
            }

            if (addFlag) {
                results.add(word);
            }
        }


        if (results.isEmpty()) {
            return "";
        }

        results.sort((a, b) -> {
            int lenA = a.length();
            int lenB = b.length();
            if (lenA != lenB) {
                return lenA > lenB ? -1 : 1;
            }
            return a.compareTo(b);
        });

        return results.get(0);
    }
}
// @lc code=end

