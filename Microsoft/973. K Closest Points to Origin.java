class Solution {
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        if (points == null || points.length == 0 || K < 1) {
            return points;
        }

        PriorityQueue<int[]> que = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return distance(p2) - distance(p1);
            }
        });

        for (int[] point : points) {
            que.offer(point);
            if (que.size() > K) {
                que.poll();
            }
        }

        int[][] res = new int[K][2];
        int i = 0;
        while (!que.isEmpty()) {
            res[i++] = que.poll();
        }

        return res;
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int l = 0, r = len - 1;

        while (l <= r) {
            int pivot = help(points, l, r);
            if (pivot == K) {
                break;
            } else if (pivot > K) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int help(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && distance(points[r]) >= distance(pivot)) {
                --r;
            }
            if (l < r) {
                points[l] = points[r];
            }

            while (l < r && distance(points[l]) <= distance(pivot)) {
                ++l;
            }
            if (l < r) {
                points[r] = points[l];
            }
        }

        points[l] = pivot;
        return l;
    }

    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}