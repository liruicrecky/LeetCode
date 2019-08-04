class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return res;
        }
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == left) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    ++l;
                    --r;
                } else if (sum > left) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    --r;
                } else {
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    ++l;
                }
            }
        }
        
        return res;
    }
}