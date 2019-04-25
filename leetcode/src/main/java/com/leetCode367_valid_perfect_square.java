package com;

/**
 * Class leetCode367_valid_perfect_square ...
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @author LiJun
 * Created on 2019/4/23
 */
public class leetCode367_valid_perfect_square {
    class Solution {
        public boolean isPerfectSquare1(int num) {
            int sum = 1;
            while (num > 0) {
                num -= sum;
                sum += 2;
            }
            return num == 0;
        }
        public boolean isPerfectSquare(int num) {
            int min = 0;
            int max = num;
            while (min <= max) {
                int mid = (min + max) >> 1;
                if (mid == num * 1.0 / mid) {
                    return true;
                } else if (mid > num * 1.0 / mid) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return false;
        }
    }
}
