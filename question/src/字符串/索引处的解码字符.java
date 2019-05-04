package 字符串;

/**
 * Class 索引处的解码字符 ...
 *
 * @author LiJun
 * Created on 2019/4/15
 */
public class 索引处的解码字符 {

    static class Solution {
        /**
         * 结果一定在S中，因此我们没有必要把S展开再求。
         * 而且这样做(当测试样例"y959q969u3hb22odq595")会出现内存溢出的现象。
         * 因此可以想办法在原始S中求第K为，1.算出展开S的长度为N，2所求位置为k%S。
         * 因此倒序遍历S，遇见数字N=N/d，遇见字母N=N-1;直到K%N==0。输出此处字符
         *
         * @param S
         * @param K
         * @return
         */
        public String decodeAtIndex(String S, int K) {
            long size = 0;
            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i))) {
                    size *= S.charAt(i) - '0';
                } else {
                    size++;
                }
            }
            for (int i = S.length() - 1; i >= 0; i--) {
                char c = S.charAt(i);
                K %= size;
                if (K == 0 && Character.isLetter(c)) {
                    return Character.toString(c);
                }
                if (Character.isDigit(c)) {
                    size /= c - '0';
                } else {
                    size--;
                }
            }
            return null;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.decodeAtIndex("moi86723j4", 22912));
        // System.out.println(solution.decodeAtIndex("ha22", 5));
        // System.out.println(solution.decodeAtIndex1("ha22", 5));

    }
}
