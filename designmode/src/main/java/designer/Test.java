package designer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Class Test ...
 *
 * @author LiJun
 * Created on 2019/3/23
 */
public class Test {
    public void test(int[] arr, int[] num){


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= 0){
                map.put(arr[i], i);
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                if(map.containsKey((0-arr[i]))){
                    num[0] = map.get((0-arr[i]));
                    num[1] = i;
                }
            }
        }
    }
    public  static void quickSort(int[] arr, int start , int end){
        int left = start;
        int right = end;
        if(start >= end) return;
        int temp = arr[left];
        while(left <= right){
            while(left < right && arr[right] > temp){
                right--;
            }
            if(right < left){
                arr[left] = arr[right];
            }
            while(left < right && arr[left] < temp){
                left++;
            }
            if(right > left){
                arr[left] = arr[right];
            }
        }
        arr[left] = temp;
        quickSort(arr, start, left -1 );
        quickSort(arr, left, end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7, 1, 0};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
