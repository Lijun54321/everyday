import java.util.LinkedList;
import java.util.List;

/**
 * Class Test ...
 *
 * @author LiJun
 * Created on 2019/4/20
 */
public class Test {

    public static void main(String[] args) {
        Object o = new Object();
        o.hashCode();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        /*
        HashSet<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);*/
        for (int i = 0; i < list.size(); i++) {
            if (list.lastIndexOf(list.get(i)) != i) {
                list.remove(list.lastIndexOf(i));
                i--;
            }
        }
        System.out.println(list);
    }
}
