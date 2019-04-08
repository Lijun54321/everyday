import java.math.BigInteger;

/**
 * Class search.Division ...
 *
 * @author LiJun
 * Created on 2019/3/24
 */
public class Division {

    private static int division(int[] arr, int k) {
        if (arr == null || arr.length < 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int[] arr = {2, 4, 6, 8, 9};
        for (int i = 1; i < 10; i++) {
            System.out.println(division(arr, i));
        }*/

        toN(2);
    }

    private static BigInteger toN(int n) {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9 * i; j++) {
                bigInteger = bigInteger.add(bigInteger1);
                System.out.println(bigInteger);
                break ;
            }
        }
        return bigInteger;
    }

}
