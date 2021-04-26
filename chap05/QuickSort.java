package chap05;

public class QuickSort {
  /**
   * @param A: an integer array
   * @return: nothing
   */
  public void sortIntegers(int[] A) {
    // write your code here
    if (A==null || A.length == 0) {
      return;
    }
    quickSort(A, 0, A.length-1);
  }

  public void quickSort(int[] A, int start, int end) {
    if (start >= end) {
      return;
    }
    int left = start;
    int right = end;
    int pivot = A[(left + right)/2];
    // [start, right] < pivot
    // [left, end] > pivot
    while (left <= right) {
      // find first position A[left] >= pivot
      while (left <= right && A[left] < pivot) {
        left++;
      }
      // find first position A[right] <= pivot
      while (left <= right && A[right] > pivot) {
        right --;
      }
      if (left <= right) {
        int temp = A[right];
        A[right] = A[left];
        A[left] = temp;
        left++;
        right--;
      }
    }
    quickSort(A, start, right);
    quickSort(A, left, end);
  }
}
