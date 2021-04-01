/*
 * @lc app=leetcode.cn id=937 lang=java
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        return Arrays.stream(logs)
                .map(Log::new)
                .sorted()
                .map(Log::getDescription)
                .toArray(String[]::new);
    }
}

class Log implements Comparable<Log> {
    private static int SEQUENCE = 0;

    // 记录出现的顺序
    private int sequence;

    // 原始描述
    private String description;

    // 标识符
    private String identifier;

    // 标识符内容
    private String content;

    Log(String description) {
        this.sequence = SEQUENCE++;
        this.description = description;

        String[] words = description.split(" ", 2);
        this.identifier = words[0];
        this.content = words[1];
    }

    // 返回日志原始字符串描述
    String getDescription() {
        return this.description;
    }

    // 是否为数字日志
    private boolean isNumber() {
        return Character.isDigit(this.content.charAt(0));
    }


    @Override
    public int compareTo(Log o) {

        if (this.isNumber()) {
            return o.isNumber() ? this.sequence - o.sequence : 1;
        } else {
            int contentCompare = this.content.compareTo(o.content);
            return o.isNumber() ? -1 : contentCompare == 0 ? this.identifier.compareTo(o.identifier) : contentCompare;
        }
    }
}
// @lc code=end

