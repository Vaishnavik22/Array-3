/*
Problem: 
*/

// Approach 1
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int n = nums.length;
        if (k > n) k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            ++startIndex; --endIndex;
        }
    }
}

// Approach 2
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int swapped = 0;
        
        for (int startIndex = 0; swapped < n; ++startIndex) {
            int curIndex = startIndex;
            int curElement = nums[curIndex];
            
            do {
                int nextIndex = (curIndex + k) % n;
                int temp = nums[nextIndex];
                nums[nextIndex] = curElement;
                curElement = temp;
                curIndex = nextIndex;
                ++swapped;
            } while (curIndex != startIndex);
        }
    }
}