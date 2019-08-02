/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 */
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        // 长短数组
        int[] shortArr = A.length < B.length ? A : B;
        int[] longArr = A.length < B.length ? B : A;

        // 分别求二者总和
        int sumShort = Arrays.stream(shortArr).sum();
        int sumLong = Arrays.stream(longArr).sum();

        // 找到两个交换数字的差值
        int diff = (sumLong - sumShort) / 2;

        HashSet<Integer> longSet = new HashSet<>();
        for (int num : longArr) {
            longSet.add(num);
        }


        // 遍历短数组 寻找长数组中是否存在相差diff的数字
        int[] result = new int[2];
        for(int num:shortArr){
            if(longSet.contains(num+diff)){
                if(A.length < B.length){
                    result[0] = num;
                    result[1] = num+diff;
                }else{
                    result[0] = num+diff;
                    result[1] = num;
                }
                break;
            }
        }

        return result;
    }
}

