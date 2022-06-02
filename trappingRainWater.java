/*
Problem: https://leetcode.com/problems/trapping-rain-water/
*/
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        
        while(left < right) {
            // System.out.println("L: " + left + ", R: " + right);
            if(height[left] <= height[right]) {
               if(height[left] >= leftMax) {
                    leftMax = height[left];
                    // System.out.println("Updating leftMax: " + leftMax);
                   
                } else {
                   // We know we will trap at least this much water becasuse there is a right wall which is taller than left wall
                    res += leftMax - height[left];
                   // System.out.println("leftMax: " + leftMax + ", height[left]: " + height[left] + ", res: " + res);
                }
                ++left; 
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                    // System.out.println("Updating rightMax: " + rightMax);
                } else {
                    // We know we will trap at least this much water becasuse there is a left wall which is taller than right wall
                    res += rightMax - height[right];
                   // System.out.println("rightMax: " + rightMax + ", height[right]: " + height[right] + ", res: " + res);
                    
                }
                --right;
            }
            
        }
        
        return res;
    }
}