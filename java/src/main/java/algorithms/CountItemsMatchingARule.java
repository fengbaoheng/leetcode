package algorithms;

import java.util.*;

/**
 * 1773.统计匹配检索规则的物品数量
 */

class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int n = items.size();

        Map<String, Integer> typeMap = new HashMap<>(n);
        Map<String, Integer> colorMap = new HashMap<>(n);
        Map<String, Integer> nameMap = new HashMap<>(n);

        for (List<String> item : items) {
            String type = item.get(0);
            String color = item.get(1);
            String name = item.get(2);

            typeMap.merge(type, 1, Integer::sum);
            colorMap.merge(color, 1, Integer::sum);
            nameMap.merge(name, 1, Integer::sum);
        }

        switch (ruleKey) {
            case "type":
                return typeMap.getOrDefault(ruleValue, 0);
            case "color":
                return colorMap.getOrDefault(ruleValue, 0);
            case "name":
                return nameMap.getOrDefault(ruleValue, 0);
            default:
                return 0;
        }
    }
}