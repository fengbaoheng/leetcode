/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    // 使用队列存储
    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        findNext();
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        findNext();
        return !deque.isEmpty();
    }

    // 检查首位是否嵌套, 并进行递归解构
    private void findNext() {
        while (!deque.isEmpty() && !deque.peek().isInteger()) {
            List<NestedInteger> list = deque.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.offerFirst(list.get(i));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

