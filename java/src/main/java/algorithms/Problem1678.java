package algorithms;

/**
 * 1678.设计 Goal 解析器
 */
class Problem1678 {
    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();

        char[] array = command.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (ch == 'G') {
                builder.append('G');
            } else if (ch == '(') {
                if (array[i + 1] == ')') {
                    builder.append('o');
                    i += 1;
                } else {
                    builder.append("al");
                    i += 3;
                }
            }
        }

        return builder.toString();
    }
}
