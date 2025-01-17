package week01.array;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 816 👎 0

//[66]合并两个有序数组
// https://leetcode-cn.com/problems/plus-one/
public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度：O(m+n) 空间复杂度：O(m+n)
        // 或者可以将 nums1拷贝，空间复杂度为 O(m)
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] merged = new int[m+n];
            int ind1 = 0;
            int ind2 = 0;
            int ind = 0;
            while(ind1 < m && ind2 < n){
                if (nums1[ind1] <= nums2[ind2]){
                    merged[ind++] = nums1[ind1++];
                } else {
                    merged[ind++] = nums2[ind2++];
                }
            }
            while(ind1 < m){
                merged[ind++] = nums1[ind1++];
            }
            while(ind2 < n){
                merged[ind++] = nums2[ind2++];
            }
            System.arraycopy(merged,0,nums1,0,m+n);
        }
    }

    //双指针，从后往前
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int ind1 = m-1;
        int ind2 = n-1;
        int ind = m+n-1;
        while(ind1>=0 && ind2>=0){
            if(nums1[ind1] >= nums2[ind2]){
                nums1[ind--] = nums1[ind1--];
            } else {
                nums1[ind--] = nums2[ind2--];
            }
        }
        while(ind2>=0){
            nums1[ind--] = nums2[ind2--];
        }
    }
}
