class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean found = false;
            for (int j = 0; j < word.length(); j++) {
                if (dict.contains(word.substring(0, j + 1))) {
                    res.append(word.substring(0, j + 1));
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.append(word);
            }
            if (i != words.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}