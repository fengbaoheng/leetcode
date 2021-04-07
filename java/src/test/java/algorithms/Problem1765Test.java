package algorithms;

import core.Parse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1765Test {
    Problem1765.Solution solution = new Problem1765.Solution();

    @Test
    void test1() {
        int[][] params = Parse.parse2dIntArr("[[0,1],[0,0]]");
        int[][] result = Parse.parse2dIntArr("[[1,0],[2,1]]");
        Assertions.assertArrayEquals(result, solution.highestPeak(params));
    }

    @Test
    void test2() {
        int[][] params = Parse.parse2dIntArr("[[0,0,1],[1,0,0],[0,0,0]]");
        int[][] result = Parse.parse2dIntArr("[[1,1,0],[0,1,1],[1,2,2]]");
        Assertions.assertArrayEquals(result, solution.highestPeak(params));
    }

    @Test
    void test3() {
        int[][] params = Parse.parse2dIntArr("[[0,0],[1,1],[1,0]]");
        int[][] result = Parse.parse2dIntArr("[[1,1],[0,0],[0,1]]");
        Assertions.assertArrayEquals(result, solution.highestPeak(params));
    }
}