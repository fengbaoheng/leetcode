package algorithms.CheckIfTwoStringArraysAreEquivalent;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return combine(word1).equals(combine(word2));
    }

    public String combine(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
        }

        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
