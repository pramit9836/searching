package interview.learling.seraching.binarysearch.problems;

/**
 * @author pramitk
 * @project searching
 * @date 19/01/23
 */

/**
 * Problem Statement: Search in Rotated Sorted Array
 * Problem link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,8,9,0,1,2};
        int target = 9;
        System.out.println(findTargetWithRecursion(nums, target, nums.length-1, 0));
        System.out.println(findTargetWithLoop(nums, target));


    }

    public static int findTargetWithRecursion(int[] nums, int target, int high, int low) {
        
        if (low >  high)  return -1;
        
        else {
            int mid = (high + low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[low] < nums[mid]) {
                if (nums[low] <= target && nums[mid] > target)  {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                return findTargetWithRecursion(nums, target, high, low);
            } else {

                if (nums[mid] >= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                return findTargetWithRecursion(nums, target, high, low);
            }
        }
    }

    public static int findTargetWithLoop(int[] nums, int target) {

        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid =  (low + high) / 2;
            if (nums[mid] == target) return mid;

            // left side is sorted
            if (nums[low] <= nums[mid]) {
                //check if element lies in left half or not, if yes then eliminate right half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right side is sorted
                //check if element lies in right half or not, if yes then eliminate left half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
