package day;

/**
 * Class 判断一个整数序列是不是二叉搜索树的后序序列 ...
 *
 * @author LiJun
 * Created on 2019/4/15
 */
public class 判断一个整数序列是不是二叉搜索树的后序序列 {
    public class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence.length == 0) {
                return false;
            }
            return IsTreeBST(sequence, 0, sequence.length - 1);
        }

        public boolean IsTreeBST(int[] sequence, int start, int end) {
            if (end <= start) {
                return true;
            }
            int i = start;
            for (; i < end; i++) {
                if (sequence[i] > sequence[end]) {
                    break;
                }
            }
            for (int j = i; j < end; j++) {
                if (sequence[j] < sequence[end]) {
                    return false;
                }
            }
            return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);
        }
    }
}
