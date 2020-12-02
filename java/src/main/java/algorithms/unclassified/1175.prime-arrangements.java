/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */
import java.math.BigInteger;
import java.util.stream.IntStream;

class Solution {
    public int numPrimeArrangements(int n) {
        // 统计质数个数
        int p = (int) IntStream
                .rangeClosed(2, n)
                .filter(this::isPrime)
                .count();


        // 非质数个数
        int np = n - p;

        // 排列组合
        BigInteger result = getFactorial(np).multiply(getFactorial(p));
        
        // 返回缩小后的结果
        return result.mod(BigInteger.valueOf(1_000_000_000L + 7)).intValue();
    }

    // 判断质数
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else {

            for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    // 求阶乘
    private BigInteger getFactorial(int n) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}

