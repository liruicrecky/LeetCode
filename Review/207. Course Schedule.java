class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] outDegree = new int[numCourses];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            outDegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                que.add(i);
                ++count;
            }
        }

        while (!que.isEmpty()) {
            int course = que.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int p = (int) graph[course].get(i);
                outDegree[p]--;
                if (outDegree[p] == 0) {
                    que.add(p);
                    ++count;
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
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
                dp[course] = false;
                return false;
            }
        }

        dp[course] = true;
        return true;
    }
}