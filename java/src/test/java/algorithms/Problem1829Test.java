package algorithms;

import org.junit.jupiter.api.Test;

import static core.Parse.parseIntArr;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem1829Test {

    Problem1829.Solution solution = new Problem1829.Solution();

    @Test
    void test1() {
        int[] result = solution.getMaximumXor(parseIntArr("[0,1,1,3]"), 2);
        int[] expected = parseIntArr("[0,3,2,3]");
        assertArrayEquals(expected, result);
    }

    @Test
    void test2() {
        int[] result = solution.getMaximumXor(parseIntArr("[2,3,4,7]"), 3);
        int[] expected = parseIntArr("[5,2,6,5]");
        assertArrayEquals(expected, result);
    }

    @Test
    void test3() {
        int[] result = solution.getMaximumXor(parseIntArr("[0,1,2,2,5,7]"), 3);
        int[] expected = parseIntArr("[4,3,6,4,6,7]");
        assertArrayEquals(expected, result);
    }
}