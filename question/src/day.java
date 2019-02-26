/**
 * Class day ...
 *
 * @author LiJun
 * Created on 2019/1/19
 */
public class day {

    private static double Power(double base, int exponent) {
        // 0 的0 次方没有意义
        if (base == 0 && exponent == 0) {
            return 0;
        }
        // 任何数的 0 次方 等于 1
        if (exponent == 0) {
            return 1;
        }
        // 指数小于0
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        return powerWithResult(base, exponent);
    }

    private static double powerWithResult(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithResult(base, exponent >> 1);
        result = result * result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Power(0, 0));
        System.out.println(Power(5, 0));
        System.out.println(Power(-5, -1));
        System.out.println(Power(5, -4));
    }
}
