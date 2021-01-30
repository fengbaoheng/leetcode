package algorithms;

/**
 * 1736.替换隐藏数字得到的最晚时间
 */
class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        return String.format("%s:%s", getHours(time), getMinutes(time));
    }

    private String getHours(String time) {
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);

        if (h1 == '?') {
            if (h2 == '?') {
                h1 = '2';
                h2 = '3';
            } else if (h2 >= '4') {
                h1 = '1';
            } else {
                h1 = '2';
            }
        }

        if (h2 == '?') {
            h2 = h1 == '2' ? '3' : '9';
        }

        return new String(new char[]{h1, h2});
    }

    private String getMinutes(String time) {
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);

        if (m1 == '?') m1 = '5';

        if (m2 == '?') m2 = '9';

        return new String(new char[]{m1, m2});
    }
}

