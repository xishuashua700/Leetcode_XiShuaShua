package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SearchforaRange
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SearchforaRange {
    /**
     * 34. Search for a Range
     * Given an array of integers sorted in ascending order, find the starting and ending
     * position of a given target value.

     Your algorithm's runtime complexity must be in the order of O(log n).

     If the target is not found in the array, return [-1, -1].

     For example,
     Given [5, 7, 7, 8, 8, 10] and target value 8,
     return [3, 4].

     time : O(logn)
     space : O(1);
     * @param nums
     * @param target
     * @return
     */
    
    
    
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else { // 找左边，end >=
                end = mid;
            }
        }
        
        int left;
        if (nums[start] == target) {
            left = start;
        } else {
            return res;
        }
        
        start = left;
        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;  // !!! can't use "end = mid - 1", otherwise, in dead cycle
            } else { // 找右边， start include =
                start = mid + 1;
            } 
        }
        
        int right;
        if (nums[end] == target) {
            right = end;
        } else {
            right = end - 1;
        }
         

        res[0] = left;
        res[1] = right;
        
        return res;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = findFirst(nums, target);
        if (start == -1) return new int[]{-1, -1};
        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}
