class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        ArrayList[] graph = new ArrayList[numCourses];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] outDegree = new int[numCourses];
        int count = 0;

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
            for (int i = 0; i < graph[course].size(); i++) {
                int preCourse = (int) graph[course].get(i);
                outDegree[preCourse]--;
                if (outDegree[preCourse] == 0) {
                    que.offer(preCourse);
                    ++count;
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, dp, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] dp, int course) {
        if (visited[course]) {
            return dp[course];
        }

        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, dp, (int) graph[course].get(i))) {
                return dp[course] = false;
            }
        }

        return dp[course] = true;
    }
}