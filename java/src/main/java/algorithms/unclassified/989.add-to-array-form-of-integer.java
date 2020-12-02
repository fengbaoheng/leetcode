/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
import java.util.*;


class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> arrayA = getArrayNum(A);
        List<Integer> arrayK = getArrayNum(K);

        List<Integer> result = arrayA.size() < arrayK.size() ? sum(arrayA, arrayK) : sum(arrayK, arrayA);
        Collections.reverse(result);

        return result;
    }
    
    // 数组转list
    private List<Integer> getArrayNum(int[] A) {
        List<Integer> num = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            num.add(A[i]);
        }
        return num;
    }

    // 数字转list
    private List<Integer> getArrayNum(int K) {
        List<Integer> num = new ArrayList<>();
        while (K != 0) {
            num.add(K % 10);
            K /= 10;
        }
        return num;
    }
    
    // 相加两个数字
    private List<Integer> sum(List<Integer> shorter, List<Integer> longer) {
        // 进位
        int d = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < longer.size(); i++) {
            int sum = d + longer.get(i) + (i < shorter.size() ? shorter.get(i) : 0);
            d = sum >= 10 ? 1 : 0;
            sum %= 10;

            result.add(sum);
        }

        if (d == 1) {
            result.add(1);
        }

        return result;
    }
}
// @lc code=end

