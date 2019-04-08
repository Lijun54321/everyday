package Solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Main5 ...
 *
 * @author LiJun
 * Created on 2019/3/23
 */
public class Main5 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


        Integer[] ts = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(ts));
    }
}
