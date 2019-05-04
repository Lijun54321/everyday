import java.util.Arrays;

/**
 * Class 归并排序 ...
 *
 * @author LiJun
 * Created on 2019/5/1
 */
public class 归并排序 {

    private static void mergeSortList(int[] array, int left, int mid, int right) {
        int[] result = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                result[t++] = array[i++];
            } else {
                result[t++] = array[j++];
            }
        }
        while (i <= mid) {
            result[t++] = array[i++];
        }
        while (j <= right) {
            result[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = result[t++];
        }
    }

    public static void sort(int[] array) {
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1);

    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            mergeSortList(array, start, mid, end);
        }
    }

    public static void main(String[] args) {

        int[] list1 = {1, 3, 5, 7, 9};
        int[] list2 = {2, 4, 6, 8};
        int[] result = new int[list1.length + list2.length];
        int[] array = {1, 3, 5, 9, 7, 2, 6, 8, 4, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
