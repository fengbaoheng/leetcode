/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final int N = quiet.length;
        final Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            people[i] = new Person(i, quiet[i]);
        }

        for (int[] rich : richer) {
            Person r = people[rich[0]];
            Person p = people[rich[1]];
            p.addRicher(r);
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = people[i].getQuietestRicher().id;
        }

        return result;
    }

    private static class Person {
        public final int id;
        private final int quietness;
        private final List<Person> richer = new LinkedList<>();
        private Person quietestRicher = null;

        public Person(int id, int quietness) {
            this.id = id;
            this.quietness = quietness;
        }

        public void addRicher(Person person) {
            richer.add(person);
        }

        public Person getQuietestRicher() {
            if (quietestRicher != null) {
                return quietestRicher;
            }

            Person result = this;
            for (Person rich : richer) {
                if (rich.getQuietestRicher().isQuietBy(result)) {
                    result = rich;
                }
            }
            quietestRicher = result;
            return result;
        }

        private boolean isQuietBy(Person p) {
            return this.quietness <= p.quietness;
        }
    }
}
// @lc code=end

