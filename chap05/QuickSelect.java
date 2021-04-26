package chap05;

import java.util.Random;

public class QuickSelect {
  Random random = new Random();
  public int findKthLargest(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    while(true) {
      int ind = helper(nums, start, end);
      if (ind == k - 1) {
        return nums[ind];
      } else if (ind < k - 1) {
        start = ind + 1;
      } else { // ind > k - 1
        end = ind - 1;
      }
    }
  }

  public int helper(int[] nums, int start, int end) {
    if (start <= end) {
      int pivotidx = start + random.nextInt(end - start + 1);
      swap(nums, start, pivotidx);
    }
    int pivot = nums[start];
    int j = start;
    // [start+1,j] >= pivot
    // (j, end] < pivot
    for (int i = start + 1; i <= end; i++) {
      if (nums[i] >= pivot) {
        j++;
        swap(nums, j, i);
      }
    }
    swap(nums, start, j);
    // [start, j)>=pivot j==pivot (j,end] < pivot
    return j;
  }

  public void swap(int[] nums, int ind1, int ind2) {
    int temp = nums[ind1];
    nums[ind1] = nums[ind2];
    nums[ind2] = temp;
  }
}
