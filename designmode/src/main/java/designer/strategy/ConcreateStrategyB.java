package designer.strategy;

/**
 * Class ConcreteStrategyB ...
 * 具体策略A
 * @author LiJun
 * Created on 2019/4/13
 */
public class ConcreateStrategyB implements Strategy{

    @Override
    public void strategyInterface() {
        System.out.println("This is B!");
    }
}