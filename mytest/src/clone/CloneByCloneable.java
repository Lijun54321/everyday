package clone;

/**
 * Class CloneByCloneable ...
 *
 * @author LiJun
 * Created on 2019/3/28
 */


public class CloneByCloneable implements Cloneable {
    private class Inner implements Cloneable {
        String name;

        @Override
        protected Inner clone() throws CloneNotSupportedException {
            return (Inner) super.clone();
        }
    }

    private int num;
    private Inner inner;

    public CloneByCloneable(int num, String name) {
        this.num = num;
        this.inner = new Inner();
        this.inner.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setInner(String name) {
        this.inner.name = name;
    }

    @Override
    protected CloneByCloneable clone() throws CloneNotSupportedException {
        CloneByCloneable cloneable = null;
        CloneByCloneable clone = (CloneByCloneable) super.clone();
        clone.inner = inner.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "CloneByCloneable{" +
                "num=" + num +
                ", inner.name=" + inner.name +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneByCloneable test1 = new CloneByCloneable(1, "test1");
        // 拷贝前的num值
        System.out.println("拷贝前test1" + test1);

        CloneByCloneable test2 = test1.clone();
        System.out.println("拷贝后test2" + test2);
        // 拷贝后的num值
        test2.setNum(2);
        test2.setInner("test2");
        System.out.println("改值后test1" + test1);
        System.out.println("改值后test2" + test2);
    }
}
