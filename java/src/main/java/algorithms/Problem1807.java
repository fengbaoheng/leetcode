package algorithms;

import java.util.*;

/**
 * 1807.替换字符串中的括号内容
 */
public class Problem1807 {

    static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>(knowledge.size());
            for (List<String> pair : knowledge) {
                map.put(pair.get(0), pair.get(1));
            }

            StringBuilder builder = new StringBuilder(s.length());
            StringBuilder bracket = null;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    bracket = new StringBuilder();
                } else if (c == ')') {
                    assert bracket != null;
                    String value = map.getOrDefault(bracket.toString(), "?");
                    builder.append(value);
                    bracket = null;
                } else {
                    if (bracket != null) {
                        bracket.append(c);
                    } else {
                        builder.append(c);
                    }
                }
            }
            return builder.toString();
        }
    }
}