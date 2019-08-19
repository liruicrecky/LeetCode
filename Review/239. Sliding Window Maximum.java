class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!que.isEmpty() && que.peek() < i - k + 1) {
                que.poll();
            }

            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) {
                que.pollLast();
            }

            que.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[que.peek()];
            }
        }

        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[0];
        }

        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = nums[0];
        rightMax[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
            int j = len - i - 1;
            rightMax[j] = j % k == 0 ? nums[j] : Math.max(rightMax[j + 1], nums[j]);
        }

        int[] res = new int[len - k + 1];
        for (int i = 0, j = 0; i <= len - k; i++) {
            res[j++] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }

        return res;
    }
}