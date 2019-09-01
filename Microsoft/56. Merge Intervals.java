class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];

        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<int[]> list = new ArrayList<>();
        int startIndex = 0, endIndex = 0;

        while (endIndex < len) {
            if (endIndex == len - 1 || start[endIndex + 1] > end[endIndex]) {
                list.add(new int[] { start[startIndex], end[endIndex] });
                startIndex = endIndex + 1;
            }
            ++endIndex;
        }

        return list.toArray(new int[list.size()][2]);
    }
}