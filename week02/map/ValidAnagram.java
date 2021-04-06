package week02.map;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 366 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) return false;
            Map<Character,Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            for(char c : t.toCharArray()){
                int cnt = map.getOrDefault(c,0) - 1;
                if(cnt<0) return false;
                map.put(c, cnt);
            }
            return true;
        }

        public boolean isAnagram2(String s, String t) {
            if(s.length()!=t.length()) return false;
            int[] table = new int[26];
            for(char c : s.toCharArray()){
                table[c-'a'] ++;
            }
            for(char c : t.toCharArray()){
                table[c-'a'] --;
                if(table[c-'a']<0) return false;
            }
            return true;
        }

        //排序
        public boolean isAnagram3(String s, String t) {
            if (s.length()!=t.length()) return false;
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            Arrays.sort(schar);
            Arrays.sort(tchar);
            return Arrays.equals(schar, tchar);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
