package chap05;

import java.util.Random;

public class QuickSelect2 {
  Random random = new Random();
  public int findKthLargest(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    while (true) {
      int ind = partition(nums, start, end);
      if (ind == k - 1)
        return nums[ind];
      else if (ind < k - 1) {
        start = ind + 1;
      } else {
        end = ind - 1;
      }
    }
  }

  public int partition(int[] nums, int start, int end) {
    if (start < end) {
      int pivotIdx = start + random.nextInt(end - start + 1);
      swap(nums, start, pivotIdx);
    }
    int pivot = nums[start];
    int left = start + 1;
    int right = end;
    // [start+1, right) >= pivot
    // (left, end] <= pivot
    while (left <= right) {
      // find first position <= pivot
      // [start+1, left) > pivot
      while (left <= right && nums[left] > pivot) {
        left++;
      }
      // find first position >= pivot
      // (right, end] < pivot
      while (left <= right && nums[right] < pivot) {
        right--;
      }
      if (left <= right) {
        swap(nums, left, right);
        left++;
        right--;
      }
    }
    swap(nums, start, right);
    return right;
  }

  public void swap(int[] nums, int ind1, int ind2) {
    int temp = nums[ind1];
    nums[ind1] = nums[ind2];
    nums[ind2] = temp;
  }
}
