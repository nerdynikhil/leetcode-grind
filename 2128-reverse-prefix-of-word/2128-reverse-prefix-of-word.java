class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

        String originalStringToReverse = word.substring(0, index + 1);
        String reversedString = reverseString(originalStringToReverse);

        String result = reversedString + word.substring(index + 1);
        return result;
    }

    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}