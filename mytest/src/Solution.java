/**
 * Class Solution ...
 *
 * @author LiJun
 * Created on 2019/3/7
 */
public strictfp class Solution {

    /*public static void changeStringBuffer(StringBuffer ss1,
                                          StringBuffer ss2) {
        ss1.append(" world");
        ss2 = ss1;
    }
    public static void main(String[] args) {
        // 包装类是不可变类
        Integer a = 1;
        Integer b = a;
        b++;
        System.out.println(a);
        System.out.println(b);
        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        changeStringBuffer(s1, s2);
        System.out.println(s1);
        System.out.println(s2);
    }*/

    static {
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        System.out.println("mane");
        byte a = 5;
        int b = 5;
        int c = a >> 2 + b >> 2;
        System.out.println(c);

        short d = 5;
        short e = 5;
        e = (short) (d + e);
    }
}
