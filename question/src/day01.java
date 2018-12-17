import java.util.Scanner;

/**
 * Class day01 ...
 *
 * @author LiJun
 * Created on 2018/12/17
 */

//如何快速的判断一个数是否是偶数

public class day01 {
    /**
     * 取余法实现
     */
    public void test(){
        int n;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            n = scanner.nextInt();
            if (n % 2 == 0) {
                System.out.println(n + "是偶数");
            } else {
                System.out.println(n + "是奇数");
            }
        }
    }

    /**
     * 高效的位运算实现
     */
    public void test2(){
        int n;
        Scanner scanner = new Scanner(System.in);
        while(true){
            n = scanner.nextInt();
            if((1&n) == 0){
                System.out.println(n + "是偶数");
            }else{
                System.out.println(n + "是奇数");
            }
        }
    }
}
