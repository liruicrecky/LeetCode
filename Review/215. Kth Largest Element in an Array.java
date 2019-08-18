class Solution {
    public int findKthLargest(int[] nums, int k) {
        return help(nums, k, 0, nums.length - 1);
    }

    private int help(int[] nums, int k, int l, int r) {
        int s = l, e = r;
        int privot = nums[s];
        while (s < e) {
            while (s < e && nums[e] > privot) {
                --e;
            }
            if (s < e) {
                nums[s++] = nums[e];
            }

            while (s < e && nums[s] < privot) {
                ++s;
            }
            if (s < e) {
                nums[e--] = nums[s];
            }
        }
        nums[s] = privot;
        if (nums.length - s == k) {
            return nums[s];
        } else if (nums.length - s > k) {
            return help(nums, k, s + 1, r);
        } else {
            return help(nums, k, l, s - 1);
        }
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k);
        for (int num : nums) {
            que.offer(num);
            if (que.size() > k) {
                que.poll();
            }
        }

        return que.poll();
    }
}