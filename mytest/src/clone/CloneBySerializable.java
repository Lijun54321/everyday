package clone;


import java.io.*;

/**
 * Class CloneBySerializable ...
 *
 * @author LiJun
 * Created on 2019/3/28
 */


public class CloneBySerializable implements Serializable {
    private class Inner implements Serializable {
        String name;
    }

    private Inner inner;

    public CloneBySerializable(String name) {
        this.inner = new Inner();
        this.inner.name = name;
    }

    public CloneBySerializable myClone() {
        CloneBySerializable cloneBySerializable = null;
        try {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
            out.writeObject(this);

            ByteArrayInputStream input = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(input);

            cloneBySerializable = (CloneBySerializable) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cloneBySerializable;
    }

    @Override
    public String toString() {
        return "CloneBySerializable{" +
                "inner.name=" + inner.name +
                '}';
    }

    private void setName(String name) {
        this.inner.name = name;
    }

    public static void main(String[] args) {
        CloneBySerializable test1 = new CloneBySerializable("test1");
        System.out.println("拷贝前：test1:" + test1);

        CloneBySerializable test2 = test1.myClone();
        System.out.println("拷贝后：test1:" + test1);
        System.out.println("拷贝后：test2:" + test2);
        test2.setName("test2");
        System.out.println("改值后：test1:" + test1);
        System.out.println("改值后：test2:" + test2);


    }
}
