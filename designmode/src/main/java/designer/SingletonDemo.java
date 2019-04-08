package designer;

/**
 * Class SingletonDemo ...
 *
 * @author LiJun
 * Created on 2019/3/21
 */
/*
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo(){}

    public static SingletonDemo getInstance() {
        if(instance == null){
            synchronized (SingletonDemo.class) {
                if(instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }



    */
/*public static synchronized SingletonDemo getInstance() {
        if(instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }*//*

}
*/
/*public class SingletonDemo {
    private static SingletonDemo instance =new SingletonDemo();
    private SingletonDemo(){}

    public static SingletonDemo getInstance() {
        return instance;
    }
}*/

/*
public class SingletonDemo {
    private static class SingletonHolder{
        private static SingletonDemo instance =new SingletonDemo();
    }

    private SingletonDemo(){}

    public static SingletonDemo getInstance() {
        return SingletonHolder.instance;
    }
}*/


public enum SingletonDemo {
    INSTANCE;
    public void getOtherMethod() {
    }
}
class test {
    public static void main(String[] args) {
        SingletonDemo.INSTANCE.getOtherMethod();
    }
}