/*
 * @lc app=leetcode.cn id=1600 lang=java
 *
 * [1600] 皇位继承顺序
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 一颗多叉树的前序遍历
class ThroneInheritance {
    // 记录所有节点以进行快速搜索
    Map<String, TreeNode> map = new HashMap<>();
    
    // 树的根节点
    TreeNode root;

    public ThroneInheritance(String kingName) {
        root = new TreeNode(kingName);
        map.put(kingName, root);
    }

    // 添加子节点
    public void birth(String parentName, String childName) {
        TreeNode child = new TreeNode(childName);
        map.put(childName, child);

        TreeNode parent = map.get(parentName);
        parent.addChild(child);
    }

    public void death(String name) {
        map.get(name).isDeath = true;
    }

    // 递归先序遍历
    public List<String> getInheritanceOrder() {
        List<String> order = new LinkedList<>();
        root.getInheritanceOrder(order);
        return order;
    }


    private static class TreeNode {
        final String name;
        final List<TreeNode> children = new LinkedList<>();
        boolean isDeath = false;

        public TreeNode(String name) {
            this.name = name;
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
        }

        // 递归获取顺序
        public void getInheritanceOrder(List<String> order) {
            if (!isDeath) {
                order.add(this.name);
            }

            for (TreeNode child : children) {
                child.getInheritanceOrder(order);
            }
        }
    }
}
// @lc code=end

