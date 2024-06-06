class Solution {
    private void generateBraces(String currentString, int openingBraces, int closingBraces, int length,
            List<String> ans) {

        if (currentString.length() == length * 2) {
            ans.add(currentString);
            return;
        }

        if (openingBraces < length)
            generateBraces(currentString + "(", openingBraces + 1, closingBraces, length, ans);

        if (closingBraces < openingBraces)
            generateBraces(currentString + ")", openingBraces, closingBraces + 1, length, ans);

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateBraces("", 0, 0, n, ans);
        return ans;
    }
}