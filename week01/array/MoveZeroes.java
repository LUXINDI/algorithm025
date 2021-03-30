package week01.array;
public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int i=0;
            // find first number that equals 0
            while(i<nums.length&&nums[i]!=0){
                i++;
            }
            if(i>=nums.length) return;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]!=0 && i!=j && nums[i]==0){
                    swap(nums,i,j);
                    i++;
                }
            }

        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
