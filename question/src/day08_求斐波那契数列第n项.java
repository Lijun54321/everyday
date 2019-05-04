import java.math.BigInteger;

/**
 * Class day.day08_求斐波那契数列第n项 ...
 *
 * @author LiJun
 * Created on 2018/12/23
 */
// 求斐波那契数列的第n项
public class day08_求斐波那契数列第n项 {

    // 递归实现，但是没意思，复杂了
    public long Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public long Fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long a = 0;
        long b = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public BigInteger Fibonacci3(int n) {
        if (n <= 0) {
            return new BigInteger("0");
        }
        if (n == 1) {
            return new BigInteger("1");
        }
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger result = new BigInteger("0");
        for (int i = 2; i <= n; i++) {
            result = a.add(b);
            a = b;
            b = result;

        }
        return result;
    }

    public static void main(String[] args) {
        day08_求斐波那契数列第n项 day = new day08_求斐波那契数列第n项();
        long start = System.currentTimeMillis();
        System.out.println(day.Fibonacci(43));
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
        /*代码实验 当递归到40以上 就已经很慢了*/

        start = System.currentTimeMillis();
        System.out.println(day.Fibonacci2(92));
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));

        start = System.currentTimeMillis();
        System.out.println(day.Fibonacci3(100));
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));

        /*
          理论上java的long可以存92的斐波那契数 -2^63~2^63-1
         */
        /*
        输出结果如下：
            433494437
            用时：3475
            7540113804746346429
            用时：0
            354224848179261915075
            用时：2

        */
    }
}
