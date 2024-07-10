class Solution {
    public int minOperations(String[] logs) {
        Stack<String> operations = new Stack<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!operations.isEmpty()) {
                    operations.pop();
                }
            } else if (!log.equals("./")) {
                operations.push(log);
            }
        }

        return operations.size();
    }
}