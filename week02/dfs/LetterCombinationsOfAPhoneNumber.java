package week02.dfs;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1248 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Map<Character,String> map = new HashMap<Character,String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        public List<String> letterCombinations(String digits) {
            //注意输入为""， 直接返回，而不是返回 [""]
            if (digits == null || digits.length() == 0) return results;
            dfs(digits, 0);
            return results;
        }
        public void dfs(String digits, int index){
            if(index == digits.length()){
                results.add(sb.toString());
                return;
            }
            char alpha = digits.charAt(index);
            for (char c: map.get(alpha).toCharArray()){
                sb.append(c);
                dfs(digits, index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
