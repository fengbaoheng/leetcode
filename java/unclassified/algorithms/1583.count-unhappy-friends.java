/*
 * @lc app=leetcode.cn id=1583 lang=java
 *
 * [1583] 统计不开心的朋友
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Kid[] kids = new Kid[n];

        // 初始化
        for (int i = 0; i < n; i++) {
            kids[i] = new Kid(i);
        }

        // 配对
        for (int[] pair : pairs) {
            Kid k1 = kids[pair[0]];
            Kid k2 = kids[pair[1]];

            k1.match(k2);
            k2.match(k1);
        }

        // 关联朋友关系
        for (int i = 0; i < n; i++) {
            Kid kid = kids[i];
            for (int prefer : preferences[i]) {
                if (!kid.addFriend(kids[prefer])) {
                    break;
                }
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            if (kids[i].isUnhappy()) {
                count++;
            }
        }
        return count;
    }
}

class Kid {
    private final int id;
    private final Set<Kid> preferFriends = new HashSet<>();
    private Kid matched = null;
    private Boolean isUnhappy = null;

    public Kid(int id) {
        this.id = id;
    }

    public boolean isUnhappy() {
        if (isUnhappy == null) {
            search();
        }
        return isUnhappy;
    }

    private void search() {
        if (preferFriends.isEmpty()) {
            isUnhappy = false;
            return;
        }

        for (Kid friend : preferFriends) {
            if (friend.preferFriends.contains(this)) {
                this.isUnhappy = true;
                friend.isUnhappy = true;
            }
        }

        if (isUnhappy == null) {
            isUnhappy = false;
        }
    }

    public void match(Kid kid) {
        this.matched = kid;
    }

    public boolean addFriend(Kid kid) {
        if (kid == matched) {
            return false;
        }

        preferFriends.add(kid);
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
// @lc code=end

