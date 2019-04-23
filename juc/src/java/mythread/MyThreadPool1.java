package mythread;


import java.util.LinkedList;

/**
 * Class mythread.MyThreadPool1 ...
 *
 * @author LiJun
 * Created on 2019/4/10
 */
public class MyThreadPool1 implements Pool {

    private boolean shutdown;
    private LinkedList pool;
    private int size;

    public MyThreadPool1(int size) {
        this.size = size;
        this.shutdown = false;
        this.pool = new LinkedList();
        for (int i = 0; i < size; i++) {
            Executor executor = new ExecutorImpl();
            pool.add(executor);
            ((ExecutorImpl) executor).start();
        }

    }

    @Override
    public Executor getExecutor() {
        Executor ret = null;
        synchronized (pool) {
            if (pool.size() > 0) {
                ret = (Executor) pool.removeFirst();
            } else {
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ret = (Executor) pool.removeFirst();
            }
        }
        return ret;
    }

    @Override
    public void destroy() {
        synchronized (pool) {
            shutdown = true;
            pool.notifyAll();
            pool.clear();
        }
    }

    private class ExecutorImpl extends Thread implements Executor {
        private Task task;
        private Object lock = new Object();

        public ExecutorImpl() {
        }

        @Override
        public void setTask(Task task) {
            this.task = task;
        }

        @Override
        public void startTask() {
            synchronized (lock) {
                lock.notify();
            }
        }

        @Override
        public void run() {
            while (!shutdown) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getTask().execute();
                synchronized (pool) {
                    pool.addFirst(ExecutorImpl.this);
                    pool.notifyAll();
                }
            }
        }

        @Override
        public Task getTask() {
            return task;
        }
    }
}
