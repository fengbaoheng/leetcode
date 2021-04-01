/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
import java.util.*;


class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        Queue<Section> qA = new LinkedList<>();
        for (int[] arr : A) {
            qA.add(new Section(arr));
        }

        Queue<Section> qB = new LinkedList<>();
        for (int[] arr : B) {
            qB.add(new Section(arr));
        }

        List<Section> intersects = new ArrayList<>();
        while (!qA.isEmpty() && !qB.isEmpty()) {
            Section sa = qA.element();
            Section sb = qB.element();

            sa.getIntersect(sb).ifPresent(intersects::add);
            int cmp = sa.compareTo(sb);
            if (cmp == 0) {
                qA.poll();
                qB.poll();
            } else if (cmp < 0) {
                qA.poll();
            } else {
                qB.poll();
            }
        }

        int[][] result = new int[intersects.size()][2];
        for (int i = 0; i < intersects.size(); i++) {
            result[i] = intersects.get(i).toArray();
        }

        return result;
    }
}

class Section {
    final int from;
    final int to;

    public Section(int[] arr) {
        this(arr[0], arr[1]);
    }

    public Section(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Optional<Section> getIntersect(Section s) {
        if (withNoIntersect(s)) {
            return Optional.empty();
        }

        int from = Math.max(this.from, s.from);
        int to = Math.min(this.to, s.to);
        Section intersect = new Section(from, to);
        return Optional.of(intersect);
    }

    private boolean withNoIntersect(Section s) {
        return this.to < s.from || s.to < this.from;
    }

    public int[] toArray() {
        return new int[]{from, to};
    }

    public int compareTo(Section s) {
        return this.to - s.to;
    }
}
// @lc code=end

