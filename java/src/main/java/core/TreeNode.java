package core;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(left == null ? "null" : left.val);
        stringBuilder.append("---");
        stringBuilder.append(val);
        stringBuilder.append("---");
        stringBuilder.append(right == null ? "null" : right.val);
        return stringBuilder.toString();
    }
}

