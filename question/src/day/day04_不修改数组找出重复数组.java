package day;

/**
 * Class day.day04_不修改数组找出重复数组 ...
 *
 * @author LiJun
 * Created on 2018/12/19
 */

// 不修改数组找出重复的数字 数字从1开始

public class day04_不修改数组找出重复数组 {
    /***
     * 利用辅助数组来实现
     * @param arr 传入数组
     */
    public int getDuplication(int[] arr) {
        // 数组初始化全为0
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 参数的有效性检查
            if (arr[i] <= 0 || arr[i] >= arr.length) {
                throw new IllegalArgumentException("参数不正确");
            } else {
                if (newArr[arr[i]] == 0) {
                    newArr[arr[i]] = arr[i];
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        day04_不修改数组找出重复数组 test = new day04_不修改数组找出重复数组();
        int[] arr = {2,2,2,3,4,5};
        System.out.println(test.getDuplication2(arr));
    }

    public int getDuplication2(int[] arr) {
        // 参数有效性检查
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] >= arr.length) {
                throw new IllegalArgumentException("参数不正确");
            }
        }
        int start = 1;
        int end = arr.length - 1;
        while (end >= start) {
            // 计算出中间位置
            int middle = ((end - start) >> 1) + start;
            int count = countRange(arr, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }

        }
        return -1;
    }

    private int countRange(int[] arr, int start, int end) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
