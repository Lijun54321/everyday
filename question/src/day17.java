import com.sun.org.apache.xpath.internal.operations.Number;

/**
 * Class day17 ...
 *
 * @author LiJun
 * Created on 2019/1/11
 */
public class day17 {
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
            System.out.println("flag=" + flag);
        }

        return count;
    }

    public static int NumberOf1Solution3(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

    public static void main(String[] args) {/*
        for (int i = 0; i <= 20; i++) {
            System.out.print(NumberOf1Solution2(i) + " ");
        }*/
        System.out.println(NumberOf1Solution3(-1));
    }

}
