/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (36.78%)
 * Total Accepted:    199.2K
 * Total Submissions: 536.1K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    private class Graph {
        private boolean visited;
        private List<Integer> n = new ArrayList<>();
        public Graph() {
        }
        public Graph(boolean v) {
            this.visited = v;
        }
        public boolean isVisited() {
            return visited;
        }
        public void setVisited(boolean v) {
            this.visited = v;
        }
        public void add(int n) {
            this.n.add(n);
        }
        public List<Integer> next() {
            return n;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        Graph[] g = new Graph[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new Graph(false);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            g[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(g, i)) {
                return false;
            }
        }

        return true;
        */
        return bfs(numCourses, prerequisites);
    }

    private boolean dfs(Graph[] g, int course) {
        if (g[course].isVisited()) {
            return false;
        } else {
            g[course].setVisited(true);
        }

        for (int i = 0; i < g[course].next().size(); i++) {
            if (!dfs(g, g[course].next().get(i))) {
                return false;
            }
        }
        g[course].setVisited(false);
        return true;
    }

    private boolean bfs(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
                ++count;
            }
        }

        while (!que.isEmpty()) {
            int currCourse = que.poll();
            for (int i = 0; i < g[currCourse].size(); i++) {
                int nextCourse = g[currCourse].get(i);
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    que.offer(nextCourse);
                    ++count;
                }
            }
        }

        return count == numCourses;
    }
}

