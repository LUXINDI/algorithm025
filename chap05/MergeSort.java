package chap05;

public class MergeSort {
  /**
   * @param A: an integer array
   * @return: nothing
   */
  public void sortIntegers(int[] A) {
    // write your code here
    if (A == null || A.length == 0) {
      return;
    }
    int[] temp = new int[A.length];
    mergeSort(A, 0, A.length-1, temp);
  }

  public void mergeSort(int[] A, int start, int end, int[] temp) {
    if (start >= end) return;
    int mid = (start + end)/2;
    mergeSort(A, start, mid, temp);
    mergeSort(A, mid+1, end, temp);

    // merge
    int leftidx = start;
    int rightidx = mid + 1;
    int idx = start;
    while (leftidx <= mid && rightidx <= end) {
      if (A[leftidx] <= A[rightidx]) {
        temp[idx++] = A[leftidx++];
      } else {
        temp[idx++] = A[rightidx++];
      }
    }

    while (leftidx <= mid) {
      temp[idx++] = A[leftidx++];
    }
    while (rightidx <= end) {
      temp[idx++] = A[rightidx++];
    }

    for (int i = start; i <= end; i++) {
      A[i] = temp[i];
    }
  }
}
