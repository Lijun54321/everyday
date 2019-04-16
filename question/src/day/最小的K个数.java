package day;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class 最小的K个数 ...
 *
 * @author LiJun
 * Created on 2019/4/16
 */
public class 最小的K个数 {
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>(k);
            if(input.length < k || k == 0){
                return list;
            }
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
            for(int i = 0; i < input.length; i++){
                if(maxHeap.size() != k){
                    maxHeap.offer(input[i]);
                }else if(maxHeap.peek() > input[i]){
                    Integer temp = maxHeap.poll();
                    temp = null;
                    maxHeap.offer(input[i]);
                }
            }
            for(Integer integer : maxHeap){
                list.add(integer);
            }
            return list;
        }
    }

}
