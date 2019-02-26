import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class day03 ...
 *
 * @author LiJun
 * Created on 2018/12/18
 */
// 找出数组中的重复数字

public class day03 {

    /**
     * 首先我们最先想到的应该是将这个数组排序后如何遍历这个数组，然后检测出重复的数字
     * 时间复杂度为O(n^2)
     */
    public static void test() {
        int[] a = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                System.out.print(a[i] + " ");
                int j = i + 1;
                for (j = i + 1; j < n - 1; j++) {
                    if (a[j] != a[i]) {
                        break;
                    }
                }
                i = j - 1;
            }
        }
        System.out.println();

    }

    // 这是我利用java的hashSet实现的
    public static void test2(int[] a, int len) {

        HashSet hashSet = new HashSet();
        for (int i = 0; i < len; i++) {
            boolean add = hashSet.add(a[i]);
            if (add == false) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    // 但是我们能够利用哈希表的特性
    public static void main(String[] args) {

        int[] a = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // duplicate(a, n);
        test5(a, n);
    }

    public static void test3(int[] a, int len) {
        // 这个方法没有对数据的有效性进行检测，有需要的自己添加
        // 这个数组默认全为-1
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = -1;
        }
        // 循环遍历原数组,如果b[a[i]] 的位置存了数据不为-1的话 说明这个数在之前已经出现过了，所以重复
        for (int i = 0; i < len; i++) {
            if (b[a[i]] != -1) {
                System.out.println(a[i]);
            }
            b[a[i]] = a[i];
        }
        // 原理就是将这个数组中的每一个数依次放到对应位置上去，如果之前有了，那么就是重复，如果没有，那就放
    }

    public static boolean duplicate(int[] a, int len) {
        if (a == null || len <= 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            // 参数有效性检测
            if (a[i] < 0 || a[i] > len - 1) {
                return false;
            }
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    System.out.println(a[i]);
                    return true;
                } else {
                    int temp = a[i];
                    a[i] = a[temp];
                    a[temp] = temp;
                }
            }
        }
        return false;
    }

    public static void test5(int[] a, int len) {
        String string = Arrays.toString(a);

        for(int i = 0; i < len ; i++){
            if(string.indexOf(a[i]+"") != string.lastIndexOf(a[i]+"")){
                System.out.println(a[i]);
                return;
            }

        }
    }

}
