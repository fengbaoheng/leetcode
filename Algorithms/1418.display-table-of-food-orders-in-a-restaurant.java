/*
 * @lc app=leetcode.cn id=1418 lang=java
 *
 * [1418] 点菜展示表
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Table> tableMap = new HashMap<>();
        Set<String> foods = new HashSet<>();

        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String food = order.get(2);

            Table table = tableMap.get(tableNumber);
            if (table == null) {
                table = new Table(tableNumber);
                tableMap.put(tableNumber, table);
            }
            foods.add(food);
            table.order(food);
        }


        List<String> foodList = foods.stream().sorted().collect(Collectors.toList());

        List<String> header = new LinkedList<>();
        header.add("Table");
        header.addAll(foodList);

        List<List<String>> results = new LinkedList<>();
        results.add(header);

        results.addAll(
                tableMap.values()
                        .stream()
                        .sorted()
                        .map(table -> table.getInfo(foodList))
                        .collect(Collectors.toList())
        );

        return results;
    }
}

class Table implements Comparable<Table> {
    private final int number;
    private final Map<String, Integer> foodMap = new HashMap<>();

    public Table(int number) {
        this.number = number;
    }

    public void order(String food) {
        foodMap.merge(food, 1, Integer::sum);
    }

    public List<String> getInfo(List<String> foods) {
        List<String> info = new LinkedList<>();

        info.add(String.valueOf(number));

        for (String food : foods) {
            Integer count = foodMap.getOrDefault(food, 0);
            info.add(count.toString());
        }

        return info;
    }

    @Override
    public int compareTo(Table o) {
        return this.number - o.number;
    }
}
// @lc code=end

