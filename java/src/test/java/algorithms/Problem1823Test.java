package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1823Test {

    Problem1823.Solution solution = new Problem1823.Solution();

    @Test
    void test1(){
        Assertions.assertEquals(317, solution.findTheWinner(500,16));
    }

    @Test
    void test2(){
       Assertions.assertEquals(3, solution.findTheWinner(5,2));
    }

    @Test
    void test3(){
        Assertions.assertEquals(1, solution.findTheWinner(6,5));

    }
}