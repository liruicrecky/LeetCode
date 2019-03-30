/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (44.50%)
 * Total Accepted:    76.9K
 * Total Submissions: 171.7K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */
class Solution {
    private int leastInterval3(char[] tasks, int n) {
        int[] m = new int[26];
        for (char c : tasks) {
            m[c - 'A']++;
        }

        Arrays.sort(m);
        int i = 25;

        while (i >= 0 && m[i] == m[25]) {
            --i;
        }

        return Math.max(tasks.length, (m[25] - 1) * (n + 1) + 25 - i);
    }

    private int leastInterval2(char[] tasks, int n) {
        int[] m = new int[26];
        for (char c : tasks) {
            m[c - 'A']++;
        }

        PriorityQueue<Integer> que = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i : m) {
            if (i > 0) {
                que.offer(i);
            }  
        }

        int time = 0;
        while(!que.isEmpty()) {
            int i = 0;
            List<Integer> tmp = new LinkedList<>();
            while (i <= n) {
                if (!que.isEmpty()) {
                    if (que.peek() > 1) {
                        tmp.add(que.poll() - 1);
                    } else {
                        que.poll();
                    }
                }
                ++time;
                if (que.isEmpty() && tmp.isEmpty()) {
                    break;
                }    
                ++i;
            }
            for (int j : tmp) {
                que.offer(j);
            }
        }
        return time;
    }

    private int leastInterval1(char[] tasks, int n) {
        int[] m = new int[26];
        for (char c : tasks) {
            m[c - 'A']++;
        }

        Arrays.sort(m);
        int time = 0;

        while (m[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (m[25] == 0) {
                    break;
                }
                if (i < 26 && m[25 - i] > 0) {
                    m[25 - i]--;
                }
                ++time;
                ++i;
            }
        }

        return time;
    }

    public int leastInterval(char[] tasks, int n) {
        return leastInterval3(tasks, n);
    }
}

