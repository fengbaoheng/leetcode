/*
 * @lc app=leetcode.cn id=1452 lang=java
 *
 * [1452] 收藏清单
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Map<String, Set<Integer>> companyUser = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (String company : favoriteCompanies.get(i)) {
                companyUser.putIfAbsent(company, new HashSet<>(n));
                companyUser.get(company).add(i);
            }
        }

        List<Integer> results = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Set<Integer> set = favoriteCompanies.get(i)
                    .stream()
                    .map(companyUser::get)
                    .reduce((a, b) -> {
                        Set<Integer> s = new HashSet<>(a);
                        s.retainAll(b);
                        return s;
                    })
                    .orElse(Collections.emptySet());

            if (set.size() <= 1) {
                results.add(i);
            }
        }

        return results;
    }
}
// @lc code=end

