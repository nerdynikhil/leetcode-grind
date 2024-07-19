class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return luckyNumbers;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowMins = new int[rows];
        for (int i = 0; i < rows; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            rowMins[i] = minVal;
        }

        int[] colMaxs = new int[cols];
        for (int j = 0; j < cols; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
            colMaxs[j] = maxVal;
        }

        Set<Integer> rowMinsSet = new HashSet<>();
        for (int min : rowMins) {
            rowMinsSet.add(min);
        }

        for (int max : colMaxs) {
            if (rowMinsSet.contains(max)) {
                luckyNumbers.add(max);
            }
        }

        return luckyNumbers;
    }
}