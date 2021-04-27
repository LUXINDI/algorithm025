package chap05;

public class MontainSequence2 {
  /**
   * @param nums: a mountain sequence which increase firstly and then decrease
   * @return: then mountain top
   */
  public int mountainSequence(int[] nums) {
    // write your code here
    // find first position nums[i] > nums[i+1]
    if (nums == null || nums.length == 0) return -1;
    if (nums.length == 1) return nums[0];
    int n = nums.length;
    int start = 0;
    int end = n - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      // mid是偏左的，所以mid+1一定有
      if (nums[mid] > nums[mid + 1]) {
        end = mid;
      }
      if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      }
    }
    return Math.max(nums[start], nums[end]);
  }
}
