/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Node> nodes = IntStream.range(0, n).mapToObj(Node::new).collect(Collectors.toList());

        for (int i = 0; i < graph.length; i++) {
            Node node = nodes.get(i);
            for (int next : graph[i]) {
                Node nextNode = nodes.get(next);
                node.nextSet.add(nextNode);
                nextNode.prevSet.add(node);
            }
        }

        Queue<Node> queue = nodes.stream()
                .filter(Node::isSafe)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> safeNodes = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            safeNodes.add(node.label);

            node.prevSet.forEach(prevNode -> {
                prevNode.removeNext(node);
                if (prevNode.isSafe()) {
                    queue.offer(prevNode);
                }
            });
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    private static class Node {
        public final int label;
        public final Set<Node> nextSet = new HashSet<>();
        public final Set<Node> prevSet = new HashSet<>();

        public Node(int label) {
            this.label = label;
        }

        public boolean isSafe() {
            return nextSet.isEmpty();
        }

        private void removeNext(Node node) {
            nextSet.remove(node);
        }
    }
}
// @lc code=end

