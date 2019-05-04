import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class 重复DNA序列 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class leetCode187_重复DNA序列 {
    class Solution {
        /**
         * 两个hashset做
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> set = new HashSet<>();
            Set<String> help = new HashSet<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String cur = s.substring(i, i + 10);
                if (!set.add(cur)) {
                    help.add(cur);
                }
            }
            return new ArrayList<>(help);
        }
    }

}
/*
所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。

示例:

输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

输出: ["AAAAACCCCC", "CCCCCAAAAA"]

 */