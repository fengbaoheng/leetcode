package algorithms;

import core.Parse;
import org.junit.jupiter.api.*;

class Problem1779Test {
    Problem1779.Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Problem1779.Solution();
    }

    @Test
    void test1() {
        int result = solution.nearestValidPoint(11, 1, Parse.parse2dIntArr("[[3,7],[1,9],[9,12],[3,4],[8,4],[9,4],[10,12],[12,14],[8,7],[12,11],[8,6],[4,2],[12,2],[11,8],[14,11],[14,2],[8,9],[5,8],[5,8],[1,7],[7,5],[6,11],[10,7],[10,6],[3,1],[4,9],[13,12]]"));
        Assertions.assertEquals(13, result);
    }
}