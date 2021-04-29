package chap07;

public class lastPosition {
  public int findLastPosition(int[] nums, int target) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        start = mid;
      }
      if (nums[mid] < target) {
        start = mid + 1;
      }
      if (nums[mid] > target) {
        end = mid - 1;
      }
    }
    if (nums[end] == target) return end;
    if (nums[start] == target) return start;
    return -1;
  }
}
