class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int i = 0;

        while (i < n) {
            if (formula.charAt(i) == '(') {
                st.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> curr = st.pop();
                i++;
                StringBuilder mult = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mult.append(formula.charAt(i));
                    i++;
                }
                int multInteger = mult.length() > 0 ? Integer.parseInt(mult.toString()) : 1;
                for (Map.Entry<String, Integer> entry : curr.entrySet()) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    curr.put(element, count * multInteger);
                }
                for (Map.Entry<String, Integer> entry : curr.entrySet()) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    st.peek().put(element, st.peek().getOrDefault(element, 0) + count);
                }
            } else {
                StringBuilder currElement = new StringBuilder();
                currElement.append(formula.charAt(i));
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    currElement.append(formula.charAt(i));
                    i++;
                }
                StringBuilder currCount = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    currCount.append(formula.charAt(i));
                    i++;
                }
                int currCountInteger = currCount.length() > 0 ? Integer.parseInt(currCount.toString()) : 1;
                st.peek().put(currElement.toString(),
                        st.peek().getOrDefault(currElement.toString(), 0) + currCountInteger);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(st.peek());
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String element = entry.getKey();
            result.append(element);
            int count = entry.getValue();
            if (count > 1) {
                result.append(count);
            }
        }

        return result.toString();
    }
}