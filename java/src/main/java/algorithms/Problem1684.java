package algorithms;

import java.util.BitSet;

/**
 * 1684.统计一致字符串的数目
 */
class Problem1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        BitSet bitSet = new BitSet(26);
        for (char c : allowed.toCharArray()) {
            int index = c - 'a';
            bitSet.set(index);
        }

        int count = 0;

        outerLoop:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (!bitSet.get(index)) {
                    continue outerLoop;
                }
            }
            count++;
        }

        return count;
    }
}
