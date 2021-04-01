/*
 * @lc app=leetcode.cn id=1366 lang=java
 *
 * [1366] 通过投票对团队排名
 */

// @lc code=start
import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, Team> teams = new HashMap<>(26);
        for (char c : votes[0].toCharArray()) {
            teams.put(c, new Team(c));
        }

        // 记录投票顺序
        for (String vote : votes) {
            for (int i = 0; i < vote.toCharArray().length; i++) {
                Team team = teams.get(vote.charAt(i));
                team.vote(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        teams.values().stream().sorted().map(Team::getName).forEachOrdered(stringBuilder::append);
        return stringBuilder.toString();
    }
}

/**
 * 队伍类
 */
class Team implements Comparable<Team> {
    private final char name;
    private final int[] votes = new int[26];

    public Team(char name) {
        this.name = name;
    }

    public void vote(int rank) {
        this.votes[rank]++;
    }

    public char getName() {
        return name;
    }

    @Override
    public int compareTo(Team o) {
        // 依次比较不同排名的票数
        for (int i = 0; i < 26; i++) {
            int v1 = votes[i];
            int v2 = o.votes[i];
            if (v1 != v2) {
                return v2 - v1;
            }
        }
        // 所有票数都相等
        return Character.compare(name, o.name);
    }
}
// @lc code=end

