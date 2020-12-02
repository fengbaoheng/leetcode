import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    private String[] words;
    private int lineWidth;
    private int index;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.lineWidth = maxWidth;
        this.index = 0;

        List<String> lines = new LinkedList<>();

        while (!isEnd()) {
            List<String> lineWords = seperateLine();
            Function<List<String>, String> align = getAlignFunction();
            String line = align.apply(lineWords);
            lines.add(line);
        }

        return lines;
    }

    /**
     * 断句是否结束
     */
    private boolean isEnd() {
        return index >= words.length;
    }

    /**
     * 断句
     */
    private List<String> seperateLine() {
        List<String> lineWords = new ArrayList<>();
        int length = 0;

        // 贪心 尽可能多的给一行中添加单词
        for (int i = index; i < words.length; i++) {
            String word = words[i];

            // 单词占据长度 = 单词自身长度 + 1个空格
            length += word.length() + 1;
            if (length > lineWidth + 1) {
                break;
            }

            lineWords.add(word);
        }

        // 下一次断句的开始点
        index += lineWords.size();

        return lineWords;
    }

    /**
     * 获取对齐函数, 最后一行左对齐, 其余行两端对齐
     */
    private Function<List<String>, String> getAlignFunction() {
        return isEnd() ? this::justifyLeft : this::justify;
    }

    /**
     * 两端对齐
     */
    private String justify(List<String> words) {
        // 只有一个单词, 只需在末尾补充空格, 即左对齐
        if (words.size() == 1) {
            return justifyLeft(words);
        }

        // 所有单词长度之和
        int wordsLength = words.stream().mapToInt(String::length).sum();

        // 每个分隔区的空格数量
        int[] intervals = new int[words.size() - 1];

        // 空格数量
        int spaceCount = lineWidth - wordsLength;

        // 均匀分配空格
        int spacesPerInterval = spaceCount / intervals.length;
        Arrays.fill(intervals, spacesPerInterval);

        // 剩余空格分配至左侧
        int restSpaces = spaceCount % intervals.length;
        for (int i = 0; i < restSpaces; i++) {
            intervals[i] += 1;
        }

        // 拼接单词
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            stringBuilder.append(words.get(i));
            if (i < intervals.length) {
                for (int j = 0; j < intervals[i]; j++) {
                    stringBuilder.append(" ");
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 左对齐
     */
    private String justifyLeft(List<String> words) {
        StringBuilder stringBuilder = new StringBuilder(String.join(" ", words));

        // 末尾补齐空格
        while (stringBuilder.length() < lineWidth) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
// @lc code=end