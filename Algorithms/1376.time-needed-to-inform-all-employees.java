/*
 * @lc app=leetcode.cn id=1376 lang=java
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Person> people = new ArrayList<>(n);
        for (int time : informTime) {
            people.add(new Person(time));
        }

        for (int i = 0; i < n; i++) {
            int head = manager[i];
            if (head != -1) {
                people.get(head).addManaged(people.get(i));
            }
        }

        return people.get(headID).inform();
    }
}


class Person {
    private final int informTime;
    private List<Person> managed = new LinkedList<>();

    public Person(int informTime) {
        this.informTime = informTime;
    }

    public void addManaged(Person person) {
        managed.add(person);
    }

    public int inform() {
        return informTime + managed.stream().mapToInt(Person::inform).max().orElse(0);
    }
}
// @lc code=end

