/*
 * @lc app=leetcode.cn id=1238 lang=java
 *
 * [1238] 循环码排列
 */

// @lc code=start
import java.util.*;

class Solution {
    private int n;
    private int count;
    private Map<Integer, int[]> nextMap;
    private Set<Integer> visited;
    private boolean finished;

    public List<Integer> circularPermutation(int n, int start) {
        this.n = n;
        count = (int) Math.pow(2, n);
        nextMap = new HashMap<>(count);
        visited = new HashSet<>(count);
        finished = false;

        Deque<Integer> deque = new ArrayDeque<>(count);
        deque.offerLast(start);
        visited.add(start);
        search(deque);

        return new ArrayList<>(deque);
    }

    public void search(Deque<Integer> deque) {
        if (deque.size() == count) {
            finished = true;
            return;
        }

        int x = deque.peekLast();
        for (int num : getNext(x)) {
            if (visited.contains(num)) {
                continue;
            }

            deque.offerLast(num);
            visited.add(num);

            search(deque);
            if (finished) {
                return;
            }

            deque.pollLast();
            visited.remove(num);
        }
    }


    private int[] getNext(int x) {
        int[] next = nextMap.get(x);
        if (next != null) {
            return next;
        }

        next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = x ^ (1 << i);
        }

        nextMap.put(x, next);

        return next;
    }
}
// @lc code=end

