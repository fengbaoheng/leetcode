package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 1694.重新格式化电话号码
 */

class Problem1694 {
    // 逐步模拟
    public String reformatNumber(String number) {
        // 筛选出数字
        List<Character> chars = new ArrayList<>(number.length());
        for (char c : number.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars.add(c);
            }
        }

        int size = chars.size();
        StringBuilder builder = new StringBuilder(size * 2);
        int i = 0;
        // 三个一组成块，最后4个特殊考虑
        for (; i < size - 4; i += 3) {
            builder.append(chars.get(i));
            builder.append(chars.get(i + 1));
            builder.append(chars.get(i + 2));
            builder.append('-');
        }

        if (i >= size - 3) {
            for (int j = i; j < size; j++) {
                builder.append(chars.get(j));
            }
        } else {
            builder.append(chars.get(i));
            builder.append(chars.get(i + 1));
            builder.append('-');
            builder.append(chars.get(i + 2));
            builder.append(chars.get(i + 3));
        }

        return builder.toString();
    }
}
