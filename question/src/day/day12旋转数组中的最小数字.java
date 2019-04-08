package day;

/**
 * Class day.day12旋转数组中的最小数字 ...
 *
 * @author LiJun
 * Created on 2018/12/28
 */
// 旋转数组
public class day12旋转数组中的最小数字 {
    public static int Min(int[] numbers) {
        // 参数有效性验证
        if (numbers == null || numbers.length <= 0) {
            return Integer.MIN_VALUE;
        }
        // 二分法的基本实现就是一个指向头 一个指向尾
        int start = 0;
        int end = numbers.length - 1;
        // 设置medium的原因是一旦数组中的第一个数字 小于最后一个数字，说明这个数组是排序的
        // 直接返回第一个数字就行
        int medium = start;
        while (numbers[start] >= numbers[end]) {
            // 如果start 和 end 执行相邻的数字
            // 则 start 执行第一个递增数列的最后一个数字
            // end 指向第二个递增数列的第一个数字
            if (end - start == 1) {
                medium = end;
                break;
            }
            medium = (start + end) / 2;
            // 这里是特殊情况 如果这三者相等的话，就只能老老实实的顺序查找了
            if(numbers[start] == numbers[medium] && numbers[medium]  == numbers[end]){
                return GetMinInOrder(numbers, start, end);
            }
            if(numbers[medium] >= numbers[end]){
                start = medium;
            }else if(numbers[medium] <= numbers[end]){
                end = medium;
            }
        }
        return numbers[medium];
    }

    public static int GetMinInOrder(int[] numbers, int start, int end) {
        int min = numbers[start];
        for(int i = start+1; i <= end; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // 基础测试
        int[] numbers = {3,4,5,1,2};
        System.out.println(Min(numbers));
        numbers = new int[]{1, 0, 1, 1, 1};
        System.out.println(Min(numbers));
    }
}
