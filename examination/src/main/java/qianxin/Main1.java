package qianxin;

import java.util.Scanner;

/**
 * Class Main1 ...
 * 字符串转整数
 * @author LiJun
 * Created on 2019/4/24
 */
public class Main1 {
    private static long string2int(String str) {
        if (str == null || str.length() <= 0 || !isNum(str)) {
            return 0;
        }
        int n = 0;
        boolean flag = false;
        char[] nums = str.toCharArray();

        int i = 0;
        if (nums[0] == '-') {
            flag = true;
            i++;
        }
        long res = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == '.') {
                break;
            }
            res = res * 10 + (nums[i] - '0');
        }
        return flag ? 0 - res : res;
    }

    private static boolean isNum(String str) {
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                continue;
            }
            if(str.charAt(i) == '-' || str.charAt(i) == '.'){
                continue;
            }
            return false;
        }
        if(str.length() > 1) {
            if (str.charAt(0) == '.' || (str.charAt(0) == '-' && str.charAt(1) == '.')) {
                return false;
            }
        }
        if(str.contains("-") && str.lastIndexOf("-") != 0){
            return false;
        }
        if(str.contains(".") && str.indexOf(".") != str.lastIndexOf(".")){
            return false;
        }
        if(str.charAt(str.length()-1) == '.'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        while(true) {
            String _str = in.nextLine();
            System.out.println(string2int(_str));
        }
    }
}
