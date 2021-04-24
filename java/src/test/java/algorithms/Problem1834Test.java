package algorithms;

import core.Parse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1834Test {
    Problem1834.Solution solution = new Problem1834.Solution();

    @Test
    void test1() {
        int[][] params = Parse.parse2dIntArr("[[1,2],[2,4],[3,2],[4,1]]");
        int[] result = Parse.parseIntArr("[0,2,3,1]");

        Assertions.assertArrayEquals(result, solution.getOrder(params));
    }

    @Test
    void test2() {
        int[][] params = Parse.parse2dIntArr("[[7,10],[7,12],[7,5],[7,4],[7,2]]");
        int[] result = Parse.parseIntArr("[4,3,2,0,1]");

        Assertions.assertArrayEquals(result, solution.getOrder(params));
    }
}