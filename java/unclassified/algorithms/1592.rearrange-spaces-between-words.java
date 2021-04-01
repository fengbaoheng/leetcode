/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        List<String> words = splitWord(text);
        int spaceCount = spaceCount(text);

        // 只有一个单词
        if (words.size() == 1) {
            return words.get(0) + getSpace(spaceCount);
        }

        // 多个单词计算每个单词之间的间隔
        int internalCount = words.size() - 1;
        int internalSpaceCount = spaceCount / internalCount;

        // 尾部剩余的空格数量
        int remainSpaceCount = spaceCount - (internalSpaceCount * internalCount);

        // 连接单词的间隔
        String internalSpace = getSpace(internalSpaceCount);

        // 拼接结果
        return String.join(internalSpace, words) + getSpace(remainSpaceCount);
    }

    // 生成指定数量的空格
    private String getSpace(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }

    // 切分单词
    private List<String> splitWord(String text) {
        List<String> result = new LinkedList<>();

        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                // 当前是字符，但是前一个不是字符，则是单词开头
                if (text.charAt(start) == ' ') {
                    start = i;
                }
            } else {
                // [start, i-1]是单词
                if (text.charAt(start) != ' ') {
                    result.add(text.substring(start, i));
                    start = i;
                }
            }
        }

        if (text.charAt(start) != ' ') {
            result.add(text.substring(start));
        }

        return result;
    }

    // 计算空格数量
    private int spaceCount(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

