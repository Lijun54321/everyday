import java.util.Scanner;

/**
 * Class isElseTest ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class isElseTest {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        if (a == 1){
            System.out.println(1);
        }else if (a == 2){
            System.out.println(2);
        }else if(a == 3){
            System.out.println(3);
        }else if(a == 4){
            System.out.println(4);
        }else if(a == 5){
            System.out.println(5);
        }else {
            System.out.println("else");
        }
    }
}
