import java.util.ArrayList;
import java.util.List;

/**
 * Class TestForEach ...
 *
 * @author LiJun
 * Created on 2019/4/4
 */
public class TestForEach {
    public static void main(String[] args) {

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");


        names.forEach(System.out::println);

        boolean a = false;


    }
}
