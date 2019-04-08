package designer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Solution {
    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) return array[0];
        int start = 0, mid = array.length / 2, end = array.length - 1;
        boolean flag = false;
        int count = 0;
        while (!flag) {
            if (array[mid] == k) {
                int temp = mid;
                while (array[temp--] == k) count++;
                while (array[temp++] == k) count++;
            }
/*
            // 处理降序结果
            if(array[start] <= array[end]){
                if()
            }
            if(array[mid] > k){
                start =
            }*/
        }
        return 0;
    }


    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        int flag = 1;
        while ((result & flag) == 0) {
            flag = flag << 1;
        }
        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.FirstNotRepeatingChar("google"));
        int[] array = {0, 1, 1, 2, 1, 2, 1, 3, 4, 0};
        solution.FindNumsAppearOnce(array, array, array);
    }

    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == str.indexOf(chars[i]) && i == str.lastIndexOf(chars[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] result = new int[index];
        result[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        for (int i = 1; i < index; i++) {
            int min = result[m2] * 2 < result[m3] * 3 ? result[m2] * 2 : result[m3] * 3;
            min = min < result[m5] * 5 ? min : result[m5] * 5;
            if (min >= result[m2] * 2) {
                m2++;
            }
            if (min >= result[m3] * 3) {
                m3++;
            }
            if (min >= result[m5] * 5) {
                m5++;
            }
            result[i] = min;
        }
        return result[index - 1];
    }


    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        if (min.isEmpty() || node < min.peek()) {
            min.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (min.peek().equals(stack.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}