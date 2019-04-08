package day;

/**
 * Class day.day17_二进制中1的个数 ...
 *
 * @author LiJun
 * Created on 2019/1/11
 */
public class day17_二进制中1的个数 {
    private static int solution(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static int NumberOf1Solution2(int n) {
        int count = 0;
        int flag = 1;
        while (flag >= 1) {
            if ((n & flag) > 0) {
                count++;
            }

            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(solution(-1));
    }

}
