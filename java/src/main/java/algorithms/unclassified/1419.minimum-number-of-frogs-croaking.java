/*
 * @lc app=leetcode.cn id=1419 lang=java
 *
 * [1419] 数青蛙
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        FrogGroup group = new FrogGroup();

        for (char ch : croakOfFrogs.toCharArray()) {
            if (!group.croak(ch)) {
                return -1;
            }
        }

        return group.isTotalFinished() ? group.size() : -1;
    }


}

// 青蛙群
class FrogGroup {
    private final Map<Character, List<Frog>> frogMap;

    public FrogGroup() {
        this.frogMap = new HashMap<>(5);
        for (char ch : Frog.CHARS) {
            this.frogMap.put(ch, new LinkedList<>());
        }
    }

    public boolean croak(char ch) {
        List<Frog> frogs = frogMap.get(ch);
        Frog frog = null;

        if (frogs.isEmpty()) {
            // 没有对应的青蛙
            if (ch == Frog.BEGIN) {
                // 可以创建新青蛙
                frog = new Frog();
            } else {
                // 无法创建新青蛙，直接返回失败
                return false;
            }
        } else {
            // 有可用的青蛙
            frog = frogs.remove(0);

        }

        char expected = frog.croak();
        frogMap.get(expected).add(frog);

        return true;
    }

    // 所有青蛙全部鸣叫完毕
    public boolean isTotalFinished() {
        for (char ch : Frog.CHARS) {
            if (ch == Frog.BEGIN) {
                continue;
            }

            if (!frogMap.get(ch).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // 使用的青蛙数量
    public int size() {
        return frogMap.values().stream().mapToInt(List::size).sum();
    }

}

// 青蛙类
class Frog {
    public static final char[] CHARS = {'c', 'r', 'o', 'a', 'k'};
    public static final char BEGIN = CHARS[0];

    private int index = 0;

    public char croak() {
        index = (index + 1) % CHARS.length;
        return CHARS[index];
    }
}
// @lc code=end

