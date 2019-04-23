package qushi;

/**
 * Class Child ...
 *
 * @author LiJun
 * Created on 2019/4/14
 */
class Parent implements Cloneable {
    private static String str = "continue";
    Integer count;

    public Parent() {
        this.count = 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        synchronized (str) {
            count++;
        }
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        synchronized (str) {
            count--;
            super.finalize();
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

class test extends Parent {
}

public class Child {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Parent p = new test();
        System.out.println(p.getCount());
        Parent p2 = (Parent) p.clone();
        System.out.println(p.getCount());
        Parent p3 = (Parent) p.clone();
        System.out.println(p.getCount());
        p3 = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(p.getCount());
    }

}
