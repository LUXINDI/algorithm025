package week02.map;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 705 👎 0

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {

        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] chararr = str.toCharArray();
                Arrays.sort(chararr);
                StringBuilder sb = new StringBuilder();
                String keyStr = sb.append(chararr).toString();
                if(!map.containsKey(keyStr)){
                    map.put(keyStr, new ArrayList<>());
                }
                map.get(keyStr).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
