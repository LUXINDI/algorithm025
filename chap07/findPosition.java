package chap07;


public class findPosition {

  /**
   * @param nums:   An integer array sorted in ascending order
   * @param target: An integer
   * @return: An integer
   */
  public int findPosition(int[] nums, int target) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public int binarySearch(int[] nums, int start, int end, int target) {
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] < target) {
        start = mid + 1;
      }
      if (nums[mid] > target) {
        end = mid - 1;
      }
    }
    if (nums[start] == target) return start;
    return -1;
  }
}
