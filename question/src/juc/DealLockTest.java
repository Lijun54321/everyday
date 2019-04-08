package juc;

/**
 * Class DealLockTest ...
 *
 * @author LiJun
 * Created on 2019/3/6
 */
public class DealLockTest {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println("I'm thread1, and I have got A, I will try to got B!");
                    try {
                        Thread.sleep(20000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("I'm thread1, and I have got B!");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println("I'm thread2, and I have got B, I will try to got A!");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (A) {
                        System.out.println("I'm Thread2, and I have got A!");
                    }
                }
            }
        });

        thread1.start();

        thread2.start();


    }
}
