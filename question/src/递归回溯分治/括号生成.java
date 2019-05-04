package 递归回溯分治;

import java.util.LinkedList;
import java.util.List;

/**
 * Class 括号生成 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class 括号生成 {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<>();
            generate("", n, n, result);
            return result;
        }

        private void generate(String item, int left, int right, List<String> result) {
            if (left == 0 && right == 0) {
                result.add(item);
                return;
            }
            if (left > 0) {
                generate(item + "(", left - 1, right, result);
            }
            if (left < right) {
                generate(item + ")", left, right - 1, result);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String s : solution.generateParenthesis(2)) {
            System.out.println(s);
        }
    }
}

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */