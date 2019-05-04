package 哈希表和字符串;

import data.Hash;
import data.ListNode;

/**
 * Class 构造哈希表 ...
 *
 * @author LiJun
 * Created on 2019/5/3
 */
public class 构造哈希表 {
    public static void main(String[] args) {
        Hash hash = new Hash(11);
        int[] nums = {1, 1, 4, 9, 20, 30, 150, 500};
        for(int i = 0; i < nums.length; i++){
            hash.insert(new ListNode(nums[i]));
        }
        hash.print();
        System.out.println("开始查找：");
        for(int i = 0; i < 10; i++){
            if(hash.search(i)){
                System.out.println(i + " exist!");
            }else{
                System.out.println(i + " not exist!");
            }
        }
    }
}
