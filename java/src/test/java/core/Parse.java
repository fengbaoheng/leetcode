package core;

import java.util.*;

public class Parse {
    public static int[][] parse2dIntArr(String json) {
        // 去除左右两侧括号
        String trim = json.substring(2, json.length() - 2);
        // 分割
        String[] items = trim.split("],\\[");

        final int n = items.length;
        List<int[]> result = new ArrayList<>(n);
        for (String item : items) {
            final int[] nums = Arrays
                    .stream(item.split(","))
                    .mapToInt(Integer::valueOf).toArray();
            result.add(nums);
        }

        return result.toArray(new int[0][]);
    }
}
