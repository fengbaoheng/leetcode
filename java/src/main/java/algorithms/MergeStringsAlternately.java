package algorithms;

import java.util.Iterator;

/**
 * 1768.交替合并字符串
 */
class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        Iterator<Character> iterator1 = iterator(word1);
        Iterator<Character> iterator2 = iterator(word2);

        StringBuilder builder = new StringBuilder(word1.length() + word2.length());
        boolean flag = true;
        while (flag) {
            flag = false;
            if (iterator1.hasNext()) {
                flag = true;
                builder.append(iterator1.next());
            }

            if (iterator2.hasNext()) {
                flag = true;
                builder.append(iterator2.next());
            }
        }

        return builder.toString();
    }

    private Iterator<Character> iterator(String word) {
        return new Iterator<Character>() {
            private final char[] chars = word.toCharArray();
            private final int length = word.length();
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public Character next() {
                return chars[index++];
            }
        };
    }
}