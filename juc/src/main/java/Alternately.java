import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Alternately ...
 *
 * @author LiJun
 * Created on 2019/3/14
 */
class Print implements Runnable {
    private volatile Integer i;
    ReentrantLock lock ;
    public Print() {
        i = 1;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        while (i <= 100) {
            // lock.lock();


            while(Integer.parseInt(Thread.currentThread().getName().substring(6, 7)) == i%2 ){}


                System.out.println(Thread.currentThread().getName() + " " + i++);

            // lock.unlock();

        }
    }
}

public class Alternately {


    public static void main(String[] args) {
        Print print = new Print();
        Thread thread1 = new Thread(print);
        thread1.setName("Thread1");
        Thread thread2 = new Thread(print);
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();

    }

}
