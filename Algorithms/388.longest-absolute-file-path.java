/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int lengthLongestPath(String input) {
        // 按行切分
        String[] lines = input.split("\n");

        Map<Integer, File> depthFileMap = new HashMap<>();
        File longestFile = new File(null);

        for (String line : lines) {
            int depth = getDepth(line);
            File parent = depthFileMap.get(depth - 1);
            File cur = new File(parent);

            for (int i = depth; i < line.length(); i++) {
                cur.addCharacter(line.charAt(i));
            }

            if (cur.isDirectory()) {
                depthFileMap.put(depth, cur);
            } else if (cur.compareTo(longestFile) < 0) {
                longestFile = cur;
            }
        }

        return longestFile.getLength();
    }

    // 解析深度
    private int getDepth(String line) {
        int depth = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\t') {
                depth++;
            } else {
                break;
            }
        }
        return depth;
    }
}

class File implements Comparable<File> {
    private final File parent;

    private List<Character> name = new LinkedList<>();
    private boolean isDirectory = true;

    public File(File parent) {
        this.parent = parent;
    }

    public void addCharacter(char c) {
        name.add(c);

        if (c == '.') {
            isDirectory = false;
        }
    }

    public int getLength() {
        int length = parent == null ? 0 : 1 + parent.getLength();
        length += name.size();
        return length;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public int compareTo(File o) {
        return o.getLength() - this.getLength();
    }
}
// @lc code=end

