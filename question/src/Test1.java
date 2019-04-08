import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Class Test1 ...
 *
 * @author LiJun
 * Created on 2019/3/24
 */
public class Test1 {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            int a = 1;
            int b = 1;

            for (int i = 2; i <= j; i++) {
                b = a + b;
                a = b - a;
            }
            System.out.println(b);
        }
    }
}
