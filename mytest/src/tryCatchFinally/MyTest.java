package tryCatchFinally;

/**
 * Class MyTest ...
 *
 * @author LiJun
 * Created on 2019/3/28
 */
public class MyTest {


    private static int fun1(){
        try{
            int i = 1/0;
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        System.out.println(fun1());
        System.out.println(fun2());
        System.out.println(fun3());
    }

    private static int fun2() {
        int result = 0;
        try {
            result = 1;
            int i = 1/0;
            return result;
        } catch (Exception e) {
            result = 2;
            return result;
        } finally {
            result = 3;
        }
    }
    static class test{
        String name;

        @Override
        public String toString() {
            return name;
        }
    }
    private static test fun3() {
        test t = new test();
        try {
            t.name = "1";
            int i = 1/0;
            return t;
        } catch (Exception e) {
            t.name = "2";
            return t;
        } finally {
            t.name = "3";
        }
    }

}
