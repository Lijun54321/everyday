package reverse;

/**
 * Class StringReverse ...
 *
 * @author LiJun
 * Created on 2019/3/31
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "javad test12 df";
        System.out.println(reverseStringWithStringBuffer(str));
        System.out.println(reverseStringWithArrays(str));
    }

    /**
     * 利用StringBuffer(StringBuilder) 的 reverse函数解决
     *
     * @param str 要反转的字符串
     * @return result
     */
    private static String reverseStringWithStringBuffer(String str) {
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i  = s.length - 1; i > -1; i--){
            stringBuilder.append(s[i]);
            if(i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 转换成字符数组来反转
     *
     * @param str 字符串
     * @return result
     */
    private static String reverseStringWithArrays(String str) {
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i > (chars.length - 1) / 2; i--) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }


}
