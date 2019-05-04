package 字符串;

/**
 * Class day.字符串.day06_替换空格 ...
 *
 * @author LiJun
 * Created on 2018/12/22
 */
// 替换空格

public class day06_替换空格 {

    /**
     * 遍历知道出这个字符串的空格数
     *
     * @param string 目的字符串
     * @return int 空格数
     */
    public int blankSum(String string) {

        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (" ".equals(String.valueOf(string.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 转换空格并输出
     * @param string
     */
    public void replaceBlank(String string) {
        // 参数有效性检查
        if (string == null || string.length() <= 0) {
            System.out.println("参数错误！");
            return;
        }
        int orignLength = string.length();
        // 加长后的字符串长度
        int newStringLength = orignLength + blankSum(string)*2;
        char[] array = new char[newStringLength];
        System.arraycopy(string.toCharArray(), 0, array,0, string.toCharArray().length);

        int indexOfOriginal = orignLength-1;
        int indexNew = newStringLength-1;
        while(indexOfOriginal >= 0 && indexNew > indexOfOriginal){
            if(array[indexOfOriginal] == ' '){
                array[indexNew --] = '0';
                array[indexNew --] = '2';
                array[indexNew --] = '%';
            }else {
                array[indexNew--] = array[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        string = new String(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        return string.replaceAll(" ", "%20");

    }

    public static void main(String[] args) {
        day06_替换空格 day06 = new day06_替换空格();
        String string = "we are people!";
        day06.replaceBlank(string);
        System.out.println(string);
        String string1 = string.replace(" ", "%20");
        // 恶补下知识
        // java中 字符串的替换函数 replaceAll 和 replaceFirst 使用到了正则表达式
        // 但是 replace 没有使用正则表达式
        System.out.println(string1);
    }

}

