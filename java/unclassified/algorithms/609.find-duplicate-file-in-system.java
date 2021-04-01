/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    Map<String, List<String>> map;

    public List<List<String>> findDuplicate(String[] paths) {
        map = new HashMap<>();

        // 逐个解析目录
        for (String str : paths) {
            parseFile(str);
        }

        // 过滤出现重复的文件
        return map.values()
                .stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toList());
    }

    private void parseFile(String str) {
        String[] strings = str.split(" ");

        // 目录路径
        String path = strings[0];

        // 解析每个文件字符串
        for (int i = 1; i < strings.length; i++) {
            String fileStr = strings[i];

            // 拆分文件名和文件内容
            int index = fileStr.indexOf('(');
            String name = fileStr.substring(0, index);
            String content = fileStr.substring(index + 1, fileStr.length() - 1);

            String file = String.format("%s/%s", path, name);

            // 哈希表判断是否有重复内容的文件
            if (!map.containsKey(content)) {
                map.put(content, new LinkedList<>());
            }
            map.get(content).add(file);
        }
    }
}
// @lc code=end

