package week01.queue;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 221 👎 0

import java.util.PriorityQueue;
import java.util.Random;

public class GetLeastKNumbers {
    public static void main(String[] args) {
        Solution solution = new GetLeastKNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //时间复杂度：O(nlog(k)) 每次插入删除O(logk)
        //空间复杂度: O(k)
        Random random = new Random();
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b)->a-b);
            for(int num: arr){
                minHeap.add(num);
            }
            int[] res = new int[k];
            for(int i=0;i<k;i++){
                res[i] = minHeap.poll();
            }
            return res;
        }

        public int[] getLeastNumbers2(int[] arr, int k){
            //注意要考虑k==0的情况
            if(k==0) return new int[0];
            int left = 0;
            int right = arr.length-1;
            int[] res = new int[k];
            while(true){
                int ind = partition(arr,left,right);
                if(ind==k-1) {
                    System.arraycopy(arr,0,res,0,k);
                    return res;
                } else if(ind>k-1){
                    right = ind-1;
                } else{
                    left = ind+1;
                }
            }
        }

        public int partition(int[] nums, int left, int right){
            if(left<right){
                int randomind = left + random.nextInt(right-left+1);
                swap(nums, left, randomind);
            }
            int pivot = nums[left];
            // <pivot [left+1,j]
            // >=pivot (j,right]
            int j = left;
            for(int i=left+1;i<=right;i++){
                if(nums[i]<pivot){
                    j++;
                    swap(nums,i,j);
                }
            }
            swap(nums,left,j);
            return j;
        }

        public void swap(int[] nums, int ind1, int ind2){
            int temp = nums[ind1];
            nums[ind1] = nums[ind2];
            nums[ind2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
