package 搜索;

/**
 * Class 接雨水 ...
 *
 * @author LiJun
 * Created on 2019/5/4
 */
public class 接雨水 {
    static class Solution {
        /**
         * 思路：
         * 1，先找到数组中最大元素以及最大元素的位置；
         * 2，然后从最大元素位置处分开，从两端开始遍历；
         * 3，雨水存储是递增的，雨水量是遍历过程中数组大的元素减去小的元素的值的和；比如  [0,1,0,2,1,0,1,3,2,1,2,1]
         * 先找到最大值为3，位置为7，然后遍历左边，首先索引1处的值大，那么leftMax = 1,
         * 到索引2时变为0，那么面积area = 0 + 1 - 0=1；继续走，索引3的值2，大于1，
         * 这时就将leftMax=2，在索引4到6（包含）的值都比2小，所以面积就是
         * area = 1 + （2-1）+ （2-0）+（2-1）= 5；在走就到了7，也就是索引最大处，
         * 那么左端就遍历完成了，在遍历从数组最右端到7这一段，思路一致，就可以的到area=5+1=6；拿到结果；
         * 4，对特殊情况记得判断即可；
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }
            // 找出最大值和最大值的下标
            int max = height[0];
            int maxIndex = 0;
            for (int i = 1; i < height.length; i++) {
                maxIndex = height[i] > max ? i : maxIndex;
                max = height[i] > max ? height[i] : max;
            }
            int res = 0;
            for (int i = 0, root = height[0]; i < maxIndex; i++) {
                if (height[i] > root) {
                    root = height[i];
                } else {
                    res += root - height[i];
                }
            }

            for (int i = height.length - 1, root = height[height.length - 1]; i > maxIndex; i--) {
                if (height[i] > root) {
                    root = height[i];
                } else {
                    res += root - height[i];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */