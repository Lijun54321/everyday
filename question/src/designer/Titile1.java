package designer;

import java.util.Scanner;

/**
 * Class Titile1 ...
 *
 * @author LiJun
 * Created on 2019/3/22
 */
public class Titile1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int count = 0;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int i =  n; i <= m; i++){
                int a = i%10;
                int b = (i/10)%10;
                int c = i/10/10;
                if(i == a*a*a + b*b*b + c*c*c){
                    System.out.print(i + " ");
                    count ++;
                }
            }
            if(count == 0){
                System.out.print("no");
            }
            System.out.println();
        }
    }
}
