package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 1823.找出游戏的获胜者
 */
public class Problem1823 {

    static class Solution {
        public int findTheWinner(int n, int k) {
            if (n == 1) {
                return 1;
            }
            if (k == 1) {
                return n;
            }

            List<Integer> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            int index = k - 1;
            while (list.size() > 1){
                list.remove(index);
                index = (index  + k - 1) % list.size();
            }

            return list.get(0);
        }
    }


}