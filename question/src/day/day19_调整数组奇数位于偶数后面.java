package day;

import java.util.Arrays;

/**
 * Class day.day19_调整数组奇数位于偶数后面 ...
 *
 * @author LiJun
 * Created on 2019/2/14
 */
// 调整数组顺序是奇数位于偶数前面
public class day19_调整数组奇数位于偶数后面 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEvent(a);

        System.out.println(Arrays.toString(a));
    }
    public static void reorderOddEvent(int[] a){
        if(a == null || a.length == 0){
            return;
        }
        int start = 0;
        int end = a.length - 1;

        while(start < end){
            // 在这里我们首先要保证的是 start < end 而且 是奇数 如果是奇数 start指针向后移
            while(start < end && !isEvent(a[start])){
                start ++;
            }
            // 在这里我们首先要保证的是 start < end 而且 是奇数 如果是偶数 end指针向前移
            while(start < end && isEvent(a[end])){
                end --;
            }
            // 如果start指针指向奇数 end指针指向偶数，交换两个数
            if(start < end){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
    }
    // 单独抽象出来这个判断条件是为了解决这一系列的问题 不只是奇偶数
    public static boolean isEvent(int n){
        if((n & 1) != 0){
            return false;
        }
        return true;
    }

}
