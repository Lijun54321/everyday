package mythread;

/**
 * Class Pool ...
 *
 * @author LiJun
 * Created on 2019/4/10
 */
public interface Pool {
    Executor getExecutor();
    void destroy();
}
