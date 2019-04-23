package string;

import java.util.Arrays;

/**
 * Class KMP ...
 *
 * @author LiJun
 * Created on 2019/4/12
 */
public class KMP {
    private int[] next;

    /**
     * 在这里我们需要匹配的是 t 串中的 s的下标
     *
     * @param s 母串
     * @param p 子串
     * @return 索引
     */
    public int KMP_Index(String s, String p) {
        int i = 0;
        int j = 0;
        initNextVal(p);
        System.out.println(Arrays.toString(next));
        char[] source = s.toCharArray();
        char[] target = p.toCharArray();
        while (i < source.length && j < target.length){
            if(j == -1 || source[i] == target[j]){
                ++i;++j;
            }else {
                j = next[j];
            }
        }
        if(j == target.length){
            return i-j;
        }
        return -1;
    }

    /**
     * 计算 next 数组
     * @param t 传入值
     */
    private void initNext(String t) {
        next = new int[t.length()];
        int i = 0, k = -1;
        next[0] = -1;
        char[] str = t.toCharArray();
        while (i < t.length() - 1) {
            if (k == -1 || str[i] == str[k]) {
                ++k;
                ++i;
            }else{
                k = next[k];
            }
        }
    }
    private void initNextVal(String t) {
        next = new int[t.length()];
        int i = 0, k = -1;
        next[0] = -1;
        char[] str = t.toCharArray();
        while (i < t.length() - 1) {
            if (k == -1 || str[i] == str[k]) {
                ++k;
                ++i;
                if(str[i] != str[k]) {
                    next[i] = k;
                } else {
                    next[i] = next[k];
                }
            }else{
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.KMP_Index("ababaaabtaababaaaba", "ababaaaba"));
    }

}
