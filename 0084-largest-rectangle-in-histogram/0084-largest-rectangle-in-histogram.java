class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        int n = heights.length;

        int i = 0;
        int area = 0;
        for (i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - st.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int top = st.pop();
            if (st.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - st.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}