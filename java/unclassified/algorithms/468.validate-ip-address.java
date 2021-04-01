/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    private IPv4 iPv4 = new IPv4();
    private IPv6 iPv6 = new IPv6();

    public String validIPAddress(String IP) {
        if (iPv4.isValid(IP)) {
            return "IPv4";
        } else if (iPv6.isValid(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}

abstract class IPAddress {
    private final String delimiter;
    private final int segmentCount;
    private final String regex;

    public IPAddress(String delimiter, String regex, int segmentCount) {
        this.delimiter = delimiter;
        this.regex = regex;
        this.segmentCount = segmentCount;
    }

    public boolean isValid(String IP) {
        if (!IP.contains(delimiter)) {
            return false;
        }
        if (IP.substring(IP.length() - 1).equals(delimiter)) {
            return false;
        }

        // 拆分各块
        String[] segments = IP.split(regex);
        if (segments.length != segmentCount) {
            return false;
        }

        // 依次验证各块
        for (String segment : segments) {
            if (!isValidSegment(segment)) {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isValidSegment(String segment);
}


class IPv4 extends IPAddress {
    public IPv4() {
        super(".", "\\.", 4);
    }

    @Override
    protected boolean isValidSegment(String segment) {
        if (segment == null) {
            return false;
        }

        final int length = segment.length();
        if (length == 0 || length > 3) {
            return false;
        }

        // 2-3位数字不能0开头
        if (length >= 2 && segment.charAt(0) == '0') {
            return false;
        }

        for (char c : segment.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }

        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}

class IPv6 extends IPAddress {
    public IPv6() {
        super(":", ":", 8);
    }

    @Override
    protected boolean isValidSegment(String segment) {
        if (segment == null) {
            return false;
        }

        final int length = segment.length();
        if (length == 0 || length > 4) {
            return false;
        }

        for (char c : segment.toCharArray()) {
            boolean isNumber = c >= '0' && c <= '9';
            boolean isLower = c >= 'a' && c <= 'f';
            boolean isUpper = c >= 'A' && c <= 'F';

            if (!(isNumber || isLower || isUpper)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

