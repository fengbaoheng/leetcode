package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1805Test {

    private Problem1805.Solution solution = new Problem1805.Solution();

    @Test
    void test1() {
        Assertions.assertEquals(2, solution.numDifferentIntegers("4r05743a05743n05743yoe"));

    }

}