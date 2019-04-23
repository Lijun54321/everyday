package designer.strategy;

/**
 * Class Context ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class Context {
    /**
     * 策略对象
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        this.strategy.strategyInterface();
    }
}
