/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] 设计有序流
 */

// @lc code=start
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class OrderedStream {
    private final String[] values;
    private int ptr;

    public OrderedStream(int n) {
        values = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        values[id] = value;

        if (ptr >= values.length || values[ptr] == null) {
            return Collections.emptyList();
        }

        List<String> result = new LinkedList<>();

        for (; ptr < values.length; ptr++) {
            String str = values[ptr];
            if (str == null) {
                break;
            }

            result.add(str);
        }

        return result;
    }
}


/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
// @lc code=end

