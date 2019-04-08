package day;

/**
 * Class day.day16_剪绳子_贪心 ...
 *
 * @author LiJun
 * Created on 2019/1/11
 */
public class day16_剪绳子_贪心 {
    public static int maxProductAfterCutting_solution(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 尽可能多去剪长度为3的绳子
        int timesOf3 = length / 3;
        // 当最后剩下偿付为4 的时候，不能再剪长度为3 的绳子段了
        // 此时最好剪成 长度为 2 的两段，因为 2 * 2  > 3 * 1
        if(length - timesOf3*3 == 1){
            timesOf3 --;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int)Math.pow(3, timesOf3) * (int ) Math.pow(2, timesOf2);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(maxProductAfterCutting_solution(i));
        }
    }

}
