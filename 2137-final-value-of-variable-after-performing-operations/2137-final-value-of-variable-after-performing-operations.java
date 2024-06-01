class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (String operation : operations) {
            if (operation.equals("--X") || operation.equals("X--"))
                val -= 1;
            if (operation.equals("++X") || operation.equals("X++"))
                val += 1;
        }
        return val;
    }
}