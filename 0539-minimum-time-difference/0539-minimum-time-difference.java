class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int totalMinutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            minutes.add(totalMinutes);
        }

        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        minDiff = Math.min(minDiff, 1440 - (minutes.get(minutes.size() - 1) - minutes.get(0)));

        return minDiff;
    }
}