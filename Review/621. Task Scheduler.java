class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }
        
        int[] c = new int[26];
        for (char task : tasks) {
            c[task - 'A']++;
        }
        
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) {
            --i;
        }
        
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}