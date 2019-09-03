class Solution {
    public int findKthLargest(int[] nums, int k) {
        return help(nums, 0, nums.length - 1, k);
    }

    private int help(int[] nums, int l, int r, int k) {
        int s = l, e = r;
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] >= pivot) {
                --e;
            }
            if (s < e) {
                nums[s] = nums[e];
            }

            while (s < e && nums[s] <= pivot) {
                ++s;
            }
            if (s < e) {
                nums[e] = nums[s];
            }
        }

        nums[s] = pivot;
        if (nums.length - s == k) {
            return nums[s];
        } else if (nums.length - s > k) {
            return help(nums, s + 1, r, k);
        } else {
            return help(nums, l, s - 1, k);
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