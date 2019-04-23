package mythread;


/**
 * Class Executor ...
 *
 * @author LiJun
 * Created on 2019/4/10
 */
public interface Executor {
    void setTask(Task task);
    Task getTask();
    void startTask();
}
