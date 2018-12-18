import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Class BufferTest ...
 *
 * @author LiJun
 * Created on 2018/12/18
 */
public class BufferTest {
    public static void main(String[] args) {
        Buffer<String> buffer = new Buffer<>(12, 9);

        for(int i = 0; i < 12;i++){
            buffer.put(String.valueOf(i));
        }

        System.out.println(buffer);
        for(int i = 0; i < 11; i++){
            System.out.println(buffer.get());
        }
        System.out.println(buffer);
        for(int i = 0; i< 5; i++){
            buffer.put(String.valueOf(i+12));

        }
        System.out.println(buffer);
        for(int i = 0;i < 10;i++){
            System.out.println(buffer.get());
        }
        System.out.println(buffer);

    }
}
