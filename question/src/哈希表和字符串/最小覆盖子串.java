package 哈希表和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * Class 最小覆盖子串 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 最小覆盖子串 {
    static class Solution {
        public String minWindow(String s, String t) {
            // 记录t字符串各字符的个数
            int[] hashS = new int[128];
            // 记录s字符串个字符的个数
            int[] hashT = new int[128];
            // 更新t中的数据
            for (int i = 0; i < t.length(); i++) {
                hashT[t.charAt(i)]++;
            }
            // 将t中出现的字符，放入到list 中
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 128; i++) {
                if (hashT[i] > 0) {
                    list.add(i);
                }
            }

            int begin = 0;
            // 存储结果
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                hashS[s.charAt(i)]++;
                // 尝试移动begin
                while (begin < i) {
                    char c = s.charAt(begin);
                    // 如果不能匹配t中的，那就可以直接移动
                    if (hashT[c] == 0) {
                        begin++;
                    } else if (hashS[c] > hashT[c]) {
                        // 如果在后面的序列中出现达到了次数，俺就可以继续后移
                        hashS[c]--;
                        begin++;
                    } else {
                        // 不满足，那就不移
                        break;
                    }
                }
                // 这里判断是否满足result中含有 t 中所有
                if (isWindowOk(hashS, hashT, list)) {
                    int newWindowLen = i - begin + 1;
                    if (result == "" || result.length() > newWindowLen) {
                        // 划分字符串
                        result = s.substring(begin, i + 1);
                    }
                }
            }
            return result;
        }

        private boolean isWindowOk(int[] s, int[] t, List<Integer> list) {
            for (int i = 0; i < list.size(); i++) {
                if (s[list.get(i)] < t[list.get(i)]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
/*
给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

 */