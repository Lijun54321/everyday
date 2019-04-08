import java.util.Arrays;

/**
 * Class QuickSort ...
 *
 * @author LiJun
 * Created on 2019/3/23
 */
public class QuickSort {
    private static void quickSort(int[] a, int start, int end) {
        int left = start;
        int right = end;
        int temp = a[left];
        if (left >= right) {
            return;
        }
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            if (left < right) {
                a[left] = a[right];
            }
            while (left < right && a[left] <= temp) {
                left++;
            }
            if (left < right) {
                a[right] = a[left];
            }
        }
        a[left] = temp;
        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }

    private static boolean test(int[] arr, int[] num) {
        int start = 0, end = arr.length - 1;
        // 边界判断
        if (arr[0] > 0 || arr[end] < 0) {
            return false;
        }

        while (start < end) {
            if ((0 - arr[start]) == arr[end]) {
                num[0] = arr[start];
                num[1] = arr[end];
                return true;
            }
            if ((0 - arr[start]) > arr[end]) start++;
            if ((0 - arr[start]) < arr[end]) end--;
        }
        return false;

    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2};
        int[] num = {-1, -1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

        test(arr, num);
        System.out.println(Arrays.toString(num));
        StringBuilder stringBuilder = new StringBuilder();
    }

}