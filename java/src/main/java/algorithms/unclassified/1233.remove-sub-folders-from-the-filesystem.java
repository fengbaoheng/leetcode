/*
 * @lc app=leetcode.cn id=1233 lang=java
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
import java.util.*;

class Solution {
    // 字典树
    public List<String> removeSubfolders(String[] folder) {
        // 目录根节点
        FolderNode root = new FolderNode("root");

        // 依次遍历
        for (String path : folder) {
            String[] names = path.split("/");
            FolderNode node = root;

            // 逐层向下递归添加子目录
            for (int i = 1; i < names.length; i++) {
                node = node.add(names[i]);
                // 若添加失败,则说明该目录已被标记删除
                if (node == null) {
                    break;
                }
            }

            // 最后一个目录添加删除标签
            if (node != null) {
                node.path = path;
                node.isDeleteSub = true;
            }
        }

        return root.getSubName();
    }
}


class FolderNode {
    // 名称
    final String name;

    // 全路径
    String path;

    // 删除当前子目录
    boolean isDeleteSub;

    // 子目录
    Map<String, FolderNode> sub = new HashMap<>();

    FolderNode(String name) {
        this.name = name;
    }

    // 添加目录
    // 若子目录标记删除则返回null
    FolderNode add(String name) {
        if (isDeleteSub) {
            return null;
        }
        sub.putIfAbsent(name, new FolderNode(name));
        return sub.get(name);
    }

    // 递归获取子路径名称
    List<String> getSubName() {
        List<String> results = new LinkedList<>();

        if (isDeleteSub) {
            results.add(path);
            return results;
        }

        sub.values().forEach(subNode -> results.addAll(subNode.getSubName()));

        return results;
    }
}
// @lc code=end

