package algorithms;

/**
 * 1704.判断字符串的两半是否相似
 */
class Problem1704 {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        return count(s, 0, len / 2) == count(s, len / 2, len);
    }

    private int count(String s, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    count++;
                    break;
                default:
                    break;
            }
        }
        return count;
    }
}

