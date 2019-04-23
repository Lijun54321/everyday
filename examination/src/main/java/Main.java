import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        if(m >= n) {
            System.out.println(k);
        } else {
            long t = n * k / m + (n * k % m != 0 ? 1 : 0);
            System.out.println(t);
        }
    }
}
