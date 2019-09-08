class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] outDegree = new int[numCourses];
        int[] res = new int[numCourses];
        int count = 0, index = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] pair : prerequisites) {
            outDegree[pair[1]]++;
            graph[pair[0]].add(pair[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                que.offer(i);
                ++count;
            }
        }

        while (!que.isEmpty()) {
            int course = que.poll();
            res[index--] = course;
            for (int i = 0; i < graph[course].size(); i++) {
                int preCourse = (int) graph[course].get(i);
                outDegree[preCourse]--;
                if (outDegree[preCourse] == 0) {
                    que.offer(preCourse);
                    ++count;
                }
            }
        }

        return count == numCourses ? res : new int[] {};
    }
}